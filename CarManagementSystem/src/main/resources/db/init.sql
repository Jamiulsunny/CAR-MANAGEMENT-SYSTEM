PRAGMA foreign_keys = ON;

CREATE TABLE IF NOT EXISTS vehicles (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  model TEXT NOT NULL,
  registration TEXT NOT NULL UNIQUE,
  year INTEGER,
  color TEXT,
  mileage REAL DEFAULT 0
);

CREATE TABLE IF NOT EXISTS drivers (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  name TEXT NOT NULL,
  license_no TEXT NOT NULL UNIQUE,
  phone TEXT,
  assigned_vehicle INTEGER,
  FOREIGN KEY(assigned_vehicle) REFERENCES vehicles(id)
);

CREATE TABLE IF NOT EXISTS bookings (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  vehicle_id INTEGER,
  driver_id INTEGER,
  start_date TEXT,
  end_date TEXT,
  cost REAL,
  paid INTEGER DEFAULT 0,
  FOREIGN KEY(vehicle_id) REFERENCES vehicles(id),
  FOREIGN KEY(driver_id) REFERENCES drivers(id)
);

CREATE TABLE IF NOT EXISTS maintenance (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  vehicle_id INTEGER,
  service_date TEXT,
  description TEXT,
  cost REAL,
  FOREIGN KEY(vehicle_id) REFERENCES vehicles(id)
);

CREATE TABLE IF NOT EXISTS fuel_logs (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  vehicle_id INTEGER,
  date TEXT,
  liters REAL,
  cost REAL,
  mileage REAL,
  FOREIGN KEY(vehicle_id) REFERENCES vehicles(id)
);
