package repository;



import model.Central;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CentralRepository {
    private Connection connection;

    public CentralRepository(Connection connection) {
        this.connection=connection;
    }

    public boolean updateCentral(Central c) throws SQLException {
        PreparedStatement statement=connection.prepareStatement("UPDATE central SET Temperature = ?, Power = ? WHERE idCentral = 2");
        statement.setInt(1, c.getTemperature());
        statement.setBoolean(2,c.isPower());
        int affectedRows = statement.executeUpdate();
        return affectedRows>0;
    }


    public Central findById(int idCentral) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM central WHERE idCentral = ?");
        statement.setInt(1, idCentral);
        ResultSet rs = statement.executeQuery();

        Central c = null;
        if (rs.next()){
            c = new Central(
                    rs.getInt("idCentral"),
                    rs.getInt("Temperature"),
                    rs.getBoolean("Power")
            );
        }
        return c;
    }
}
