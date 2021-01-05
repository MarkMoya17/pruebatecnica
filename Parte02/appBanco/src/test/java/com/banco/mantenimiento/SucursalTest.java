package com.banco.mantenimiento;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import org.json.simple.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;
 
import io.restassured.RestAssured;
public class SucursalTest {
	
	@BeforeClass
	public static void init() {
	    RestAssured.baseURI = "http://localhost";
	    RestAssured.port = 8081;
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void registrar()  {
		JSONObject sucursal = new JSONObject();
		sucursal.put("nombre", "BBVA Proceres");
		sucursal.put("direccion", "Proceres");
		sucursal.put("fechaRegistro", "01/01/2001");
		sucursal.put("idBanco", "1");
		JSONObject request = new JSONObject();
		request.put("Sucursal", sucursal);
		given().
		header("Content-type", "application/json").
		body(request.toJSONString()).
		when().
		post("/appBanco/rest/sucursal/registrar").
		then().statusCode(200);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void modificar()  {
		JSONObject sucursal = new JSONObject();
		sucursal.put("idSucursal", "1");
		sucursal.put("nombre", "BBVA Proceres Alto");
		sucursal.put("direccion", "Proceres Alto");
		sucursal.put("fechaRegistro", "15/01/2001");
		sucursal.put("idBanco", "1");
		JSONObject request = new JSONObject();
		request.put("Sucursal", sucursal);
		given().
		header("Content-type", "application/json").
		body(request.toJSONString()).
		when().
		put("/appBanco/rest/sucursal/actualizar").
		then().statusCode(200);
	}
	
	@Test
	public void obtener()  {			
		get("/appBanco/rest/sucursal/getById?id=1")
	    .then()
	    .statusCode(200);
	}
	
	@Test
	public void listar() {
	    get("/appBanco/rest/sucursal/listar")
	    .then()
	    .statusCode(200);
	}
	
	@Test
	public void eliminar()  {			
		given().
		header("Content-type", "application/json").
		delete("/appBanco/rest/sucursal/eliminar?id=1")
	    .then()
	    .statusCode(204);
	}

}
