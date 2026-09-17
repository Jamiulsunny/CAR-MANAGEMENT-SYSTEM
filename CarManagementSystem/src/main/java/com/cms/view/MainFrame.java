package com.cms.view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JPanel sidebar;
    private JPanel content;

    public MainFrame() {
        setTitle("Car Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        sidebar = new JPanel();
        sidebar.setLayout(new GridLayout(10, 1, 5, 5));
        sidebar.setPreferredSize(new Dimension(200, 0));

        JButton btnDashboard = new JButton("Dashboard");
        JButton btnVehicles = new JButton("Vehicles");
        JButton btnDrivers = new JButton("Drivers");
        JButton btnBookings = new JButton("Bookings");
        JButton btnMaintenance = new JButton("Maintenance");
        JButton btnFuel = new JButton("Fuel");
        JButton btnReports = new JButton("Reports");
        JButton btnSimulation = new JButton("Simulation");

        sidebar.add(btnDashboard);
        sidebar.add(btnVehicles);
        sidebar.add(btnDrivers);
        sidebar.add(btnBookings);
        sidebar.add(btnMaintenance);
        sidebar.add(btnFuel);
        sidebar.add(btnReports);
        sidebar.add(btnSimulation);

        add(sidebar, BorderLayout.WEST);

        content = new JPanel(new BorderLayout());
        add(content, BorderLayout.CENTER);

        // initial view
        showDashboard();

        btnDashboard.addActionListener(e -> showDashboard());
        btnVehicles.addActionListener(e -> showVehicles());
        btnDrivers.addActionListener(e -> showDrivers());
        btnBookings.addActionListener(e -> showBookings());
        btnMaintenance.addActionListener(e -> showMaintenance());
        btnFuel.addActionListener(e -> showFuel());
        btnReports.addActionListener(e -> showReports());
        btnSimulation.addActionListener(e -> showSimulation());
    }

    private void setContentPanel(JPanel p) {
        content.removeAll();
        content.add(p, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }

    private void showDashboard() { setContentPanel(new DashboardPanel()); }
    private void showVehicles() { setContentPanel(new VehiclePanel()); }
    private void showDrivers() { setContentPanel(new DriverPanel()); }
    private void showBookings() { setContentPanel(new JPanel(new BorderLayout())); }
    private void showMaintenance() { setContentPanel(new JPanel(new BorderLayout())); }
    private void showFuel() { setContentPanel(new JPanel(new BorderLayout())); }
    private void showReports() { setContentPanel(new JPanel(new BorderLayout())); }
    private void showSimulation() { setContentPanel(new SimulationPanel()); }
}
