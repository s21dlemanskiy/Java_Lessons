package org.example.DAO;
import org.example.Model.Director;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DirectorDAO {
    private final Connection connection;

    public DirectorDAO(Connection connection) {
        this.connection = connection;
    }
    public void insert (Director director) throws SQLException{
        String querty = "INSERT INTO director (name) values (?)";
        PreparedStatement pst = this.connection.prepareStatement(querty);
        pst.setString(1, director.getName());
        pst.execute();
    }

    public List<Director> getAll() throws SQLException{
        String selectAll = "SELECT * FROM director";
        PreparedStatement pst = connection.prepareStatement(selectAll);
        ResultSet resultSet = pst.executeQuery();
        List<Director> list = new ArrayList<>();
        while (resultSet.next()){
            Integer id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            Director director = new Director(id, name);
            list.add(director);
        }
        return list;
    }
}
