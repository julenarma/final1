package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Conector;
import model.bean.Customer;
import model.bean.Vehicle;

public class VehiclesModel extends Conector {

	public ArrayList<Vehicle> SelectAll() {

		ArrayList<Vehicle> vehiculos = new ArrayList();
		Vehicle vehiculo = new Vehicle();
		CustomerModel mc = new CustomerModel();

		try {
			PreparedStatement pst = super.conexion.prepareStatement("Select * from vehicles");
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				vehiculo.setId(rs.getInt("id"));
				vehiculo.setPlate(rs.getString("plate"));
				vehiculo.setBrand(rs.getString("brand"));
				vehiculo.setModel(rs.getString("model"));
				vehiculo.setColor(rs.getString("color"));
				vehiculo.setCustomer(mc.Select(rs.getInt("customer")));

				vehiculos.add(vehiculo);

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return vehiculos;

	}

	public void Update(Vehicle vehiculo) {

		CustomerModel mc = new CustomerModel();

		try {

			PreparedStatement pst = super.conexion.prepareStatement(
					"update from vehicles set plate=?, brand=?, model=?, color=?, customer=? where id=?");

			pst.setString(1, vehiculo.getPlate());
			pst.setString(2, vehiculo.getBrand());

			pst.setString(3, vehiculo.getModel());

			pst.setString(4, vehiculo.getColor());
			pst.setInt(5, vehiculo.getCustomer().getIdCustomer());

			pst.setInt(6, vehiculo.getId());

			pst.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

	public void Insert(Vehicle vehiculo) {

		CustomerModel mc = new CustomerModel();

		try {

			PreparedStatement pst = super.conexion.prepareStatement("Insert into  vehicles  (plate, brand, model,color,customer) values(?,?,?,?,?)");

			pst.setString(1, vehiculo.getPlate());
			pst.setString(2, vehiculo.getBrand());

			pst.setString(3, vehiculo.getModel());

			pst.setString(4, vehiculo.getColor());
			pst.setInt(5, vehiculo.getCustomer().getIdCustomer());
			

			pst.execute();

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

	public boolean ExistID(Vehicle vehiculo) {

		CustomerModel mc = new CustomerModel();
		boolean devolver = false;

		try {
			PreparedStatement pst = super.conexion.prepareStatement("select * from vehicles where id=?");
			pst.setInt(1, vehiculo.getId());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				devolver = true;
			} else {

				devolver = false;
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return devolver;

	}

	public boolean ExistPlate(Vehicle vehiculo) {

		CustomerModel mc = new CustomerModel();
		boolean devolver = false;

		try {
			PreparedStatement pst = super.conexion.prepareStatement("select * from vehicles where plate=?");
			pst.setString(1, vehiculo.getPlate());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				devolver = true;
			} else {

				devolver = false;
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return devolver;

	}

	public boolean ExistBrand(Vehicle vehiculo) {

		CustomerModel mc = new CustomerModel();
		boolean devolver = false;

		
		
		try {
			PreparedStatement pst = super.conexion.prepareStatement("select * from vehicles where brand=?");
			pst.setString(1, vehiculo.getBrand());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				devolver = true;
			} else {

				devolver = false;
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return devolver;

	}

	
	
	public boolean ExistModel(Vehicle vehiculo) {

		CustomerModel mc = new CustomerModel();
		boolean devolver = false;

		try {
			PreparedStatement pst = super.conexion.prepareStatement("select * from vehicles where model=?");
			pst.setString(1, vehiculo.getModel());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				devolver = true;
			} else {

				devolver = false;
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return devolver;

	}

	
	public boolean ExistColor(Vehicle vehiculo) {

		CustomerModel mc = new CustomerModel();
		boolean devolver = false;

		try {
			PreparedStatement pst = super.conexion.prepareStatement("select * from vehicles where color=?");
			pst.setString(1, vehiculo.getColor());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				devolver = true;
			} else {

				devolver = false;
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return devolver;

	}

	
	public boolean ExistCustomer(Vehicle vehiculo) {

		CustomerModel mc = new CustomerModel();
		boolean devolver = false;

		try {
			PreparedStatement pst = super.conexion.prepareStatement("select * from vehicles where customer=?");
			pst.setInt(1, vehiculo.getCustomer().getIdCustomer());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				devolver = true;
			} else {

				devolver = false;
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return devolver;

	}

	public boolean ExistVehicle(Vehicle vehiculo) {

		CustomerModel mc = new CustomerModel();
		boolean devolver = false;

		try {
			PreparedStatement pst = super.conexion.prepareStatement("select * from vehicles  where  plate=? and brand=? and model=? and color=? and customer=?");
	
			pst.setString(1, vehiculo.getPlate());
			pst.setString(2, vehiculo.getBrand());
			pst.setString(3, vehiculo.getModel());
			pst.setString(4, vehiculo.getColor());
			pst.setInt(5, vehiculo.getCustomer().getIdCustomer());
			
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				devolver = true;
			} else {

				devolver = false;
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return devolver;

	}

	
	
}
