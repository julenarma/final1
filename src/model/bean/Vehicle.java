package model.bean;

public class Vehicle{
	
	private int id;
	private String plate;
	private String brand;
	private String model;
	private String color;
	private Customer customer;
	
//---------------------------------------------------------------------------------------------

	public Vehicle() {
		super();
	}
	
//----------------------------------------------------------------------------------------------
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlate() {
		return plate;
	}
	public void setPlate(String plate) {
		this.plate = plate;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", plate=" + plate + ", brand=" + brand + ", model=" + model + ", color=" + color
				+ ", customer=" + customer + "]";
	}



}
