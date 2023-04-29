package UITests;

import APItests.EnvironmentPath;
import Qase.RecordTestRunResult;
import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;

import static UITests.CancelSubscriptionManipulations.*;
import static com.codeborne.selenide.Condition.*;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.*;

public class CancelSubscription_beforeBillingDate28 {

    private Map<String, Boolean> resultMap = new HashMap<String, Boolean>();

    @BeforeClass
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
        Configuration.browserSize = "1440x900";
    }

    @BeforeTest
    public void setupTest() {
        open(EnvironmentPath.dev());
        refresh();
        ProvinceBannerManipulations.selectProvinceModalForm.shouldBe(visible);
        ProvinceBannerManipulations.submitProvince_Banner();
        AuthorizationManipulations.AuthorizeUser();
        open(EnvironmentPath.dev() + "/fr/billing-and-invoices");
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
    @Test (suiteName = "Subscription is cancelled succesfully")
    public void cancelButtonPressed_subscriptionCancelled(){
        refresh();
        confirmCancelling();
        Boolean assertResult = !cancelSubscriptionButton.isDisplayed()&& !subscribePlanButton.isDisplayed() ;
        resultMap.put("cancelButtonPressed_subscriptionCancelled", assertResult);
        Assert.assertTrue(assertResult, "The subscription failed to be cancelled");
    }
    @Test(suiteName = "As soon as subscription is cancelled, meeting session cannot be started")
    public void CancelledSubscription_meetingSessionFailsToStart(){
        refresh();
        confirmCancelling();
    }

//TO DO:
//            // Step 3: Click Cancel button again and confirm cancellation
//            $("#cancel-subscription-button").click();
//            $("#cancel-subscription-modal .modal-footer button:contains('Cancel Subscription')").click();
//            $(".toast-message").shouldHave(text("Subscription expires on"));
//
//            // Step 4: Verify subscription is cancelled and text is displayed
//            open("/billing-and-invoices");
//            $("#cancel-subscription-button").shouldBe(disabled);
//            $(".subscription-status").shouldHave(text("Subscription is canceled. Video calls are available until"));
//            $(".next-billing-date").shouldHave(text("Subscription is canceled. Video calls are available until"));
//
//            // Step 5: Verify video calls are disabled on next billing date
//            open("/start-meeting");
//            $(".disabled-message").shouldHave(text("Video calls are disabled on the next billing date"));

    @AfterTest
    public void checkCase28Result() {
        Boolean case28Res = true;
        for (String key : resultMap.keySet()) {
            if (!resultMap.get(key)) {
                case28Res = false;
            }
        }
        if (case28Res) {
            RecordTestRunResult.passedTestRunRecord("28");
        } else {
            RecordTestRunResult.failedTestRunRecord("28");
        }
    }
}