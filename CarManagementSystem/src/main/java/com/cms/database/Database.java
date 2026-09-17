package com.cms.database;

import java.sql.*;
import java.nio.file.*;

public class Database {
    private static final String DB_FILE = "cms.db";
    private static final String URL = "jdbc:sqlite:" + DB_FILE;

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void init() {
        try {
            Path path = Paths.get(DB_FILE);
            if (!Files.exists(path)) {
                Files.createFile(path);
                System.out.println("✅ New database created: " + DB_FILE);
            }
            try (Connection conn = getConnection(); Statement st = conn.createStatement()) {
                st.execute("PRAGMA foreign_keys = ON;");
                // create tables if not exist (idempotent)
                st.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS vehicles(
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        model TEXT NOT NULL,
                        registration TEXT NOT NULL UNIQUE,
                        year INTEGER,
                        color TEXT,
                        mileage REAL DEFAULT 0
                    );
                """);
                st.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS drivers(
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        name TEXT NOT NULL,
                        license_no TEXT NOT NULL UNIQUE,
                        phone TEXT,
                        assigned_vehicle INTEGER,
                        FOREIGN KEY(assigned_vehicle) REFERENCES vehicles(id)
                    );
                """);
            }
            System.out.println("✅ Database initialized successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
