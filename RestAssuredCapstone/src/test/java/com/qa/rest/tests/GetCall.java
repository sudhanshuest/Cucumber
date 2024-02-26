package com.qa.rest.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ExcelUtils;

public class GetCall {

    String excelPath = "C:/Excel Files/TestData.xlsx";
    String sheet = "Sheet1";
    ExcelUtils excel = new ExcelUtils(excelPath, sheet);

    @Test(groups = {"group1"})

    public void test1(){

        RestAssured.baseURI = "https://restcountries.com/v3.1/translation/";

        Response response = null;

        response =  RestAssured.given()
                .when()
                .get("germany");
//                .then()
//                .statusCode(200);
        System.out.println(response.getBody().asString());
        int  statusCode=response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test(groups = {"group1"})

    public void test2(){

        RestAssured.baseURI = "https://restcountries.com/v3.1/translation/";
        Response response = null;
        response = RestAssured.given()
                .when()
                .get("alemania");
//                .then()
//                .statusCode(200);
        System.out.println(response.getBody().asString());
        int  statusCode=response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test(groups = {"group2"})

    public void test3(){

        RestAssured.baseURI = "https://restcountries.com/v3.1/translation/";

        RestAssured.given()
                .when()
                .get("Saksamaa")
                .then()
                .statusCode(200);
    }

}
