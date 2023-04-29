package UITests;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ProvinceBannerManipulations {
    public static SelenideElement
            submitProvinceButton = $(By.xpath(".//button[contains (text() ,\"Confirm\")]")),
            selectProvinceModalForm = $(By.xpath(".//div[starts-with(@class, \"modal-content\")]"));

    static public void submitProvince_Banner() {
        submitProvinceButton.click();
        selectProvinceModalForm.shouldNotBe(visible);
    }

}