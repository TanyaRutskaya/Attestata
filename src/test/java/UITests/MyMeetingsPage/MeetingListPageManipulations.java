package UITests.MyMeetingsPage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;

public class MeetingListPageManipulations {
    public static SelenideElement
            calendarButton = $(By.xpath(".//button[contains(text(), 'calen')]")),
            startScheduledMeetingButton = $(By.xpath("/html/body/div/div[3]/div[2]/div[2]/div/table/tbody/tr[1]/td[3]/button[1]")),
            endSessionButton = $(By.xpath("/html/body/div/div[3]/div/div/div/div[1]/div[2]/div/button[2]")),
            calendarExpanded = $(By.cssSelector(".react-datepicker")),
            calendarTodayDate= $(By.cssSelector((".date-picker-field__active")));

    static public void meetingStart() {
        startScheduledMeetingButton.isDisplayed();
        calendarButton.shouldBe(visible);
        startScheduledMeetingButton.click();
        endSessionButton.shouldBe(visible);
    }

    static public String calendar() {
        refresh();
        calendarButton.click();
        calendarExpanded.shouldBe(visible);
        String colorCode= calendarTodayDate.getCssValue("background-color");
        String hexacolor = Color.fromString(colorCode).asHex();
        System.out.println("Color is :" + hexacolor);
        return hexacolor;
    }

}
