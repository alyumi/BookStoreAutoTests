package api.Specs;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specifications {
    public static void InstallSpecifications(RequestSpecification request, ResponseSpecification response){
        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response;
    }

    public static void InstallSpecifications(ResponseSpecification response){
        RestAssured.responseSpecification = response;
    }

    public static RequestSpecification requestAccountSpec(){
        final String URL = "https://demoqa.com/Account/v1/";

        return new RequestSpecBuilder()
                .setBaseUri(URL)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static RequestSpecification requestBookstoreSpec(){
        final String URL = "https://demoqa.com/BookStore/v1/";

        return new RequestSpecBuilder()
                .setBaseUri(URL)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static ResponseSpecification responseSpecStatus(Integer code){
        return new ResponseSpecBuilder()
                .expectStatusCode(code)
                .build();
    }


}
