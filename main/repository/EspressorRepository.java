package repository;


import model.Espressor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EspressorRepository {



    private Connection connection;

    public EspressorRepository(Connection connection) {
        this.connection=connection;
    }

    public List<Espressor> findAll() throws SQLException {


        List<Espressor> result = new ArrayList<>();

        PreparedStatement statement = connection.prepareStatement("SELECT * FROM espressor");
        ResultSet rs = statement.executeQuery();

        while(rs.next()){
            Espressor e=new Espressor(
                    rs.getLong("idEspressor"),
                    rs.getLong("ShotCoffe"),
                    rs.getLong("ShotWater"),
                    rs.getLong("ShotMilk")
            );
            result.add(e);
        }
        return result;
    }

    public boolean update(Espressor er) throws SQLException {
        PreparedStatement statement=connection.prepareStatement("UPDATE espressor SET ShotCoffe = ?, ShotWater = ?, ShotMilk = ? WHERE idEspressor = 1");
        statement.setLong(1, er.getShotCoffe());
        statement.setLong(2, er.getShotWater());
        statement.setLong(3, er.getShotMilk());
        int affectedRows = statement.executeUpdate();
        return affectedRows>0;
    }

    public boolean updateRefill() throws SQLException{
        PreparedStatement statement=connection.prepareStatement("UPDATE espressor SET ShotCoffe = ?, ShotWater = ?, ShotMilk = ? WHERE idEspressor = 1");
        statement.setLong(1, 10);
        statement.setLong(2, 10);
        statement.setLong(3, 10);
        int affectedRows = statement.executeUpdate();
        return affectedRows>0;
    }

    public Espressor findById(int idEspressor) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM espressor where idEspressor = ?");
        statement.setInt(1, idEspressor);
        ResultSet rs = statement.executeQuery();

        Espressor e = null;
        if (rs.next()) {
            e = new Espressor(
                    rs.getLong("idEspressor"),
                    rs.getLong("ShotCoffe"),
                    rs.getLong("ShotWater"),
                    rs.getLong("ShotMilk")
            );
        }
        return e;
    }
}
