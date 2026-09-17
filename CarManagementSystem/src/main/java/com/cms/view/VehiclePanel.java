package com.cms.view;

import com.cms.controller.VehicleController;
import com.cms.model.Vehicle;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;

public class VehiclePanel extends JPanel {
    private VehicleController controller = new VehicleController();
    private JTable table;
    private DefaultTableModel model;

    public VehiclePanel() {
        setLayout(new BorderLayout(10,10));

        JPanel form = new JPanel(new GridLayout(2,6,5,5));
        JTextField tfModel = new JTextField();
        JTextField tfReg = new JTextField();
        JTextField tfYear = new JTextField();
        JTextField tfColor = new JTextField();
        JTextField tfMileage = new JTextField();

        form.add(new JLabel("Model")); form.add(tfModel);
        form.add(new JLabel("Reg No")); form.add(tfReg);
        form.add(new JLabel("Year")); form.add(tfYear);
        form.add(new JLabel("Color")); form.add(tfColor);
        form.add(new JLabel("Mileage")); form.add(tfMileage);
        add(form, BorderLayout.NORTH);

        model = new DefaultTableModel(new Object[]{"ID","Model","Reg","Year","Color","Mileage"},0){
            public boolean isCellEditable(int r,int c){return false;}
        };
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel btnPanel = new JPanel();
        JButton btnAdd = new JButton("Add");
        JButton btnUpdate = new JButton("Update");
        JButton btnDelete = new JButton("Delete");
        btnPanel.add(btnAdd); btnPanel.add(btnUpdate); btnPanel.add(btnDelete);
        add(btnPanel, BorderLayout.SOUTH);

        btnAdd.addActionListener(e -> {
            try {
                Vehicle v = new Vehicle();
                v.setModel(tfModel.getText());
                v.setRegistration(tfReg.getText());
                v.setYear(Integer.parseInt(tfYear.getText()));
                v.setColor(tfColor.getText());
                v.setMileage(Double.parseDouble(tfMileage.getText()));
                controller.addVehicle(v);
                refresh();
                JOptionPane.showMessageDialog(this,"Vehicle Added!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,"❌ Error: "+ex.getMessage());
            }
        });

        btnUpdate.addActionListener(e -> {
            int row = table.getSelectedRow();
            if(row == -1){ JOptionPane.showMessageDialog(this,"Select a vehicle!"); return; }
            try{
                Vehicle v = new Vehicle();
                v.setId(Integer.parseInt(model.getValueAt(row,0).toString()));
                v.setModel(tfModel.getText());
                v.setRegistration(tfReg.getText());
                v.setYear(Integer.parseInt(tfYear.getText()));
                v.setColor(tfColor.getText());
                v.setMileage(Double.parseDouble(tfMileage.getText()));
                controller.updateVehicle(v);
                refresh();
                JOptionPane.showMessageDialog(this,"✅ Updated!");
            }catch(Exception ex){ JOptionPane.showMessageDialog(this,"Error: "+ex.getMessage()); }
        });

        btnDelete.addActionListener(e -> {
            int row = table.getSelectedRow();
            if(row == -1){ JOptionPane.showMessageDialog(this,"Select a row!"); return; }
            int id = Integer.parseInt(model.getValueAt(row,0).toString());
            try{
                controller.deleteVehicle(id);
                refresh();
                JOptionPane.showMessageDialog(this,"🗑️ Deleted!");
            }catch(SQLException ex){ JOptionPane.showMessageDialog(this,"Error: "+ex.getMessage()); }
        });

        table.getSelectionModel().addListSelectionListener(e -> {
            int row = table.getSelectedRow();
            if(row==-1)return;
            tfModel.setText(model.getValueAt(row,1).toString());
            tfReg.setText(model.getValueAt(row,2).toString());
            tfYear.setText(model.getValueAt(row,3).toString());
            tfColor.setText(model.getValueAt(row,4).toString());
            tfMileage.setText(model.getValueAt(row,5).toString());
        });

        refresh();
    }

    private void refresh(){
        try{
            model.setRowCount(0);
            for(Vehicle v : controller.listVehicles()){
                model.addRow(new Object[]{
                        v.getId(),v.getModel(),v.getRegistration(),v.getYear(),v.getColor(),v.getMileage()
                });
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,"Error: "+ex.getMessage());
        }
    }
}
