package UITests;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CancelSubscriptionManipulations {
    public static SelenideElement
            cancelButton = $(By.cssSelector("._2zLKU")),
            localeEnButton = $(By.xpath("//button[contains(text(),'EN')]")),
            localeFrButton = $(By.xpath("//button[contains(text(),'FR')]")),
            undoButton = $(By.xpath("/html/body/div[2]/div/div[1]/div/div/div[2]/div/div[2]/div[1]/button")),
            sorryToSeeUGoHeader_modalFormEn = $(By.xpath("//h3[contains(text(),'Are you sure')]")),
            sorryToSeeUGoHeader_modalFormFr = $(By.xpath("//h3[contains(text(),'Êtes-vous sûr')]")),
            sorryToSeeUGoDescription_modalFormFr = $(By.xpath("//p[contains(text(), 'Vous pourrez cependant redémarrer votre abonnement à tout moment.')]")),
            sorryToSeeUGoDescription_modalFormEn = $(By.xpath("//p[contains(text(), 'Still you will be able to relaunch your subscription at any time.')]")),
    //  sorryToSeeUGoDescription_modalFormFr = $(By.xpath("//div[contains(text(), 'Nous sommes désolés de vous voir partir! Actuellement, vous utilisez Essai gratuit: votre Abonnement n'a pas encore été activé. Si vous souhaitez annuler votre abonnement, veuillez sélectionner Confirmer ci-dessous. Êtes-vous sûr? Lorsque L'essai gratuit se termine, vous n'aurez plus la possibilité de démarrer les sessions de réunion que vous pourriez avoir dans votre emploi du temps. Votre compte est toujours actif et vous pourrez redémarrer votre abonnement à tout moment.')]")),
    // sorryToSeeUGoDescription_modalFormEn = $(By.xpath("//div[contains(text(),'If you would like to proceed with canceling your subscription, please select Confirm below. Are you sure? When Free trial ends, you will not have the ability to start meeting sessions you may have in your schedule. Your account is still active and you will be able to restart your subscription at any time.')]")),
            scheduleMeetingButton = $(By.xpath(".//a[contains(text(), 'Schedule a meeting')]")),
            sorryToSeeUGoHeader_modalForm=$(By.cssSelector(".modal-content"));


    static public void modalFormRUSureIsDisplayed_Fr() {
        // localeFrButton.click();
        cancelButton.scrollTo();
        cancelButton.click();
        sorryToSeeUGoHeader_modalFormFr.shouldBe(visible);
    }

    static public void modalFormRUSureIsDisplayed_En() {
        localeEnButton.click();
        cancelButton.scrollTo();
        cancelButton.click();
        sorryToSeeUGoHeader_modalFormEn.shouldBe(visible);
    }

    static public void modalFormClosed() {
        undoButton.click();
        sorryToSeeUGoHeader_modalForm.shouldNotBe(visible);


    }

    static public void scheduleMetingbuttonClick() {
        cancelButton.click();
        scheduleMeetingButton.shouldBe(visible);
    }
}