package com.Student;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

import io.restassured.http.ContentType;

@SuppressWarnings("unused")
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentJwtApplicationTests {
	    
    @Test
    @Order(1)
    public void testLogin() {
        String jsonbody= "{\"student_email\" : \"pavan@gmail.com\",\"student_password\" : \"Pavan\"}";
        String token=given()
                .header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(jsonbody)
                .when()
                .post("http://localhost:8084/api/authenticate")
                .then()
                .assertThat().statusCode(200)
                .extract().response().asString();
    }
}
