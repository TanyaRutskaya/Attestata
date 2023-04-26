package APItests;

import io.restassured.http.ContentType;
import io.restassured.response.ResponseBody;
import static io.restassured.RestAssured.given;

public class CreateMeeting {

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
                       .queryParam("startDate","168075527700")
                       .queryParam("notes", "Hello World")
                       .queryParam("doName", "Tanya")
                       .queryParam ("doEmail", "dev.signatura@gmail.com")
                       .queryParam("doPhoneNumber", "")
                       .queryParam("sentEmail","true")
                       .queryParam ("timeZone", "(GMT -5:00)")
                       .queryParam("dateWithUTC","1680755277000")
                       .post(EnvironmentPath.dev()+APIrequests.profileMeetingCalendar())
                       .body();
            return respBody.asPrettyString();
        }
}