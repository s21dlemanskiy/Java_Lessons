



// it is some garbage, that i do not know how it work and i hate it with all my body cell

var update_chart = function(start, end){
    document.querySelector('meta[name="slider_start"]').setAttribute("content", start);
    document.querySelector('meta[name="slider_end"]').setAttribute("content", end);
    var place_id = document.getElementById("place_id").value;
	var table = document.getElementById("table").value;
	var postgres_pass = document.querySelector('meta[name="postgres_pass"]').content;
	var postgres_user = document.querySelector('meta[name="postgres_user"]').content;
    var url = `/get-data?postgres_user=${postgres_user}&postgres_pass=${postgres_pass}&table=${table}&place_id=${place_id}&start=${start}&end=${end}`;
    fetch(url).then((response) => response.json()).then(data => {

        var plot_data = [];
        for ( var i = 0 ; i < data.heights.length - 1; i++ ) {
              var line = {
                        type: 'scattermapbox',
                        lon: [ data.longitude[i], data.longitude[i + 1] ],
                        lat: [ data.latitude[i], data.latitude[i + 1] ],
                        mode: 'lines',
                        line:{
                            width: 2,
                            color: 'blue'
                        }
                  };
              plot_data.push(line);
          };

          var layout = {
              mapbox: {style: 'open-street-map',
                    center: { lat: data.latitude.reduce((a, b) => a + b) / data.latitude.length,
                            lon: data.longitude.reduce((a, b) => a + b) / data.longitude.length},
                    zoom: 14
              },
			  margin: { r: 0, t: 0, b: 0, l: 0 }
          };

          Plotly.newPlot(document.getElementById('myPlot'), plot_data, layout);
      });
};

//garbage
var onChangePlaceId = function(){
        var table = document.getElementById("table").value;
        var postgres_pass = document.querySelector('meta[name="postgres_pass"]').content;
        var postgres_user = document.querySelector('meta[name="postgres_user"]').content;
        var place_id = document.getElementById("place_id").value;
        var url = `/get-balance?postgres_user=${postgres_user}&postgres_pass=${postgres_pass}&table=${table}&place_id=${place_id}`;
        fetch(url).then((response) => response.json()).then(data => {
            var point_count = data.point_count;
            var start = 0;
            var end = Math.min(100, point_count);
             $( function() {
                 $( "#slider-range" ).slider({
                      range: true,
                      min: 0,
                      max: point_count,
                      values: [start, end],
                      slide: function( event, ui ) {
                 //        function for update when slide
                        update_chart(ui.values[0], ui.values[1]);
                      }
                 });
             } );
             update_chart(start, end)
        });
};
// garbage
var changeTable = function(){
	var table = document.getElementById("table").value;
	var postgres_pass = document.querySelector('meta[name="postgres_pass"]').content;
	var postgres_user = document.querySelector('meta[name="postgres_user"]').content;
	var url = `/get-place-id?postgres_user=${postgres_user}&postgres_pass=${postgres_pass}&table=${table}`;
	var place_id_list;
	fetch(url).then((response) => response.json()).then(data => {
            var $el = $("#place_id");
            $el.empty(); // remove old options
            $.each(data.place_id_list, function(index) {
              $el.append($("<option></option>")
                 .attr("value", data.place_id_list[index]).text(data.place_id_list[index]));
            });
            if (data.place_id_list.length == 0){
                alert("Ooops something gone wrong");
                console.log("place_id is empty");
            } else{
                document.getElementById('place_id').value = data.place_id_list[0];
            }

	})
	.then(a => {
	        var place_id = document.getElementById("place_id").value;
            var url = `/get-balance?postgres_user=${postgres_user}&postgres_pass=${postgres_pass}&table=${table}&place_id=${place_id}`;
            fetch(url).then((response) => response.json()).then(data => {
                var point_count = data.point_count;
                var start = 0;
                var end = Math.min(100, point_count);
                 $( function() {
                     $( "#slider-range" ).slider({
                          range: true,
                          min: 0,
                          max: point_count,
                          values: [start, end],
                          slide: function( event, ui ) {
                     //        function for update when slide
                            update_chart(ui.values[0], ui.values[1]);
                          }
                     });
                 } );
                 update_chart(start, end)
            });
	})
	;
};


//garbage
window.onload = function() {
    changeTable();
//    fetch("http://localhost:8080/get-balance?postgres_user=test_user&postgres_pass=test&table=points_history&place_id=1").then(result => alert(result.json()));
};