package com.cms.view;

import javax.swing.*;
import java.awt.*;

public class DashboardPanel extends JPanel {
    public DashboardPanel() {
        setLayout(new BorderLayout());
        JPanel top = new JPanel(new GridLayout(1, 3, 10, 10));
        top.add(card("Total Vehicles", "--"));
        top.add(card("Drivers", "--"));
        top.add(card("Active Bookings", "--"));
        add(top, BorderLayout.NORTH);

        JTextArea info = new JTextArea("Welcome to Car Management System. Use the sidebar to navigate.");
        info.setEditable(false);
        add(info, BorderLayout.CENTER);
    }

    private JPanel card(String title, String value) {
        JPanel p = new JPanel(new BorderLayout());
        p.setBorder(BorderFactory.createTitledBorder(title));
        JLabel lbl = new JLabel(value, SwingConstants.CENTER);
        lbl.setFont(lbl.getFont().deriveFont(28f));
        p.add(lbl, BorderLayout.CENTER);
        return p;
    }
}
