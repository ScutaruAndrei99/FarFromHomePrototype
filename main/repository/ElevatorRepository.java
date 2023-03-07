package repository;

import model.Elevator;

import java.sql.*;

public class ElevatorRepository {
    private Connection connection;
    public ElevatorRepository() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectjava", "root", "1234567");
            this.connection = conn;
        } catch(ClassNotFoundException | SQLException exception) {
            System.out.println("Repository-ul nu a putut fi initializat");
            exception.printStackTrace();
        }
    }

    public Elevator findById() {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM elevator WHERE idElevator=7");
            ResultSet rs = statement.executeQuery();

            Elevator elevator = null;
            if (rs.next()) {
                elevator = new Elevator(
                        rs.getInt("idElevator"),
                        rs.getInt("Floor"),
                        rs.getBoolean("Doors"),
                        rs.getBoolean("Used")
                );
            }
            return elevator;
        } catch (SQLException e) {
            System.out.println("Nu s-a putut realiza conexiunea cu repository-ul");
            throw new RuntimeException(e);
        }
    }

    public boolean update(Elevator el) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE elevator SET Floor=?, Doors=?, Used=? WHERE idElevator=7");
            statement.setInt(1, el.getFloor());
            statement.setBoolean(2, el.isDoors());
            statement.setBoolean(3, el.isUsed());
            int affectedRows = statement.executeUpdate();
            return affectedRows > 0;
        }catch (SQLException e) {
            System.out.println("Nu s-a putut realiza conexiunea cu repository-ul");
            throw new RuntimeException(e);
        }
    }
}
