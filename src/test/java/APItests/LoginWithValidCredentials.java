package APItests;

import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.given;
public class LoginWithValidCredentials {

    public static String sessionToken = null;

    public static String DevUserAuthorizedToken() {
        UserManipulations userCreds = UserManipulations.devUserWithSubscrition();

        ResponseBody body = given().queryParam(EnvironmentPath.dev() + APIrequests.loginAPI())
                .queryParam("username", userCreds.name)
                .queryParam("password", userCreds.pass)
                .get(EnvironmentPath.dev() + APIrequests.loginAPI())
                .body();
        return sessionToken = body.jsonPath().get("accessToken");
    }

    public static String QaUserAuthorized() {
        UserManipulations userCreds = UserManipulations.qaUserWithSubscribtion();

        ResponseBody body = given().queryParam(EnvironmentPath.qa() + APIrequests.loginAPI())
                .queryParam("username", userCreds.name)
                .queryParam("password", userCreds.pass)
                .get(EnvironmentPath.qa() + APIrequests.loginAPI())
                .body();
        return sessionToken = body.jsonPath().get("accessToken");
    }
}
