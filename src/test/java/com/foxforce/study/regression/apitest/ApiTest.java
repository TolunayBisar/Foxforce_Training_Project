package com.foxforce.study.regression.apitest;

import com.foxforce.study.basefunctions.FunctionLibrary;
import com.foxforce.study.petstore_api.Payloads;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author : tolunaybisar
 * @created : 8.02.2024,19:53
 * @Email :tolunay.bisar@gmail.com
 **/
public class ApiTest {
    FunctionLibrary functionLibrary;



    @BeforeClass
    public void setUp() {
        functionLibrary = new FunctionLibrary();
        String cfFile = "config.properties";
        RestAssured.baseURI = functionLibrary.readFromConfig(cfFile, "api_host");


        //RestAssured.port = Integer.parseInt(functionLibrary..readFromConfig(cfFile, "api_port"));
       // RestAssured.authentication = RestAssured.basic(functionLibrary.readFromConfig
               // (cfFile, "api_username"), functionLibrary.readFromConfig(cfFile, "api_password"));


    }

    @Test(description = "as a Admin user should be able to get category  By ID ", priority = 1)
    public void getPetByStatus() {

        Response response = RestAssured.given().when().get("pet/findByStatus?status=available&status=pending&status=sold");
        response.getBody().prettyPrint();
        assert response.getStatusCode() == 200 : "Expected status code 200,but got :" + response.getStatusCode();
        String name = response.jsonPath().getString("name");
        System.out.println(name); // why it is null?

    }





    @Test(description = "as a Admin user should be able to add product ", priority = 4)
    public void postSomeProductTest() {

        Response response = RestAssured.given().header("Content-Type", "application/json").and().
                body(Payloads.payload()).
                when().post("/pet").then().extract().response();
        response.getBody().prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200);


    }
}
