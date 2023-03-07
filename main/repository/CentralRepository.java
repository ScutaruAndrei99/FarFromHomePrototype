package repository;



import model.Central;

import java.sql.*;

public class CentralRepository {
    private Connection connection;

    public CentralRepository() {
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
    public boolean updateCentral(Central c) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE central SET Temperature = ?, Power = ? WHERE idCentral = 2");
            statement.setInt(1, c.getTemperature());
            statement.setBoolean(2, c.isPower());
            int affectedRows = statement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println("Nu s-a putut realiza conexiunea cu repository-ul");
            throw new RuntimeException(e);
        }
    }


    public Central findById(int idCentral) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM central WHERE idCentral = ?");
            statement.setInt(1, idCentral);
            ResultSet rs = statement.executeQuery();

            Central c = null;
            if (rs.next()) {
                c = new Central(
                        rs.getInt("idCentral"),
                        rs.getInt("Temperature"),
                        rs.getBoolean("Power")
                );
            }
            return c;
        } catch (SQLException e) {
            System.out.println("Nu s-a putut realiza conexiunea cu repository-ul");
            throw new RuntimeException(e);
        }
    }
}
