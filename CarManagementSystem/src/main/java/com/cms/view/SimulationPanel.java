package com.cms.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimulationPanel extends JPanel {
    private Color carColor = Color.RED;
    private int carX = 20;
    private int carY = 60;
    private Timer timer;
    private boolean auto = false;

    public SimulationPanel() {
        setLayout(new BorderLayout());
        DrawingPanel dp = new DrawingPanel();
        add(dp, BorderLayout.CENTER);

        JPanel controls = new JPanel();
        JButton btnColor = new JButton("Change Color");
        JToggleButton tglAuto = new JToggleButton("Auto-Drive");
        controls.add(btnColor);
        controls.add(tglAuto);
        add(controls, BorderLayout.SOUTH);

        btnColor.addActionListener(e -> {
            Color c = JColorChooser.showDialog(this, "Pick Car Color", carColor);
            if (c != null) { carColor = c; dp.repaint(); }
        });

        tglAuto.addActionListener(e -> {
            auto = tglAuto.isSelected();
            if (auto) startTimer(dp); else stopTimer();
        });

        dp.setFocusable(true);
        dp.addKeyListener(new java.awt.event.KeyAdapter(){
            public void keyPressed(java.awt.event.KeyEvent e) {
                int k = e.getKeyCode();
                if (k == java.awt.event.KeyEvent.VK_LEFT) carX -= 10;
                if (k == java.awt.event.KeyEvent.VK_RIGHT) carX += 10;
                if (k == java.awt.event.KeyEvent.VK_UP) carY -= 10;
                if (k == java.awt.event.KeyEvent.VK_DOWN) carY += 10;
                dp.repaint();
            }
        });
    }

    private void startTimer(DrawingPanel dp) {
        timer = new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                carX += 8;
                if (carX > dp.getWidth()) carX = -80;
                dp.repaint();
            }
        });
        timer.start();
    }

    private void stopTimer() { if (timer != null) timer.stop(); }

    class DrawingPanel extends JPanel {
        public DrawingPanel() { setPreferredSize(new Dimension(600,300)); }
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (int x=0;x<getWidth();x+=40) g.drawLine(x,0,x,getHeight());
            for (int y=0;y<getHeight();y+=40) g.drawLine(0,y,getWidth(),y);
            g.setColor(carColor);
            g.fillRect(carX, carY, 80, 30);
            g.setColor(Color.BLACK);
            g.fillOval(carX+5, carY+25, 20, 20);
            g.fillOval(carX+55, carY+25, 20, 20);
        }
    }
}
