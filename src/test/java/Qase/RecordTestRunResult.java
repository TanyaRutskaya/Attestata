package Qase;

import io.restassured.http.ContentType;
import io.restassured.response.ResponseBody;
import static io.restassured.RestAssured.given;

public class RecordTestRunResult {

    public static void failedTestRunRecord(String case_id){

        ResponseBody responseBody=
                given().baseUri(QaseAPIRequests.recordResult())
                        .accept(ContentType.JSON).
                        contentType(ContentType.JSON).
                        header("Token", "498fb3fd1772c5aa4d580efd256c02abf89bf9c9b3d10546bcbb0b5b29a3b197").
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
