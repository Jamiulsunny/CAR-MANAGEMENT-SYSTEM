package com.cms.dao;

import com.cms.database.Database;
import com.cms.model.Vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAO {
    public void insert(Vehicle v) throws SQLException {
        String sql = "INSERT INTO vehicles(model, registration, year, color, mileage) VALUES(?,?,?,?,?)";
        try (Connection c = Database.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, v.getModel());
            ps.setString(2, v.getRegistration());
            ps.setInt(3, v.getYear());
            ps.setString(4, v.getColor());
            ps.setDouble(5, v.getMileage());
            ps.executeUpdate();
            System.out.println("✅ Vehicle added: " + v.getModel());
        }
    }

    public void update(Vehicle v) throws SQLException {
        String sql = "UPDATE vehicles SET model=?, registration=?, year=?, color=?, mileage=? WHERE id=?";
        try (Connection c = Database.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, v.getModel());
            ps.setString(2, v.getRegistration());
            ps.setInt(3, v.getYear());
            ps.setString(4, v.getColor());
            ps.setDouble(5, v.getMileage());
            ps.setInt(6, v.getId());
            ps.executeUpdate();
            System.out.println("✅ Vehicle updated ID=" + v.getId());
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM vehicles WHERE id=?";
        try (Connection c = Database.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("🗑️ Vehicle deleted ID=" + id);
        }
    }

    public List<Vehicle> getAll() throws SQLException {
        List<Vehicle> list = new ArrayList<>();
        String sql = "SELECT * FROM vehicles";
        try (Connection c = Database.getConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Vehicle(
                        rs.getInt("id"),
                        rs.getString("model"),
                        rs.getString("registration"),
                        rs.getInt("year"),
                        rs.getString("color"),
                        rs.getDouble("mileage")
                ));
            }
        }
        return list;
    }
}
