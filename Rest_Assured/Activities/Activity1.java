package Activities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Activity1 {

    @Test(priority = 0)
    public void post_method(){
        String Root_Url = "https://petstore.swagger.io/v2/pet";
        String input = "{\"id\":200045,\"name\":\"Ganesh_Shiva_Nandhi\",\"status\":\"Available\"}";

        Response response = given().contentType(ContentType.JSON)
                .body(input).when().post(Root_Url);
        System.out.println(response.getBody().asPrettyString());
        response.then().body("id",equalTo(200045));
        response.then().body("name",equalTo("Ganesh_Shiva_Nandhi"));
        response.then().body("status",equalTo("Available"));
    }

    @Test(priority = 1)
    public void get_method(){
        String Root_Url = "https://petstore.swagger.io/v2/pet/{petId}";
        Response response = given().contentType(ContentType.JSON).when().pathParam("petId",200045).get(Root_Url);
        System.out.println(response.getBody().asPrettyString());
        response.then().body("id",equalTo(200045));
        response.then().body("name",equalTo("Ganesh_Shiva_Nandhi"));
        response.then().body("status",equalTo("Available"));
    }

    @Test(priority = 2)
    public void delete_method(){
        String Root_Url = "https://petstore.swagger.io/v2/pet/{petId}";
        Response response = given().contentType(ContentType.JSON).when().pathParam("petId",200045).delete(Root_Url);
        System.out.println(response.getBody().asPrettyString());
        response.then().body("code",equalTo(200));
        response.then().body("message",equalTo("200045"));
    }
}
