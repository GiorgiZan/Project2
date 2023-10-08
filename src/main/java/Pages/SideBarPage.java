package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SideBarPage {
    public SelenideElement
            inputPrices = $(".category-filter-desk").$(".price-inputs"),
            minPrice = inputPrices.$("#minprice"),
            maxPrice = inputPrices.$("#maxprice"),
            searchButton = $(".category-filter-desk ").$(".submit-form").$(".submit-button");
}
