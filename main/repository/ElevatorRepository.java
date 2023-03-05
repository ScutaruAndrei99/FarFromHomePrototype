package repository;

import model.Elevator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ElevatorRepository {
    private Connection connection;
    public ElevatorRepository(Connection connection) {this.connection=connection;}

    public Elevator findById() throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM elevator WHERE idElevator=7");
        ResultSet rs = statement.executeQuery();

        Elevator elevator = null;
        if(rs.next()){
            elevator = new Elevator(
                    rs.getInt("idElevator"),
                    rs.getInt("Floor"),
                    rs.getBoolean("Doors"),
                    rs.getBoolean("Used")
            );
        }
        return elevator;
    }

    public boolean update(Elevator el) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("UPDATE elevator SET Floor=?, Doors=?, Used=? WHERE idElevator=7");
        statement.setInt(1,el.getFloor());
        statement.setBoolean(2,el.isDoors());
        statement.setBoolean(3,el.isUsed());
        int affectedRows = statement.executeUpdate();
        return affectedRows>0;
    }

}
