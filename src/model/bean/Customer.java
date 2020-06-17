package model.bean;

import java.util.ArrayList;

public class Customer {

	
	private int idCustomer;
	private String name;
	private String surname;
	private String telephone;
	
	private ArrayList<Vehicle> vehicles;
	//--------------------------------------------------------------------------------

	public Customer() {
		super();
	}
	
	//--------------------------------------------------------------------------------
	
	public int getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public ArrayList<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(ArrayList<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	@Override
	public String toString() {
		return "Customer [idCustomer=" + idCustomer + ", name=" + name + ", surname=" + surname + ", telephone="
				+ telephone + ", vehicles=" + vehicles + "]";
	}
	
	
	
}
