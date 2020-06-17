package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Conector;
import model.bean.Customer;

public class CustomerModel extends Conector {

	
	public Customer Select(int id) {

		Customer customer= new Customer();
		
		
		try {
			
			
			
			PreparedStatement pst= super.conexion.prepareStatement("select * from customers where idCustomer=?");
			pst.setInt(1, id);
			ResultSet rs= pst.executeQuery();
			
			
			while (rs.next()) {
			
				customer.setIdCustomer(rs.getInt("idCustomer"));
				customer.setName(rs.getString("name"));
				customer.setSurname(rs.getString("surname"));
				customer.setTelephone(rs.getString("telephone"));
				
				
				return customer;
				
			}
			
			
		} catch (SQLException e) {

             e.printStackTrace();
			
			
		}
		
		
		
		return customer;

	}
	
	
}
