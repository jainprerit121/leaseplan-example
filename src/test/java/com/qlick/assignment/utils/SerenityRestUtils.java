package com.qlick.assignment.utils;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.apache.http.HttpStatus;

import java.util.Map;

public class SerenityRestUtils {

    static {
        RestAssured.baseURI = SerenityConfiguration.BASE_URL.value();
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    public Response getSuccess(String endPoint, String pathParamName, String pathParamValue){
        return SerenityRest.given()
                .pathParam(pathParamName, pathParamValue)
                .get(endPoint)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK).extract().response();
    }

    public Response get(String endPoint, String pathParamName, String pathParamValue, int statusCode){
        return SerenityRest.given()
                .pathParam(pathParamName, pathParamValue)
                .get(endPoint)
                .then()
                .assertThat()
                .statusCode(statusCode).extract().response();
    }

    public Response postSuccess(String endPoint, String body, Map<String, String> headers){
        return SerenityRest.given()
                .headers(headers)
                .body(body)
                .post(endPoint)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_CREATED).extract().response();
    }

    public Response postSuccess(String endPoint, String body, Map<String, String> headers, int statusCode){
        return SerenityRest.given()
                .headers(headers)
                .body(body)
                .post(endPoint)
                .then()
                .assertThat()
                .statusCode(statusCode).extract().response();
    }

    public Response lastResponse(){
        return SerenityRest.lastResponse();
    }
}
