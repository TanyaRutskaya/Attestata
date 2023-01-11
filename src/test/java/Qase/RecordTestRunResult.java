package Qase;

import io.restassured.http.ContentType;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.given;

public class RecordTestRunResult {

public static final String FAILED = "failed";
public static final String PASSED = "passed";
public static final int testRun = 31;
    public static void failedTestRunRecord(String case_id){

        ResponseBody responseBody=
                given().baseUri(QaseAPIRequests.recordResult())
                        .accept(ContentType.JSON).
                        contentType(ContentType.JSON).
                        header("Token", "ba21bc5ee42c3d7fa07dc8b7f73d54769c79afd2").
                        body("{\"case_id\":"+ case_id +",\"status\":\"failed\"}").
                        when().
                        post().
                        thenReturn().body();

        System.out.println(responseBody.asPrettyString());
    }
    public static void passedTestRunRecord(String case_id){

        ResponseBody responseBody=
                given().baseUri(QaseAPIRequests.recordResult())
                        .accept(ContentType.JSON).
                        contentType(ContentType.JSON).
                        header("Token", "ba21bc5ee42c3d7fa07dc8b7f73d54769c79afd2").
                        body("{\"case_id\":" + case_id +",\"status\":\"passed\"}").
                        when().
                        post().
                        thenReturn().body();

        System.out.println(responseBody.asPrettyString());
    }
}
