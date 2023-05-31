package UITests.Admin;

import APItests.EnvironmentPath;
import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static UITests.Admin.AdminManipulations.*;
import static UITests.AuthorizationManipulations.AuthorizeAdmin;
import static com.codeborne.selenide.Selenide.open;

public class ExportAllCO {
    private Map<String, Boolean> resultMap = new HashMap<String, Boolean>();

    @BeforeClass
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
        Configuration.browserSize = "1440x900";
    }

    @BeforeTest
    public void setupTest() {
        open(EnvironmentPath.adminQA());
        AuthorizeAdmin();
    }

    @Test(suiteName = "ExportALL button is pressed, dialog window is displayed")
    public void ExportAllCO() {
        PressExportAllButton();
        Boolean assertResult = exportButton.isDisplayed();
        resultMap.put("ExportAllCO", assertResult);
        Assert.assertTrue(assertResult, "Export button is not displayed");
    }

    @Test(suiteName = "ExportALL button is pressed, dialog window is displayed")
    public void ExportActiveCO() {
        PressExportOnlyActiveCOButton();
        Boolean assertResult = exportButton.isDisplayed();
        resultMap.put("ExportActiveCO", assertResult);
        Assert.assertTrue(assertResult, "Export button is not displayed");
    }
}