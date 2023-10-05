package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FacebookPopUp {
    public SelenideElement loginValidate = $(By.id("loginform"));
    public String facebookWindow = "Facebook";
}
