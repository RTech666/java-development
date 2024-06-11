package com.pluralsight;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private Connection connection;

    public DataManager(String dbUrl, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(dbUrl, user, password);
    }

    // Create getCustomerOrderHistory method.
    public List<CustomerOrderHistory> getCustomerOrderHistory(String customerId) throws SQLException {
        List<CustomerOrderHistory> history = new ArrayList<>();
        CallableStatement stmt = connection.prepareCall("{CALL CustOrderHist(?)}");
        stmt.setString(1, customerId);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            history.add(new CustomerOrderHistory(rs.getString("ProductName"), rs.getInt("Total")));
        }
        return history;
    }

    // Create getSalesByYear method.
    public List<SalesByYear> getSalesByYear(Date startDate, Date endDate) throws SQLException {
        List<SalesByYear> sales = new ArrayList<>();
        CallableStatement stmt = connection.prepareCall("{CALL `Sales by Year`(?, ?)}");
        stmt.setDate(1, startDate);
        stmt.setDate(2, endDate);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            sales.add(new SalesByYear(rs.getDate("ShippedDate"), rs.getInt("OrderID"), rs.getDouble("Subtotal")));
        }
        return sales;
    }

    // Create getSalesByCategory method.
    public List<SalesByCategory> getSalesByCategory(String category, String year) throws SQLException {
        List<SalesByCategory> sales = new ArrayList<>();
        CallableStatement stmt = connection.prepareCall("{CALL SalesByCategory(?, ?)}");
        stmt.setString(1, category);
        stmt.setString(2, year);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            sales.add(new SalesByCategory(rs.getString("ProductName"), rs.getDouble("TotalPurchase")));
        }
        return sales;
    }
}