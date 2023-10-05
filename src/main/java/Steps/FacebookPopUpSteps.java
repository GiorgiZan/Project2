package Steps;

import Pages.FacebookPopUp;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.switchTo;

public class FacebookPopUpSteps {
    FacebookPopUp facebookPopUp = new FacebookPopUp();

    @Step("Validating if Facebook login page has appeared ")
    public FacebookPopUpSteps validateLogin(){
        facebookPopUp.loginValidate.shouldBe(Condition.visible);
        return this;
    }

    @Step("Switching to Facebook window")
    public FacebookPopUpSteps switchingToFacebookWindow(){
        switchTo().window(facebookPopUp.facebookWindow);
        return this;
    }
}
