package Activities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import static org.hamcrest.CoreMatchers.equalTo;

import java.io.FileWriter;
import java.io.IOException;


import static io.restassured.RestAssured.given;

public class Activity2 {
    String Root_URI = "https://petstore.swagger.io/v2/user";
    @Test(priority = 0)
    public void post_method() throws IOException {
        File input_file = new File("src/test/resources/activity2In.json");
        FileInputStream input_stream = new FileInputStream(input_file);
        /*byte[] read_bytes = new byte[(int)input_file.length()];
        input_stream.read(read_bytes);*/
        String req_body = new String(input_stream.readAllBytes());
        Response response = given().contentType(ContentType.JSON)
                .body(req_body).when().post(Root_URI);
        System.out.println(response.getBody().asPrettyString());
        response.then().body("code",equalTo(200));
        response.then().body("message",equalTo("200046"));

    }

    @Test(priority = 1)
    public void get_method() throws IOException {
        Response response = given().contentType(ContentType.JSON).
                when().pathParam("username","IBM").get(Root_URI+"/{username}");
        String res_body =response.getBody().asPrettyString();
        System.out.println(res_body);
        response.then().body("id",equalTo(200046));
        response.then().body("username",equalTo("IBM"));
        response.then().body("firstName",equalTo("Venkat"));
        response.then().body("lastName",equalTo("L"));
        response.then().body("email",equalTo("venkat@ibm.com"));
        response.then().body("password",equalTo("password123"));
        response.then().body("phone",equalTo("9812763450"));
        File output_file = new File("src/test/resources/activity2Out.json");
        output_file.createNewFile();
        FileWriter writer = new FileWriter(output_file.getPath());
        writer.write(res_body);
        writer.close();
    }

    @Test(priority = 2)
    public void delete_method(){
        Response response = given().contentType(ContentType.JSON).
                when().pathParam("username","IBM").delete(Root_URI+"/{username}");
        System.out.println(response.getBody().asPrettyString());
        response.then().body("code",equalTo(200));
        response.then().body("message",equalTo("IBM"));
    }
}
