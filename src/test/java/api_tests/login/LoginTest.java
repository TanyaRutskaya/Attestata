//package api_tests.login;
//
//import helpers.user.CreateUsersCreds;
//import helpers.user.User;
//import helpers.user.UserClient;
//import io.qameta.allure.junit4.DisplayName;
//import io.restassured.response.ValidatableResponse;
//import org.junit.Assert;
//import org.junit.Test;
//
//import static org.apache.http.HttpStatus.SC_OK;
//import static org.apache.http.HttpStatus.SC_UNAUTHORIZED;
//import static org.hamcrest.CoreMatchers.equalTo;
//
//public class LoginTest {
//
//    private UserClient userClient = new UserClient();
//    private User user;
//    private CreateUsersCreds createUsersCred = new CreateUsersCreds();
//
//    @Test
//    @DisplayName("Check a user can login. Successful login returns status 201 OK and body with accessToken and refreshToken")
//    public void checkUserCanLogin() {
//        user = createUsersCred.getValidUser();
//
//        ValidatableResponse response = userClient.loginUser(user);
//        int actualStatusCode = response.extract().statusCode();
//
//        String actualAccessToken = response.extract().path("accessToken");
//        String actualRefreshToken = response.extract().path("refreshToken");
//
//        Assert.assertEquals(SC_OK, actualStatusCode);
//        String responseBody = String.valueOf(response.assertThat().body("accessToken", equalTo(actualAccessToken)).and().body("refreshToken", equalTo(actualRefreshToken)));
//    }
//
//    @Test
//    @DisplayName("Check a user with wrong password cannot login. The response has status 401 and with error: Unauthorized")
//    public void checkLoginWithWrongPasswordReturns401Error() {
//        user = createUsersCred.getUserWithNotValidPassword();
//
//        ValidatableResponse response = userClient.loginUser(user);
//        String actualBodyError = response.extract().path("error");
//        int actualStatusCode = response.extract().statusCode();
//
//        Assert.assertEquals(SC_UNAUTHORIZED, actualStatusCode);
//        Assert.assertEquals("Unauthorized", actualBodyError);
//
//    }
//
//    @Test
//    @DisplayName("Check a user with wrong login cannot login. The response has status 401 and with error: Unauthorized")
//    public void checkLoginWithWrongLoginReturns401Error() {
//        user = createUsersCred.getUserWithNotValidLogin();
//
//        ValidatableResponse response = userClient.loginUser(user);
//        String actualBodyError = response.extract().path("error");
//        int actualStatusCode = response.extract().statusCode();
//
//        Assert.assertEquals(SC_UNAUTHORIZED, actualStatusCode);
//        Assert.assertEquals("Unauthorized", actualBodyError);
//
//    }
//
//    @Test
//    @DisplayName("Check a user with wrong login and password cannot login. The response has status 401 and with error: Unauthorized")
//    public void checkLoginWithWrongLoginAndPasswordReturns401Error() {
//        user = createUsersCred.getUserWithNotValidLoginAndPassword();
//
//        ValidatableResponse response = userClient.loginUser(user);
//        String actualBodyError = response.extract().path("error");
//        int actualStatusCode = response.extract().statusCode();
//
//        Assert.assertEquals(SC_UNAUTHORIZED, actualStatusCode);
//        Assert.assertEquals("Unauthorized", actualBodyError);
//
//    }
//
//    @Test
//    @DisplayName("Check a user with empty login cannot login. The response has status 401 and with error: Unauthorized")
//    public void checkLoginWithEmptyLoginReturns401Error() {
//        user = createUsersCred.getUserWithEmptyLogin();
//
//        ValidatableResponse response = userClient.loginUser(user);
//        String actualBodyError = response.extract().path("error");
//        int actualStatusCode = response.extract().statusCode();
//
//        Assert.assertEquals(SC_UNAUTHORIZED, actualStatusCode);
//        Assert.assertEquals("Unauthorized", actualBodyError);
//
//    }
//
//
//
//    @Test
//    @DisplayName("Check a user with empty password cannot login. The response has status 401 and with error: Unauthorized")
//    public void checkLoginWithEmptyPasswordReturns401Error() {
//        user = createUsersCred.getUserWithEmptyPassword();
//
//        ValidatableResponse response = userClient.loginUser(user);
//        String actualBodyError = response.extract().path("error");
//        int actualStatusCode = response.extract().statusCode();
//
//        Assert.assertEquals(SC_UNAUTHORIZED, actualStatusCode);
//        Assert.assertEquals("Unauthorized", actualBodyError);
//
//    }
//
//    @Test
//    @DisplayName("Check a user with empty login and password cannot login. The response has status 401 and with error: Unauthorized")
//    public void checkLoginWithEmptyLoginAndPasswordReturns401Error() {
//        user = createUsersCred.getUserWithEmptyLoginAndPassword();
//
//        ValidatableResponse response = userClient.loginUser(user);
//        String actualBodyError = response.extract().path("error");
//        int actualStatusCode = response.extract().statusCode();
//
//        Assert.assertEquals(SC_UNAUTHORIZED, actualStatusCode);
//        Assert.assertEquals("Unauthorized", actualBodyError);
//
//    }
//
//    @Test
//    @DisplayName("Check a user that is not in DB cannot login. The response has status 401 and with error: Unauthorized")
//    public void checkLoginWithRandomUserReturns401Error() {
//        user = createUsersCred.getRandomUser();
//
//        ValidatableResponse response = userClient.loginUser(user);
//        String actualBodyError = response.extract().path("error");
//        int actualStatusCode = response.extract().statusCode();
//
//        Assert.assertEquals(SC_UNAUTHORIZED, actualStatusCode);
//        Assert.assertEquals("Unauthorized", actualBodyError);
//
//    }
//
//
//}
