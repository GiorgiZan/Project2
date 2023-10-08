package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProductChosenPage {
    public SelenideElement shareButton = $(By.partialLinkText("გაზიარება"));
}
