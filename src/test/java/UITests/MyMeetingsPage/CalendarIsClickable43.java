package UITests.MyMeetingsPage;

import APItests.EnvironmentPath;
import UITests.AuthorizationManipulations;
import UITests.ProvinceBannerManipulations;
import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static UITests.CancelSubscriptionManipulations.*;
import static UITests.MyMeetingsPage.MeetingListPageManipulations.calendar;
import static UITests.MyMeetingsPage.MeetingListPageManipulations.calendarTodayDate;
import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.refresh;

public class CalendarIsClickable43 {
    private Map<String, Boolean> resultMap = new HashMap<String, Boolean>();

    @BeforeClass
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
        Configuration.browserSize = "1440x900";
    }

    @BeforeTest
    public void setupTest() {
        open(EnvironmentPath.qa());
        refresh();
        ProvinceBannerManipulations.selectProvinceModalForm.shouldBe(visible);
        ProvinceBannerManipulations.submitProvince_Banner();
        AuthorizationManipulations.AuthorizeUser();
        open(EnvironmentPath.qa() + "/fr/my-meetings");
    }

    @Test(suiteName = "Today date is orange")
    public void calendarOrangeDateMarker() {
      //  refresh();
        calendar();
        Boolean assertResult =calendarTodayDate.is(cssValue("background-color", "#f5593d"));
        resultMap.put("calendarOrangeDateMarker", assertResult);
        Assert.assertTrue(assertResult, "Today's date is not an orange color");
    }
}
