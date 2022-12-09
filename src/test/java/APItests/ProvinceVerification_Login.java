package APItests;

import com.google.gson.JsonObject;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class ProvinceVerification_Login {
    private String sessionToken = null;

    @BeforeTest
    public void setupTest() {
        ResponseBody body = given().queryParam(EnvironmentPath.qa() + APIrequests.loginAPI())
                .queryParam("username", "mariaberardinelli@hotmail.com")
                .queryParam("password", "Password123")
                .get(EnvironmentPath.qa() + APIrequests.loginAPI())
                .body();

        sessionToken = body.jsonPath().get("accessToken");
    }
    @Test(suiteName = "PROVINCE is present at billingAddress")
    public void checkProvincePresenceWhileLogin() {
        ResponseBody profileBodyResp = UserProfile.profile(sessionToken);
        System.out.println(profileBodyResp);
        Assert.assertTrue(profileBodyResp.jsonPath().<Map<String, JsonObject>>getJsonObject("billingAddress").containsKey("province"),
                "The province is absent at billing address");
    }
        @Test(suiteName = "billingAddress: 'province' is not null ")
        public void checkProvincevalueAtBilllingAddress(){
            ResponseBody profileBodyResp = UserProfile.profile(sessionToken);
            System.out.println(profileBodyResp);
        Assert.assertNotNull(profileBodyResp.jsonPath().<Map<String, JsonObject>>getJsonObject("billingAddress").get("province"),
                "The province value is null at billing address");
    }
    @Test(suiteName = "userAddress has a province")
    public void checkProvincePresenceAtUserAddress (){
        ResponseBody profileBodyResp = UserProfile.profile(sessionToken);
        System.out.println(profileBodyResp);
        Assert.assertNotNull(profileBodyResp.jsonPath().<Map<String, JsonObject>>getJsonObject("userAddress").get("province"),
                "The province is absent at userAddress");
    }
    @Test(suiteName = "userAddress: 'province' is not null")
    public void checkProvinceValueAtUserAddress (){
        ResponseBody profileBodyResp = UserProfile.profile(sessionToken);
        System.out.println(profileBodyResp);
        Assert.assertNotNull(profileBodyResp.jsonPath().<Map<String, JsonObject>>getJsonObject("userAddress").containsKey("province"),
                "The province value is null at user address");
    }
    @Test(suiteName = "licence has a province")
    public void check (){
        ResponseBody profileBodyResp = UserProfile.profile(sessionToken);
        System.out.println(profileBodyResp);
        Assert.assertNotNull(profileBodyResp.jsonPath().<Map<String, JsonObject>>getJsonObject("licence").get("province"),
                "The province parameter is null at licence");
    }
    @Test(suiteName = "licence: 'province' is not null")
    public void checkProvinceValueAtLicence (){
        ResponseBody profileBodyResp = UserProfile.profile(sessionToken);
        System.out.println(profileBodyResp);
        Assert.assertNotNull(profileBodyResp.jsonPath().<Map<String, JsonObject>>getJsonObject("licence").containsKey("province"),
                "The province value is null at licence");
    }
}
