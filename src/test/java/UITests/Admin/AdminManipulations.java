package UITests.Admin;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AdminManipulations {
    public static SelenideElement
    exportButton = $(By.xpath("//a[contains(text(), 'Export')]")),
    exportOnlyActiveCO = $(By.xpath("//a[contains(text(),'Only active')]")),
    exportAllCO = $(By.xpath("//a[contains(text(), 'All')]"));

    public static void PressExportAllButton(){
        exportButton.click();
        exportAllCO.shouldBe(visible);
        exportAllCO.click();
    }
    public static void PressExportOnlyActiveCOButton(){
        exportButton.click();
        exportOnlyActiveCO.shouldBe(visible);
        exportOnlyActiveCO.click();
    }
}
