package Projects;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import io.restassured.specification.ResponseSpecification;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.lessThan;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class RESTAssured_GitHub_Project {
    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;
    String ssh_key = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIA/5fFq2wuwG9CNpJIgSL9XImyz4UUNz0jwcF2WHSSAZ";
    int ssh_id;
    @BeforeClass
    public void setUp(){
        String Token = "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";
        requestSpec = new RequestSpecBuilder()
                .addHeader("Authorization","token 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")
                .addHeader("Content--Type","application/json")
                .setBaseUri("https://api.github.com/user/keys").build();

        responseSpec = new ResponseSpecBuilder().expectResponseTime(lessThan(5000L))
                .expectBody("key",equalTo(ssh_key))
                .expectBody("title",equalTo("TestAPIKey")).build();

    }
    @Test(priority = 1)
    public void Post_method(){
        Map<String, Object> Request_Body = new HashMap<>();
        Request_Body.put("title","TestAPIKey");
        Request_Body.put("key",ssh_key);

        Response response = given().spec(requestSpec).body(Request_Body).when()
                .post();
        String Result =response.getBody().asPrettyString();
        System.out.println(Result);
        ssh_id = response.then().extract().path("id");
        response.then().spec(responseSpec);
    }

    @Test(priority = 2)
    public void Get_method(){
        Response response = given().spec(requestSpec).when()
                .pathParam("keyId",ssh_id).get("/{keyId}");
        Reporter.log(String.valueOf(response));
        System.out.println(response.getBody().asPrettyString());
        response.then().statusCode(200);
        response.then().spec(responseSpec);

    }

    @Test(priority = 3)
    public void Delete_method(){
        Response response = given().spec(requestSpec).when()
                .pathParam("keyId",ssh_id).delete("/{keyId}");
        Reporter.log(String.valueOf(response));
        System.out.println(response.getBody().asPrettyString());
        response.then().statusCode(204);
        response.then().time(lessThan(3000L));

    }
}
