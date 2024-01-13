package RestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.given;

public class RestAssuredGetMethod {
	


	

	    @BeforeClass
	    public static void setup() {
	        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
	    }

	    @org.testng.annotations.Test
	    public void getRequestGermany() {
	        Response response = given()
	                .contentType(ContentType.JSON)
	                .when()
	                .get("/germany")
	                .then()
	                .extract().response();

	        Assert.assertEquals(200, response.statusCode());
	        Assert.assertEquals("qui est esse", response.jsonPath().getString("title[1]"));
	    }
	    
	    @org.testng.annotations.Test
	    public void getRequestalemania() {
	        Response response = given()
	                .contentType(ContentType.JSON)
	                .when()
	                .get("/alemania")
	                .then()
	                .extract().response();

	        Assert.assertEquals(200, response.statusCode());
	}
	   
	    
	    
	    @org.testng.annotations.Test
	    public void getRequestSaksamaa() {
	        Response response = given()
	                .contentType(ContentType.JSON)
	                .when()
	                .get("/Saksamaa")
	                .then()
	                .extract().response();

	        Assert.assertEquals(200, response.statusCode());
	}
}


