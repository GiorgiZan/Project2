package Steps;

import Pages.ProductChosenPage;
import io.qameta.allure.Step;

public class ProductChosenPageSteps {
    ProductChosenPage productChosenPage = new ProductChosenPage();

    @Step("Sharing product on facebook")
    public ProductChosenPageSteps clickingShare(){
        productChosenPage.shareButton.click();
        return this;
    }
}
