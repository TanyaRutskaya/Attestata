//package api_tests.profile;
//
//import helpers.user.CreateUsersCreds;
//import helpers.user.User;
//import helpers.user.UserClient;
//import io.restassured.response.ValidatableResponse;
//import org.junit.Assert;
//import org.junit.Test;
//
//import static org.apache.http.HttpStatus.SC_OK;
//import static org.hamcrest.CoreMatchers.equalTo;
//
//public class ProfileTest {
//    private User user;
//    private String sessionToken;
//    private UserClient userClient = new UserClient();
//    private CreateUsersCreds createUsersCred = new CreateUsersCreds();
//
//
//    @Test
//    public void checkUserProfileWithSessionToken() {
//        user = createUsersCred.getValidUser();
//
//        ValidatableResponse responseLogin = userClient.loginUser(user);
//        sessionToken = responseLogin.extract().jsonPath().get("accessToken");
//
//        ValidatableResponse responseProfile = userClient.getUserProfile(sessionToken);
//        int actualResponse = responseProfile.extract().statusCode();
//
//        String actualEmailInBody = responseProfile.extract().path("email");
//
//        Assert.assertEquals(SC_OK, actualResponse);
//
//        String responseBody = String.valueOf(responseProfile.assertThat().body("email", equalTo(actualEmailInBody)));
//    }
//
//}
