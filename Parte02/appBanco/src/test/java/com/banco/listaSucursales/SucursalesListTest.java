package com.banco.listaSucursales;

import static io.restassured.RestAssured.get;
import org.junit.BeforeClass;
import org.junit.Test;
 
import io.restassured.RestAssured;
public class SucursalesListTest {
	
	@BeforeClass
	public static void init() {
	    RestAssured.baseURI = "http://localhost";
	    RestAssured.port = 8081;
	}
	
	@Test
	public void obtener()  {
		get("/appBanco/rest/sucursal/getListByIdBanco?idBanco=1")
	    .then()
	    .statusCode(200);
	}
	

}
