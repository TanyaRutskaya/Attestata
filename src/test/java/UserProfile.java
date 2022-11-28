import io.restassured.http.ContentType;
import io.restassured.response.ResponseBody;
import org.skyscreamer.jsonassert.JSONParser;

import static io.restassured.RestAssured.given;

public class UserProfile {
    static public ResponseBody profile(String sessionToken) {
        ResponseBody respBody = given()
                .headers(
                        "Authorization",
                        "Bearer " + sessionToken,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .when()
                .queryParam(EnvironmentPath.qa() + APIrequests.userProfile())
                .get(EnvironmentPath.qa() + APIrequests.userProfile())
                .body();
        return respBody;

    }
}