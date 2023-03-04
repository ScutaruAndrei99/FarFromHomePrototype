package repository;

import model.Curtains;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CurtainsRepository {
    private Connection connection;
    public CurtainsRepository(Connection connection) {this.connection=connection;}

    public Curtains findById() throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM curtains WHERE idCurtains = 5");
        ResultSet rs = statement.executeQuery();

        Curtains curtains = null;
        if(rs.next()){
            curtains = new Curtains(
                    rs.getInt("idCurtains"),
                    rs.getBoolean("Bathroom"),
                    rs.getBoolean("Bedroom"),
                    rs.getBoolean("Kitchen"),
                    rs.getBoolean("Hall"),
                    rs.getBoolean("LivingRoom"),
                    rs.getBoolean("Dressing")
            );
        }
        return curtains;
    }

    public boolean updateCurtains(Curtains curtains) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("UPDATE curtains SET Bathroom = ?, Bedroom = ?, Kitchen = ?, Hall = ?, LivingRoom = ?, Dressing = ? WHERE idCurtains=5");
        statement.setBoolean(1,curtains.isBathroom());
        statement.setBoolean(2,curtains.isBedroom());
        statement.setBoolean(3,curtains.isKitchen());
        statement.setBoolean(4,curtains.isHall());
        statement.setBoolean(5,curtains.isLivingRoom());
        statement.setBoolean(6,curtains.isDressing());
        int affectedRows = statement.executeUpdate();
        return affectedRows > 0;
    }
}
