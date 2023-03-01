package repository;

import applicances.Light;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LightRepository {

    private Connection connection;

    public LightRepository(Connection connection) {this.connection=connection;}

    public List<Light> findAll() throws SQLException{
        List<Light> result =new ArrayList<>();
        PreparedStatement statement=connection.prepareStatement("SELECT * FROM light") ;
        ResultSet rs = statement.executeQuery();
        while(rs.next()){
//            Light e=new Light( rs.getBoolean("Column"))
        }
        return result;
    }
}
