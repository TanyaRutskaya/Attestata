package APItests;

import Qase.RecordTestRunResult;
import com.google.gson.JsonObject;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static APItests.LoginWithValidCredentials.sessionToken;
import static io.restassured.RestAssured.given;

public class ProvinceVerification_Login353 {
    private Map<String, Boolean> resultMap = new HashMap<String, Boolean>();


    @BeforeTest
    public void setupTest() {
        LoginWithValidCredentials.DevUserAuthorizedToken();
    }

    @Test(suiteName = "PROVINCE is present at billingAddress")
    public void checkProvincePresenceWhileLogin() {
        ResponseBody profileBodyResp = UserProfile.profile(sessionToken);
        System.out.println(profileBodyResp);
        Boolean assertResult = (profileBodyResp.jsonPath().<Map<String, JsonObject>>getJsonObject("billingAddress").containsKey("province"));
        resultMap.put("checkProvincePresenceWhileLogin", assertResult);
        Assert.assertTrue(assertResult, "The province is absent at billing address");

    }
        @Test(suiteName = "billingAddress: 'province' is not null ")
        public void checkProvincevalueAtBilllingAddress(){
            ResponseBody profileBodyResp = UserProfile.profile(sessionToken);
            System.out.println(profileBodyResp);
            Boolean assertResult = (profileBodyResp.jsonPath().<Map<String, JsonObject>>getJsonObject("billingAddress").get("province")!=null);
            resultMap.put("checkProvincevalueAtBilllingAddress", assertResult);
            Assert.assertTrue(assertResult, "The province value is null at billing address");

    }
    @Test(suiteName = "userAddress has a province")
    public void checkProvincePresenceAtUserAddress (){
        ResponseBody profileBodyResp = UserProfile.profile(sessionToken);
        System.out.println(profileBodyResp);
        Boolean assertResult = (profileBodyResp.jsonPath().<Map<String, JsonObject>>getJsonObject("userAddress").get("province")!=null);
        resultMap.put("checkProvincePresenceAtUserAddress", assertResult);
        Assert.assertTrue(assertResult, "The province is absent at userAddress");

    }
    @Test(suiteName = "userAddress: 'province' is not null")
    public void checkProvinceValueAtUserAddress (){
        ResponseBody profileBodyResp = UserProfile.profile(sessionToken);
        System.out.println(profileBodyResp);
        Boolean assertResult = (profileBodyResp.jsonPath().<Map<String, JsonObject>>getJsonObject("userAddress").containsKey("province"));
        resultMap.put("checkProvinceValueAtUserAddress", assertResult);
        Assert.assertTrue(assertResult, "The province value is null at user address");

    }
    @Test(suiteName = "licence has a province")
    public void checkProvinceValueAtLicenceKey (){
        ResponseBody profileBodyResp = UserProfile.profile(sessionToken);
        System.out.println(profileBodyResp);
        Boolean assertResult = (profileBodyResp.jsonPath().<Map<String, JsonObject>>getJsonObject("licence").get("province")!=null);
        resultMap.put("checkProvinceValueAtLicenceKey", assertResult);
        Assert.assertTrue(assertResult, "The province parameter is null at licence");

    }
    @Test(suiteName = "licence: 'province' is not null")
    public void checkProvinceInNotNull (){
        ResponseBody profileBodyResp = UserProfile.profile(sessionToken);
        System.out.println(profileBodyResp);
        Boolean assertResult = (profileBodyResp.jsonPath().<Map<String, JsonObject>>getJsonObject("licence").containsKey("province"));
        resultMap.put("checkProvinceInNotNull", assertResult);
        Assert.assertTrue(assertResult, "The province value is null at licence");

    }
    @AfterTest
    public void checkCase353Result() {
        Boolean case353Res = true;
        for (String key : resultMap.keySet()) {
            if (!resultMap.get(key)) {
                case353Res = false;
            }
        }
        if (case353Res) {
            RecordTestRunResult.passedTestRunRecord("353");
        } else {
            RecordTestRunResult.failedTestRunRecord("353");
        }
    }
}
