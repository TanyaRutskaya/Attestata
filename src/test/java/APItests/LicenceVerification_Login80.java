package APItests;

import Qase.RecordTestRunResult;
import com.google.gson.JsonObject;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class LicenceVerification_Login80 {
    private String sessionToken = null;
    private Map<String, Boolean> resultMap = new HashMap<String, Boolean>();


    @BeforeTest
    public void setupTest() {

        UserManipulations userCreds = UserManipulations.devUserWithoutSubscription();

        ResponseBody body = given().queryParam(EnvironmentPath.dev() + APIrequests.loginAPI())
                .queryParam("username", userCreds.name)
                .queryParam("password", userCreds.pass)
                .get(EnvironmentPath.dev() + APIrequests.loginAPI())
                .body();
        sessionToken = body.jsonPath().get("accessToken");
    }

    @Test(suiteName = "Licence key is present at profile API response TC_ATST-80_step1")
    public void checkLicenceKeyPresence(){
        ResponseBody profileBodyResp = UserProfile.profile(sessionToken);
        System.out.println(profileBodyResp);
        Boolean assertResult =(profileBodyResp.jsonPath().<Map<String, JsonObject>>getJsonObject("licence") != null);
        resultMap.put("checkLicenceKeyPresence",assertResult);
        Assert.assertTrue(assertResult, "The licence key is absent");

        }

    @Test(suiteName = "Licence Key has LicenceNumber value TC_ATST-80_step2")
   public void checkLicenceNumberKeyIsPresent() {
        ResponseBody profileBodyResp = UserProfile.profile(sessionToken);
        System.out.println(profileBodyResp);
        Boolean assertResult = (profileBodyResp.jsonPath().<Map<String, JsonObject>>getJsonObject("licence").get("licenceNumber")!=null);
        resultMap.put("checkLicenceNumberKeyIsPresent",assertResult);
        Assert.assertTrue(assertResult, "The 'licenceNumber' value is absent at licence key");

   }

    @Test(suiteName = "LicenceNumber value is present TC_ATST-80_step3")
    public void checkLicenceNumberValueIsPresent() {
        ResponseBody profileBodyResp = UserProfile.profile(sessionToken);
        System.out.println(profileBodyResp);
    Boolean assertResult = (profileBodyResp.jsonPath().<Map<String, JsonObject>>getJsonObject("licence").containsKey("licenceNumber"));
        resultMap.put("checkLicenceNumberValueIsPresent",assertResult);
        Assert.assertTrue(assertResult, "The LicenceNumber value is absent");


    }

    @Test(suiteName = "Licence expiryDate Key presence verification TC_ATST-80_step4")
   public void checkExpiryDateKeyIsPresent() {
        ResponseBody profileBodyResp = UserProfile.profile(sessionToken);
        System.out.println(profileBodyResp);
        Boolean  assertResult = (profileBodyResp.jsonPath().<Map<String, JsonObject>>getJsonObject("licence").containsKey("expiryDate"));
        resultMap.put("checkExpiryDateKeyIsPresent",assertResult);
     Assert.assertTrue(assertResult, "The 'expiryDate' is absent at licence key");
    }

    @Test(suiteName = "Licence expiryDate value is not null verification on user's login TC_ATST-80_step5")
    public void checkExpiryDateValueIsPresent() {
        ResponseBody profileBodyResp = UserProfile.profile(sessionToken);
        System.out.println(profileBodyResp);
        Boolean assertResult = (profileBodyResp.jsonPath().<Map<String, JsonObject>>getJsonObject("licence").get("expiryDate") !=null);
           resultMap.put("checkExpiryDateValueIsPresent",assertResult);
        Assert.assertTrue(assertResult, "The expiryDate is null");
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
        Boolean assertResult = (expiration!= null && expiration.after(new Date()));
        resultMap.put("checkLicenceIsNotExpired", assertResult);
        Assert.assertTrue(assertResult, "The expiryDate has expired");
    }
@AfterTest
public void checkCase80Result() {
        Boolean case80Res = true;
    for (String key : resultMap.keySet()) {
        if (!resultMap.get(key)) {
            case80Res = false;
        }
    }
    if (case80Res) {
        RecordTestRunResult.passedTestRunRecord("80");
    } else {
        RecordTestRunResult.failedTestRunRecord("80");
    }
}

}

