package repository;

import model.Gate;

import java.sql.*;

public class GateRepository {
    private Connection connection;
    public GateRepository(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectjava", "root", "1234567");
            this.connection = conn;
        } catch(ClassNotFoundException | SQLException exception) {
            System.out.println("Repository-ul nu a putut fi initializat");
            exception.printStackTrace();
        }
    }

    public Gate findByID() {
        ResultSet rs;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM gate WHERE idGate = 8");
            rs = statement.executeQuery();
            Gate gate = null;
            if(rs.next()){
                gate = new Gate(
                        rs.getInt("idGate"),
                        rs.getBoolean("Open"),
                        rs.getBoolean("Status")
                );
            }
            return gate;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean update(Gate gate){
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE gate SET Open=?,Status=? WHERE idGate=8");
            statement.setBoolean(1,gate.isOpen());
            statement.setBoolean(2,gate.isStatus());
            int affectedRows = statement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println("Nu s-a putut realiza conexiunea cu repository-ul");
            throw new RuntimeException(e);
        }

    }
}
