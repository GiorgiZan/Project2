package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SushiPage {
    public SelenideElement
            firstElement = $$(".special-offer").first(),
            firstElementFav = firstElement.$(By.className("deal-box-wishlist")),
            firstElementClick = firstElement.$(By.className("special-offer-img-container")),
            loginWindow = $(".login-register-outer"),
            soldOut = firstElement.$(By.cssSelector("div[data-width]")),
            sorting = $(".category-page-select-filter").$("#sort");
    public ElementsCollection
            sushiPrices = $$(".discounted-prices");



}
