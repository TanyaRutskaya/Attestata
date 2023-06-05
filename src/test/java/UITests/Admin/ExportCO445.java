package UITests.Admin;

import APItests.EnvironmentPath;
import Qase.RecordTestRunResult;
import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static UITests.Admin.AdminManipulations.*;
import static UITests.AuthorizationManipulations.AuthorizeAdmin;
import static com.codeborne.selenide.Selenide.open;

public class ExportCO445 {
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
    @AfterTest
    public void checkCase445Result() {
        Boolean case445Res = true;
        for (String key : resultMap.keySet()) {
            if (!resultMap.get(key)) {
                case445Res = false;
            }
        }
        if (case445Res) {
            RecordTestRunResult.passedTestRunRecord("445");
        } else {
            RecordTestRunResult.failedTestRunRecord("445");
        }}
}