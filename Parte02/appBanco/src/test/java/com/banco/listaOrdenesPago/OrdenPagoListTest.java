package com.banco.listaOrdenesPago;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import org.json.simple.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;
 
import io.restassured.RestAssured;
public class OrdenPagoListTest {
	
	@BeforeClass
	public static void init() {
	    RestAssured.baseURI = "http://localhost";
	    RestAssured.port = 8081;
	}
	
	@Test
	public void obtener()  {			
		get("/appBanco/rest/ordenpago/getListByIdSucursal?idSucursal=1&moneda='Soles'")
	    .then()
	    .statusCode(200);
	}
	

}
