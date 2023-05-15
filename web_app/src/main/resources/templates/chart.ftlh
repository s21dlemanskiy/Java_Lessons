<!DOCTYPE html>
<html>
    <head>
        <meta name="postgres_pass" content="${postgres_pass}">
        <meta name="postgres_user" content="${postgres_user}">
        <meta name="slider_start" content="">
        <meta name="slider_end" content="">
        <link rel="stylesheet" href="https://code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
        <script src="https://cdn.plot.ly/plotly-2.20.0.min.js" charset="utf-8"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
        <script src="visual_main.js"></script>
    </head>
    <body>
    <select name="data_base" id="table"  onchange="changeTable()">
        <#list tables as table>
        <option value="${table}">${table}</option>
        </#list>
    </select>

    <select id="place_id" onchange="onChangePlaceId()"><!--  Here javascript insert data from /get-place-id --></select>
    <div id="slider-range"></div>
    <br>
    <div id="myPlot"></div>
    </body>
</html>