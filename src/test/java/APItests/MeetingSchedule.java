package APItests;

import APItests.APIrequests;
import APItests.CreateMeeting;
import APItests.EnvironmentPath;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import static io.restassured.RestAssured.given;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MeetingSchedule {

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

    @Test(suiteName = "Updated meeting List is displayed and a new meeting is created")
    public void checkMeetingList() {
        String meetingBodyResp = CreateMeeting.addMeeting(sessionToken);
        System.out.println(meetingBodyResp);
                Assert.assertTrue(meetingBodyResp.contains("Hello World"),
                "The meeting list is not displayed");
    }
}

