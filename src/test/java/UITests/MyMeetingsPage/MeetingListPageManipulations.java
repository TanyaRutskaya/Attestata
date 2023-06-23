package UITests.MyMeetingsPage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;

public class MeetingListPageManipulations {
    static Integer tomorrowDate;
    public static SelenideElement
            calendarButton = $(By.xpath(".//button[contains(text(), 'calen')]")),
            startScheduledMeetingButton = $(By.xpath("/html/body/div/div[3]/div[2]/div[2]/div/table/tbody/tr[1]/td[3]/button[1]")),
            endSessionButton = $(By.xpath("/html/body/div/div[3]/div/div/div/div[1]/div[2]/div/button[2]")),
            calendarExpanded = $(By.cssSelector(".react-datepicker")),
            calendarTodayDate = $(By.cssSelector((".date-picker-field__active"))),
            calendarTomorrowDate = $(By.xpath(".//div[contains(@class, 'react-datepicker__day') and normalize-space(text())='" + tomorrowDate + "']"));

    public static void meetingStart() {
        startScheduledMeetingButton.isDisplayed();
        calendarButton.shouldBe(visible);
        startScheduledMeetingButton.click();
        endSessionButton.shouldBe(visible);
    }

    public static String calendarTodayColor() {
        refresh();
        calendarButton.click();
        calendarExpanded.shouldBe(visible);
        String colorCode = calendarTodayDate.getCssValue("background-color");
        String hexacolor = Color.fromString(colorCode).asHex();
        System.out.println("Color is :" + hexacolor);
        return hexacolor;
    }

    public static String calendarTomorrowColor() {
        calendarButton.click();
        calendarExpanded.shouldBe(visible);
        calendarTodayDate.isDisplayed();
        tomorrowDate = Integer.parseInt(calendarTodayDate.getText()) + 1;
        tomorrowDate.toString();
        System.out.println("Tomorrow date is: " + tomorrowDate);
        SelenideElement calendarTomorrowDate = $(By.xpath(".//div[contains(@class, 'react-datepicker__day') and normalize-space(text())='" + tomorrowDate + "']"));
        calendarTomorrowDate.click();
        String colorCode = calendarTomorrowDate.getCssValue("border"); //получили css значение завтрашней даты
        String getRGBColor = colorCode.substring(14,25);
        String[] rgbParts = getRGBColor.split("[,\\s]+");
        Integer r = Integer.valueOf(rgbParts[0]);
        Integer g = Integer.valueOf(rgbParts[1]);
        Integer b = Integer.valueOf(rgbParts[2]);
        String tomorrowColorhex = String.format("#%02x%02x%02x", r, g, b);
        System.out.println(tomorrowColorhex);
        return tomorrowColorhex;
        }
    }
