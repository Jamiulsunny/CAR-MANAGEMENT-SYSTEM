package com.cms.controller;

import com.cms.dao.VehicleDAO;
import com.cms.model.Vehicle;

import java.sql.SQLException;
import java.util.List;

public class VehicleController {
    private VehicleDAO dao = new VehicleDAO();

    public void addVehicle(Vehicle v) throws SQLException { dao.insert(v); }
    public void updateVehicle(Vehicle v) throws SQLException { dao.update(v); }
    public void deleteVehicle(int id) throws SQLException { dao.delete(id); }
    public List<Vehicle> listVehicles() throws SQLException { return dao.getAll(); }
}
