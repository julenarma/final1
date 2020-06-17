package controller;

/*
 * 
 * 
 * this implemetation adds functionalities to CLookUp
 * 
 * -- update vehicle if exists and are differenced between the json vehicle and the vehicle in the database 
 * 
 * 
 */
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import model.bean.Vehicle;
import model.dao.CustomerModel;
import model.dao.VehiclesModel;

/**
 * Servlet implementation class CLoad
 */
@WebServlet("/CLookUp")
public class CLookUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CLookUp() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("index.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String jsonString = request.getParameter("pVehicles");
		JSONArray jsonArray = new JSONArray(jsonString);
		
		VehiclesModel vm= new VehiclesModel();
		  CustomerModel mc= new CustomerModel();
		
		
		
		int existingvehicles=0;
		int insertedvehicles=0;
		int updatedvehicles=0;
    	
		for (int i = 0; i < jsonArray.length(); i++) {
			
			JSONObject jsonObject= jsonArray.getJSONObject(i);
			
			Vehicle vehiculo= new Vehicle();
			
			vehiculo.setPlate(jsonObject.getString("plate"));
			vehiculo.setBrand(jsonObject.getString("brand"));
			vehiculo.setModel(jsonObject.getString("model"));
			vehiculo.setColor(jsonObject.getString("color"));
			vehiculo.setCustomer(mc.Select(jsonObject.getInt("customer")));
				
			// ez da existizen matrikula
			if (!vm.ExistPlate(vehiculo)) {
				
				vm.Insert(vehiculo);
				
				insertedvehicles++;
				try {
					vm.getConexion().close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			} 
			
			// existe registro entero
			
	         if (vm.ExistVehicle(vehiculo)) {
	        	 
	        	 
	        	 
				existingvehicles++;	
				
				
			} 
	         
	         
			//existe registro, con matricula y distintos campos
	         
			if (!vm.ExistVehicle(vehiculo)) {
	             vm.Update(vehiculo);
				 updatedvehicles++;
				try {
					vm.getConexion().close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}	   
			  			
			
			
		}
		
		JSONObject jsonObjectemaitza= new JSONObject();  
		jsonObjectemaitza.put("existingVehicles: ", existingvehicles);
			jsonObjectemaitza.put("insertedVehicles: ", insertedvehicles);
			jsonObjectemaitza.put("updatedVehicles: ", updatedvehicles);
			
			//response 
			
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			
			//print 
			
			PrintWriter out= new PrintWriter(new OutputStreamWriter(response.getOutputStream(),"UTF-8"),true);
			out.print(jsonObjectemaitza);
			jsonObjectemaitza.toString();
			out.flush();	
		
		

	   
			
	}

}