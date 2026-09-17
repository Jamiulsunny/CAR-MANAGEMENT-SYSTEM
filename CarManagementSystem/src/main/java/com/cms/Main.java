package com.cms;

import com.cms.database.Database;
import com.cms.view.MainFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Database.init();
        SwingUtilities.invokeLater(() -> {
            try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); } catch(Exception ignored){}
            new MainFrame().setVisible(true);
        });
    }
}
