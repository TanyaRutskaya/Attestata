package APItests;

import com.google.gson.JsonObject;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class LicenceVerification_Login {
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

    @Test(suiteName = "Licence key is present at login API response TC_ATST-80_step1")
    public void checkLicenceKeyPresence() {
        ResponseBody profileBodyResp = UserProfile.profile(sessionToken);
        System.out.println(profileBodyResp);
        Assert.assertTrue(profileBodyResp.jsonPath().<Map<String, JsonObject>>getJsonObject("licence") != null,
                "The licence key is absent");
    }

    @Test(suiteName = "Licence Key has LicenceNumber value TC_ATST-80_step2")
    public void checkLicenceNumberKeyIsPresent() {
        ResponseBody profileBodyResp = UserProfile.profile(sessionToken);
        System.out.println(profileBodyResp);
        Assert.assertNotNull(profileBodyResp.jsonPath().<Map<String, JsonObject>>getJsonObject("licence").get("licenceNumber"),
                "The 'licenceNumber' value is absent at licence key");
    }

    @Test(suiteName = "LicenceNumber value is present TC_ATST-80_step3")
    public void checkLicenceNumberValueIsPresent() {
        ResponseBody profileBodyResp = UserProfile.profile(sessionToken);
        System.out.println(profileBodyResp);
        Assert.assertTrue(profileBodyResp.jsonPath().<Map<String, JsonObject>>getJsonObject("licence").containsKey("licenceNumber"),
                "The LicenceNumber value is absent");
    }

    @Test(suiteName = "Licence expiryDate Key presence verification TC_ATST-80_step4")
    public void checkExpiryDateKeyIsPresent() {
        ResponseBody profileBodyResp = UserProfile.profile(sessionToken);
        System.out.println(profileBodyResp);
        Assert.assertNotNull(profileBodyResp.jsonPath().<Map<String, JsonObject>>getJsonObject("licence").containsKey("expiryDate"),
                "The 'expiryDate' is absent at licence key");
    }

    @Test(suiteName = "Licence expiryDate value is not null verification on user's login TC_ATST-80_step5")
    public void checkExpiryDateValueIsPresent() {
        ResponseBody profileBodyResp = UserProfile.profile(sessionToken);
        System.out.println(profileBodyResp);
        Assert.assertNotNull(profileBodyResp.jsonPath().<Map<String, JsonObject>>getJsonObject("licence").get("expiryDate"),
                "The expiryDate is null");
    }

    @Test(suiteName = "Licence is not expired TC_ATST-80_step6")
    public void checkLicenceIsNotExpired() {
        ResponseBody profileBodyResp = UserProfile.profile(sessionToken);
        System.out.println(profileBodyResp);
        String dateString = profileBodyResp.jsonPath().<Map<String, String>>getJsonObject("licence").get("expiryDate");
        Date expiration = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss");
        try {
            expiration = format.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(expiration!= null && expiration.after(new Date()),
        "The expiryDate has expired");
    }
}
