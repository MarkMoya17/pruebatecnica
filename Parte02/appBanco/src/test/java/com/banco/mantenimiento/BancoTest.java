package com.banco.mantenimiento;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import org.json.simple.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;
 
import io.restassured.RestAssured;
public class BancoTest {
	
 	@BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8081;
    }
 	 
    @SuppressWarnings("unchecked")
	@Test
    public void registrar()  {
    	JSONObject banco = new JSONObject();
    	banco.put("nombre", "BBVA");
    	banco.put("direccion", "Benavides");
    	banco.put("fechaRegistro", "01/01/2000");
		JSONObject request = new JSONObject();
		request.put("Banco", banco);
		given().
		header("Content-type", "application/json").
		body(request.toJSONString()).
		when().
		post("/appBanco/rest/banco/registrar").
		then().statusCode(200);
    }
    
    @SuppressWarnings("unchecked")
	@Test
    public void modificar()  {
    	JSONObject banco = new JSONObject();
    	banco.put("idBanco", "1");
	 	banco.put("nombre", "BCP");
	 	banco.put("direccion", "Larco");
	 	banco.put("fechaRegistro", "01/01/2010");
		JSONObject request = new JSONObject();
		request.put("Banco", banco);
		given().
		header("Content-type", "application/json").
		body(request.toJSONString()).
		when().
		put("/appBanco/rest/banco/actualizar").
		then().statusCode(200);
    }
    
	@Test
    public void obtener()  {			
    	get("/appBanco/rest/banco/getById?id=5")
        .then()
        .statusCode(200);
    }
	
    @Test
    public void listar() {
        get("/appBanco/rest/banco/listar")
        .then()
        .statusCode(200);
    }
	
	@Test
    public void eliminar()  {			
		given().
		header("Content-type", "application/json").
    	delete("/appBanco/rest/banco/eliminar?id=5")
        .then()
        .statusCode(204);
    }

}
