package com.cms.view;

import javax.swing.*;
import java.awt.*;

public class DriverPanel extends JPanel {
    public DriverPanel() {
        setLayout(new BorderLayout());
        add(new JLabel("Driver management - follow VehiclePanel pattern to implement CRUD"), BorderLayout.CENTER);
    }
}
