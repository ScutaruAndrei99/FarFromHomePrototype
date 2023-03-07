package repository;

import model.Curtains;

import java.sql.*;

public class CurtainsRepository {
    private Connection connection;
    public CurtainsRepository() {
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

    public Curtains findById() {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM curtains WHERE idCurtains = 5");
            ResultSet rs = statement.executeQuery();

            Curtains curtains = null;
            if (rs.next()) {
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
        } catch (SQLException e) {
            System.out.println("Nu s-a putut realiza conexiunea cu repository-ul");
            throw new RuntimeException(e);
        }
    }

    public boolean updateCurtains(Curtains curtains) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE curtains SET Bathroom = ?, Bedroom = ?, Kitchen = ?, Hall = ?, LivingRoom = ?, Dressing = ? WHERE idCurtains=5");
            statement.setBoolean(1, curtains.isBathroom());
            statement.setBoolean(2, curtains.isBedroom());
            statement.setBoolean(3, curtains.isKitchen());
            statement.setBoolean(4, curtains.isHall());
            statement.setBoolean(5, curtains.isLivingRoom());
            statement.setBoolean(6, curtains.isDressing());
            int affectedRows = statement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println("Nu s-a putut realiza conexiunea cu repository-ul");
            throw new RuntimeException(e);
        }
    }
}
