package repository;

import model.Channel;
import model.TV;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TVRepository {
    private Connection connection;

    public TVRepository() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectjava", "root", "1234567");
            this.connection = conn;
        } catch(ClassNotFoundException | SQLException exception) {
            System.out.println("Repository-ul nu a putut fi initializat");
            exception.printStackTrace();
        }
    }

    public boolean updateTV(TV tv) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE television SET ChannelPost = ?, ChannelName = ?, Power = ? WHERE idTV = 3");
            statement.setInt(1, tv.getChannelPost());
            statement.setString(2, tv.getChannelName());
            statement.setBoolean(3, tv.isPower());
            int affectedRows = statement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println("Nu s-a putut realiza conexiunea cu repository-ul");
            throw new RuntimeException(e);
        }
    }
    public TV findById(int idTV) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM television WHERE idTV = ?");
            statement.setInt(1, idTV);
            ResultSet rs = statement.executeQuery();

            TV tv = null;
            if (rs.next()) {
                tv = new TV(
                        rs.getInt("idTV"),
                        rs.getInt("ChannelPost"),
                        rs.getString("ChannelName"),
                        rs.getBoolean("Power")
                );
            }
            return tv;
        } catch (SQLException e) {
            System.out.println("Nu s-a putut realiza conexiunea cu repository-ul");
            throw new RuntimeException(e);
        }
    }
    public String findByChannelPost(int channelPost) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT ChannelName1 FROM channel WHERE ChannelPost1 = ?");
            statement.setInt(1, channelPost);
            ResultSet rs = statement.executeQuery();
            String c = String.valueOf(0);
            while (rs.next()) {
                c = rs.getString("ChannelName1").toString();
            }
            return c;
        } catch (SQLException e) {
            System.out.println("Nu s-a putut realiza conexiunea cu repository-ul");
            throw new RuntimeException(e);
        }
    }
    public List<Channel> findAll() {
        try {
            List<Channel> result = new ArrayList<>();

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM channel");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Channel channel = new Channel(
                        rs.getInt("ChannelPost1"),
                        rs.getString("ChannelName1")
                );
                result.add(channel);
            }
            return result;
        } catch (SQLException e) {
            System.out.println("Nu s-a putut realiza conexiunea cu repository-ul");
            throw new RuntimeException(e);
        }
    }

}
