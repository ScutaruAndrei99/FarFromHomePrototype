package repository;


import model.Espressor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EspressorRepository {

    private Connection connection;

    public EspressorRepository() {
        initialize();
    }
    // TODO initializarea nu ar trebui sa fie facuta de constructor

    public void initialize() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectjava", "root", "1234567");
            this.connection = conn;
        } catch(ClassNotFoundException | SQLException exception) {
            System.out.println("Repository-ul nu a putut fi initializat");
            exception.printStackTrace();
        }
    }

    public List<Espressor> findAll() {
        try {
            List<Espressor> result = new ArrayList<>();

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM espressor");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Espressor e = new Espressor(
                        rs.getLong("idEspressor"),
                        rs.getLong("ShotCoffe"),
                        rs.getLong("ShotWater"),
                        rs.getLong("ShotMilk")
                );
                result.add(e);
            }
            return result;
        } catch (SQLException e) {
            System.out.println("Nu s-a putut realiza conexiunea cu repository-ul");
            throw new RuntimeException(e);
        }
    }

    public boolean update(Espressor er) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE espressor SET ShotCoffe = ?, ShotWater = ?, ShotMilk = ? WHERE idEspressor = 1");
            statement.setLong(1, er.getShotCoffe());
            statement.setLong(2, er.getShotWater());
            statement.setLong(3, er.getShotMilk());
            int affectedRows = statement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println("Nu s-a putut realiza conexiunea cu repository-ul");
            throw new RuntimeException(e);
        }
    }

    public boolean updateRefill() {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE espressor SET ShotCoffe = ?, ShotWater = ?, ShotMilk = ? WHERE idEspressor = 1");
            statement.setLong(1, 10);
            statement.setLong(2, 10);
            statement.setLong(3, 10);
            int affectedRows = statement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println("Nu s-a putut realiza conexiunea cu repository-ul");
            throw new RuntimeException(e);
        }
    }

    public Espressor findById(int idEspressor) {
        try {
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
        } catch (SQLException e) {
            System.out.println("Nu s-a putut realiza conexiunea cu repository-ul");
            throw new RuntimeException(e);
        }
    }
}
