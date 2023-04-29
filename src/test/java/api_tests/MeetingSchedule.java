/*
package helpers;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ResponseBody;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static io.restassured.RestAssured.given;


public class MeetingSchedule {

    private String sessionToken = null;

    @Before
    public void setupTest() {
        ResponseBody body = given().queryParam(EnvironmentPath.getQaUrl() + Client.loginAPI())
                .queryParam("username", "mariaberardinelli@hotmail.com")
                .queryParam("password", "Password123")
                .get(EnvironmentPath.getQaUrl() + Client.loginAPI())
                .body();

        sessionToken = body.jsonPath().get("accessToken");
    }

    @Test
    @DisplayName("Updated meeting List is displayed and a new meeting is created")
    public void checkMeetingList() {
        String meetingBodyResp = CreateMeeting.addMeeting(sessionToken);
        System.out.println(meetingBodyResp);
                Assert.assertTrue("The meeting list is not displayed",
                        meetingBodyResp.contains("Hello World"));
    }

*/
