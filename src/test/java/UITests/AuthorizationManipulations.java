package UITests;

import APItests.UserManipulations;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AuthorizationManipulations {

    public static SelenideElement
            signInButton = $(By.xpath(".//button[contains(@class,\'r6wnG btn btn-default btn-md\')]")),
            emailField = $(By.xpath(".//input[contains(@name, 'loginUser')]")),
            passwordField = $(By.xpath(".//input[contains(@name, 'passwordUser')]")),
            authorizationSubmitButton = $(By.cssSelector("button._1K8lr")),
            scheduleMeetingButton = $(By.cssSelector(".z-5Zc")),
            emailFieldAdmin = $(By.xpath("//input[@id='username']")),
            passFieldAdmin = $(By.xpath("//input[@id='password']")),
            signInButtonAdmin = $(By.xpath("//button[@type='submit']"));

    static public void AuthorizeUser() {
        UserManipulations userCreds = UserManipulations.qaUserWithSubscribtion();
        signInButton.click();
        emailField.shouldBe(visible);
        emailField.sendKeys(userCreds.name);
        passwordField.sendKeys(userCreds.pass);
        authorizationSubmitButton.click();
        signInButton.shouldNotBe(visible);
    }

    static public void AuthorizeAdmin() {
        UserManipulations userCreds = UserManipulations.AdminUser();
        emailFieldAdmin.shouldBe(visible);
        emailFieldAdmin.sendKeys(userCreds.name);
        passFieldAdmin.sendKeys(userCreds.pass);
        signInButtonAdmin.click();
    }
}
