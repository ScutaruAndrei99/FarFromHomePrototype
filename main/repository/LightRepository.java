package repository;

import model.Light;

import java.sql.*;

public class LightRepository {

    private Connection connection;

    public LightRepository() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectjava", "root", "1234567");
            this.connection = conn;
        } catch(ClassNotFoundException | SQLException exception) {
            System.out.println("Repository-ul nu a putut fi initializat");
            exception.printStackTrace();
        }
    }
    // TODO initializarea nu ar trebui sa fie facuta de constructor
    public Light findById() {
        try {
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
        } catch (SQLException e) {
            System.out.println("Nu s-a putut realiza conexiunea cu repository-ul");
            throw new RuntimeException(e);
        }
    }
    public boolean updateLight(Light light) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE light SET Bathroom = ?, Bedroom = ?, Kitchen = ?, Hall = ?, LivingRoom = ?, Dressing = ?, Boiler = ? WHERE idLight = 4");
            statement.setBoolean(1, light.isBathroom());
            statement.setBoolean(2, light.isBedroom());
            statement.setBoolean(3, light.isKitchen());
            statement.setBoolean(4, light.isHall());
            statement.setBoolean(5, light.isLivingRoom());
            statement.setBoolean(6, light.isDressing());
            statement.setBoolean(7, light.isBoiler());
            int affectedRows = statement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println("Nu s-a putut realiza conexiunea cu repository-ul");
            throw new RuntimeException(e);
        }
    }

}
