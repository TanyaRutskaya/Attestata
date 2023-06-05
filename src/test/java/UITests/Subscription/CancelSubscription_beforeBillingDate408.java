package UITests.Subscription;

import APItests.EnvironmentPath;
import Qase.RecordTestRunResult;
import UITests.AuthorizationManipulations;
import UITests.ProvinceBannerManipulations;
import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;

import static UITests.Subscription.CancelSubscriptionManipulations.*;
import static UITests.MyMeetingsPage.MeetingListPageManipulations.*;
import static com.codeborne.selenide.Condition.*;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.*;

public class CancelSubscription_beforeBillingDate408 {

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
        open(EnvironmentPath.qa() + "/fr/billing-and-invoices");
    }

    @Test(suiteName = "Click Cancel button and verify modal form Fr version")
    public void cancelBeforeBillingDate_modalFormCheck_Fr() {

        refresh();
        modalFormRUSureIsDisplayed_Fr();
        Boolean assertResult = sorryToSeeUGoDescription_modalFormFr.isDisplayed() && sorryToSeeUGoHeader_modalFormFr.isDisplayed();
        resultMap.put("cancelBeforeBillingDate_modalFormCheck_Fr", assertResult);
        Assert.assertTrue(assertResult, "Fr_The header or the description of the modal form is not displayed or wrong");
    }

    @Test(suiteName = "Click Cancel button and verify modal form En version")
    public void cancelBeforeBillingDate_modalFormCheck_En() {
        modalFormRUSureIsDisplayed_En();
        Boolean assertResult = sorryToSeeUGoHeader_modalFormEn.isDisplayed() && sorryToSeeUGoDescription_modalFormEn.isDisplayed();
        resultMap.put("cancelBeforeBillingDate_modalFormCheck_En", assertResult);
        Assert.assertTrue(assertResult, "En_The header of the modal form is not displayed or wrong");

    }

    @Test(suiteName = "Undo button being pressed-the subscription remains")
    public void undoButtonPressed_subscriptionRemains() {
        refresh();
        undoCancelingSubscription();
        Boolean assertResult = cancelSubscriptionButton.isDisplayed()&& subscribePlanButton.isDisplayed() ;
        resultMap.put("undoButtonPressed_subscriptionRemains", assertResult);
        Assert.assertTrue(assertResult, "The subscription cancellation being UNDONE, fails");
    }
    @Test (suiteName = "Subscription is cancelled successfully")
    public void cancelButtonPressed_subscriptionCancelled(){
        refresh();
        confirmCancelling();
        Boolean assertResult = warningToastMessage.isDisplayed()&& cancelSubscriptionButton.isDisplayed()&&textAboveCancelButton.isDisplayed();
        resultMap.put("cancelButtonPressed_subscriptionCancelled", assertResult);
        Assert.assertTrue(assertResult, "The subscription failed to be cancelled");
    }

    @Test(suiteName = "As soon as subscription is cancelled, meeting session can be started")
    public void CancelledSubscription_meetingSessionStarted(){
        refresh();
        confirmCancelling();
        open("https://qa-attestata.axamit.com/fr/my-meetings");
        meetingStart();
        Boolean assertResult = endSessionButton.isDisplayed();
        resultMap.put("CancelledSubscription_meetingSessionStarted", assertResult);
        Assert.assertTrue(assertResult, "The meeting session failed to start");
    }

    @AfterTest
    public void checkCase408Result() {
        Boolean case408Res = true;
        for (String key : resultMap.keySet()) {
            if (!resultMap.get(key)) {
                case408Res = false;
            }
        }
        if (case408Res) {
            RecordTestRunResult.passedTestRunRecord("408");
        } else {
            RecordTestRunResult.failedTestRunRecord("408");
        }
    }
}