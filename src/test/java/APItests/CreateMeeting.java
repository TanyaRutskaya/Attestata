package APItests;

import APItests.APIrequests;
import io.restassured.http.ContentType;
import io.restassured.response.ResponseBody;
import static io.restassured.RestAssured.given;

public class CreateMeeting {
        private final String upcoming = "true";
        private final String startDate = "";
        private final String notes = "";
        private final String doName = "test";
        private final String accessToken = "";
        private final String doEmail = "dev.signatura@gmail.com";
        private final String doPhoneNumber = "";
        private final String sentEmail = "true";
        private final String timeZone = "(GMT -5:00)";
        private final String dateWithUTC = "1666100000";

       static public String addMeeting(String sessionToken) {
               ResponseBody respBody = given()
                       .headers(
                               "Authorization",
                               "Bearer " + sessionToken,
                               "Content-Type",
                               ContentType.JSON,
                               "Accept",
                               ContentType.JSON)
                       .when()
                    .queryParam(EnvironmentPath.dev() + APIrequests.profileMeetingCalendar())
                    .queryParam("upcoming", "true")
                    .queryParam("startDate","1666213200000")
                    .queryParam("notes", "Hello World")
                    .queryParam("doName", "Tanya")
                       .queryParam ("doEmail", "dev.signatura@gmail.com")
                    .queryParam("doPhoneNumber", "")
                     .queryParam("sentEmail","true")
                       .queryParam ("timeZone", "(GMT -5:00)")
                       .queryParam("dateWithUTC","1666213200000")
                    .post(EnvironmentPath.dev()+APIrequests.profileMeetingCalendar())
                       .body();
            return respBody.asPrettyString();
        }
}

