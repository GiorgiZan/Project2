package Steps;


import Data.Data;
import Pages.RegistartionPage;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;




public class RegistrationPageSteps {
    Data data = new Data();

    RegistartionPage registartionPage = new RegistartionPage();

    @Step("Pressing on registration")
    public RegistrationPageSteps registrationPage(){
        registartionPage.registration.click();
        return this;
    }
    @Step("Pressing register button")
    public RegistrationPageSteps clickRegButton(){
        registartionPage.regButton.scrollTo().click();
        return this;
    }
    @Step("Checking error message")
    public RegistrationPageSteps regErrorMessageChecker(){
        registartionPage.regMessage.shouldBe(Condition.exactText(data.registerErrorMessage));

        return this;
    }
}
