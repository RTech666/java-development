package com.pluralsight;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private Connection connection;

    public DataManager(String dbUrl, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(dbUrl, user, password);
    }

    public int insertShipper(String name, String phone) throws SQLException {
        String sql = "INSERT INTO shippers (CompanyName, Phone) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, name);
            stmt.setString(2, phone);
            stmt.executeUpdate();
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Inserting shipper failed, no ID obtained.");
                }
            }
        }
    }

    public List<Shipper> getAllShippers() throws SQLException {
        List<Shipper> shippers = new ArrayList<>();
        String sql = "SELECT * FROM shippers";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Shipper shipper = new Shipper(rs.getInt("ShipperID"), rs.getString("CompanyName"), rs.getString("Phone"));
                shippers.add(shipper);
            }
        }
        return shippers;
    }

    public void updateShipperPhone(int id, String phone) throws SQLException {
        String sql = "UPDATE shippers SET Phone = ? WHERE ShipperID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, phone);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
    }

    public void deleteShipper(int id) throws SQLException {
        String sql = "DELETE FROM shippers WHERE ShipperID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public void close() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}