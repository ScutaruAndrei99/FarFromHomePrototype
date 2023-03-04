package repository;

import model.Light;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LightRepository {

    private Connection connection;

    public LightRepository(Connection connection) {this.connection=connection;}

    public Light findById() throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM light WHERE idLight = 4");
        ResultSet rs = statement.executeQuery();

        Light light = null;
        if (rs.next()) {
            light = new Light(
                    rs.getInt("idLight"),
                    rs.getBoolean("Bathroom"),
                    rs.getBoolean("Bedroom"),
                    rs.getBoolean("Kitchen"),
                    rs.getBoolean("Hall"),
                    rs.getBoolean("LivingRoom"),
                    rs.getBoolean("Dressing"),
                    rs.getBoolean("Boiler")
            );
        }
        return light;
    }
    public boolean updateLight(Light light) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("UPDATE light SET Bathroom = ?, Bedroom = ?, Kitchen = ?, Hall = ?, LivingRoom = ?, Dressing = ?, Boiler = ? WHERE idLight = 4");
        statement.setBoolean(1,light.isBathroom());
        statement.setBoolean(2,light.isBedroom());
        statement.setBoolean(3,light.isKitchen());
        statement.setBoolean(4,light.isHall());
        statement.setBoolean(5,light.isLivingRoom());
        statement.setBoolean(6,light.isDressing());
        statement.setBoolean(7,light.isBoiler());
        int affectedRows = statement.executeUpdate();
        return affectedRows > 0;
    }

}
