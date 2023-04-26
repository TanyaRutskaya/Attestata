//package helpers.user;
//
//import helpers.client.Client;
//import io.restassured.response.ValidatableResponse;
//
//import static io.restassured.RestAssured.given;
//
//public class UserClient extends Client{
//    private final String LOGIN = "/api/jwt/login";
//    private final String PROFILE = "/api/profile";
//
//    public ValidatableResponse loginUser(User user) {
//        return (ValidatableResponse) given()
//                .log().all()
//                .spec(getSpec())
//                .queryParam("username",user.getLogin())
//                .queryParam("password",user.getPassword())
//                .when()
//                .post(LOGIN)
//                .then().log().body();
//    }
//
//    public ValidatableResponse getUserProfile (String sessionToken) {
//        return (ValidatableResponse) given()
//                .log().all()
//                .header("Authorization", "Bearer " + sessionToken)
//                .spec(getSpec())
//                .when()
//                .get(PROFILE)
//                .then();
//    }
//}
