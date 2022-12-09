package Qase;

import APItests.APIrequests;
import APItests.EnvironmentPath;
import com.google.gson.JsonObject;
import io.restassured.http.ContentType;
import io.restassured.response.ResponseBody;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class GetCaseTest {
    private HashMap result= null;
    @BeforeTest
    public void setupTest() {
        ResponseBody body = given().queryParam(QaseAPIRequests.getAllCases())
                .header("Token", "85e3e83e9a36a8a3e09904a7b5adf5b9249fa107")
                .get(QaseAPIRequests.getAllCases())
                .body();

        result = body.jsonPath().get("result");
    }
    @Test
    public void checkLicenceKeyPresence() {
        System.out.println(result);
    }
}
