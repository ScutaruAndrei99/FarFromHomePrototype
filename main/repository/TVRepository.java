package repository;

import model.Channel;
import model.TV;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TVRepository {
    private Connection connection;

    public TVRepository(Connection connection) {this.connection=connection;}

    public boolean updateTV(TV tv) throws SQLException {
        PreparedStatement statement=connection.prepareStatement("UPDATE television SET ChannelPost = ?, ChannelName = ?, Power = ? WHERE idTV =3");
        statement.setInt(1,tv.getChannelPost());
        statement.setString(2,tv.getChannelName());
        statement.setBoolean(3, tv.isPower());
        int affectedRows = statement.executeUpdate();
        return affectedRows>0;
    }
    public TV findById(int idTV) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM television WHERE idTV = ?");
        statement.setInt(1,idTV);
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
    }
    public model.Channel findByChannelPost(int channelPost) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT ChannelName1 FROM channel WHERE ChannelPost1 = ?");
        statement.setInt(1,channelPost);
        ResultSet rs = statement.executeQuery();

        Channel channel = null;
        if(rs.next()) {
            channel = new Channel(
            rs.getInt("ChannelPost1"),
            rs.getString("ChannelName1")
            );
        }
//        String a = rs.getString("ChannelName1");
        return channel;
    }

//    public Channel extractCharFromBaseData(int channelPost) throws SQLException {
//        PreparedStatement statement = connection.prepareStatement("SELECT ChannelName1 FROM channel WHERE ChannelPost1 = ?");
//        statement.setInt(1,channelPost);
//        ResultSet rs = statement.executeQuery();
//
//        while (rs.next()) {
//            a = rs.getString("ChannelName1").charAt(0);
//            System.out.println("Caracterul extras este: " + a);
//        }
//        return a;
//    }
}
