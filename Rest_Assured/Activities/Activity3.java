package Activities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity3 {
    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;
    @BeforeClass
    public void setUp(){
        requestSpec = new RequestSpecBuilder().setContentType(ContentType.JSON)
                .setBaseUri("https://petstore.swagger.io/v2/pet").build();

        responseSpec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType("application/json")
                .expectBody("status",equalTo("alive")).build();

    }
    @DataProvider(name  = "PetInformation")
    public Object[][] petInfoProvider(){
      Object[][] data = new Object[][]{
              {772320,"Riley","alive"},
              {772330,"Hansel","alive"}
      }  ;
      return data;
    }

    @Test(priority = 1)
    public void Post_method(){
        String request = "{\"id\":772320,\"name\":\"Riley\",\"status\":\"alive\"}";
        Response response1 =given().spec(requestSpec).body(request).when().post();
        response1.then().spec(responseSpec);
        request = "{\"id\":772330,\"name\":\"Hansel\",\"status\":\"alive\"}";
        Response response2 =given().spec(requestSpec).body(request).when().post();
        response2.then().spec(responseSpec);
    }

    @Test(priority = 2,dataProvider = "PetInformation")
    public  void Get_method(int id,String name,String status){
      Response response =given().spec(requestSpec).when().pathParam("petid",id)
              .when().get("/{petid}");
      System.out.println(response.getBody().asPrettyString());
      response.then().spec(responseSpec).body("name",equalTo(name))
              .body("status",equalTo(status));
    }

    @Test(priority = 3,dataProvider = "PetInformation")
    public void Delete_method(int id,String name, String status){
        Response response =given().spec(requestSpec).when().pathParam("petid",id)
                .delete("/{petid}");
        System.out.println(response.getBody().asPrettyString());
        response.then().body("code",equalTo(200));

    }
}
