package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class RegistartionPage {
    public SelenideElement
            registration = $(By.partialLinkText("რეგისტრაცია")),
            firstName = $(By.id("pFirstName")),
            lastName = $(By.id("pLastName")),
            email = $(By.id("pEmail")),
            phoneNumber = $(By.id("pPhone")),

            birthDate = $(By.id("pDateBirth")),

            password = $(By.id("pPassword")),
            confirmPassword = $(By.id("pConfirmPassword")),
            regButton = $(By.xpath("//input[@type='button' and @value='რეგისტრაცია']")),
            regMessage = $(By.id("physicalInfoMassage"));

}
