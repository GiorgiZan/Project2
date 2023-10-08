package Steps;

import Pages.SideBarPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class SideBarPageSteps {
    SideBarPage sideBarPage =  new SideBarPage();

    @Step("Setting minimum value to {minVal}")
    public SideBarPageSteps setValueMinPrice(String minVal) {
        sideBarPage.minPrice.scrollTo();
        sideBarPage.minPrice.setValue(minVal);
        return this;
    }

    @Step("Setting maximum value to {maxVal}")
    public SideBarPageSteps setValueMaxPrice(String maxVal) {
        sideBarPage.maxPrice.scrollTo();
        sideBarPage.maxPrice.setValue(maxVal);
        return this;
    }

    @Step("Pressing on search button")
    public SideBarPageSteps pressSearchButton() {
        sideBarPage.searchButton.scrollTo();
        executeJavaScript("arguments[0].click();", sideBarPage.searchButton);
        return this;
    }
}
