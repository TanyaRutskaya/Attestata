package APItests;

import io.restassured.response.ResponseBody;
import org.testng.Assert;

import static APItests.LoginWithValidCredentials.sessionToken;
import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MeetingSchedule {

    @BeforeTest
    public void setupTest() {
        LoginWithValidCredentials.DevUserAuthorizedToken();
    }

    @Test(suiteName = "Updated meeting List is displayed and a new meeting is created")
    public static void checkMeetingList() {
        String meetingBodyResp = CreateMeeting.addMeeting(sessionToken);
        System.out.println(meetingBodyResp);
        Assert.assertTrue(meetingBodyResp.contains("Hello World"),
                "The meeting list is not displayed");
    }
}