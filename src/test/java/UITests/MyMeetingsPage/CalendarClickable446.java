package UITests.MyMeetingsPage;

import APItests.EnvironmentPath;
import Qase.RecordTestRunResult;
import UITests.AuthorizationManipulations;
import UITests.ProvinceBannerManipulations;
import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static UITests.MyMeetingsPage.MeetingListPageManipulations.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.refresh;

public class CalendarClickable446 {
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

        String actual = calendarTodayColor();
        String expected = "#f5593d";
        Boolean assertResult = actual.equals(expected);
        resultMap.put("calendarOrangeDateMarker", assertResult);
        Assert.assertEquals(actual, expected, "Today's date is not an orange color");
    }

    @AfterTest
    public void checkCase446Result() {
        Boolean case446Res = true;
        for (String key : resultMap.keySet()) {
            if (!resultMap.get(key)) {
                case446Res = false;
            }
        }
        if (case446Res) {
            RecordTestRunResult.passedTestRunRecord("446");
        } else {
            RecordTestRunResult.failedTestRunRecord("446");
        }
}
}
