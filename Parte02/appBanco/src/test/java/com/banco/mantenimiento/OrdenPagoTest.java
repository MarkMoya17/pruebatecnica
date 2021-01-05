package com.banco.mantenimiento;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import org.json.simple.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;
 
import io.restassured.RestAssured;
public class OrdenPagoTest {
	
	@BeforeClass
	public static void init() {
	    RestAssured.baseURI = "http://localhost";
	    RestAssured.port = 8081;
	}
	 
	@SuppressWarnings("unchecked")
	@Test
	public void registrar()  {
		JSONObject ordenPago = new JSONObject();
		ordenPago.put("monto", "200");
		ordenPago.put("moneda", "Soles");
		ordenPago.put("estado", "Activo");
		ordenPago.put("fechaPago", "21/12/2020");
		ordenPago.put("idSucursal", "1");
		JSONObject request = new JSONObject();
		request.put("OrdenPago", ordenPago);
		given().
		header("Content-type", "application/json").
		body(request.toJSONString()).
		when().
		post("/appBanco/rest/ordenpago/registrar").
		then().statusCode(200);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void modificar()  {
		JSONObject ordenPago = new JSONObject();
		ordenPago.put("idOrdenPago", "1");
		ordenPago.put("monto", "200");
		ordenPago.put("moneda", "Soles");
		ordenPago.put("estado", "Activo");
		ordenPago.put("fechaPago", "21/12/2020");
		ordenPago.put("idSucursal", "1");
		JSONObject request = new JSONObject();
		request.put("OrdenPago", ordenPago);
		given().
		header("Content-type", "application/json").
		body(request.toJSONString()).
		when().
		put("/appBanco/rest/ordenpago/actualizar").
		then().statusCode(200);
	}
	
	@Test
	public void obtener()  {			
		get("/appBanco/rest/ordenpago/getById?id=1")
	    .then()
	    .statusCode(200);
	}
	
	@Test
	public void listar() {
	    get("/appBanco/rest/ordenpago/listar")
	    .then()
	    .statusCode(200);
	}
	
	@Test
	public void eliminar()  {			
		given().
		header("Content-type", "application/json").
		delete("/appBanco/rest/ordenpago/eliminar?id=1")
	    .then()
	    .statusCode(204);
	}

}
