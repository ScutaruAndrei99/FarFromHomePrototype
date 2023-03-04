package repository;

import model.Vacuum;
import service.VacuumService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VacuumRepository {
    private Connection connection;
    public VacuumRepository(Connection connection) {this.connection=connection;}

    public Vacuum findById() throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM vacuum WHERE idVacuum=6");
        ResultSet rs = statement.executeQuery();

        Vacuum vacuum = null;
        if (rs.next()) {
            vacuum = new Vacuum(
            rs.getInt("idVacuum"),
            rs.getBoolean("Power")
            );
        }
        return vacuum;
    }

    public boolean updateVacuum(Vacuum vacuum) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("UPDATE vacuum SET Power=? WHERE idVacuum=6");
        statement.setBoolean(1,vacuum.isPowerVacuum());
        int affectedRows = statement.executeUpdate();
        return affectedRows>0;
    }
}
