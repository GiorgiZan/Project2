package Steps;

import Data.Data;
import Pages.RestPage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertFalse;


public class RestPageSteps {
    RestPage restPage = new RestPage();
    Data data = new Data();


    @Step("Checking that all returned elements on the first page are in selected range")
    public RestPageSteps checkSelectedRange(){
        // ეს უბრალოდ რომ ზევით ასქროლოს ამის გარეშეც მუშაობს კარგად (გიო სანამ ატვირთავ წაშალე თუ გინდა ეს კოსმეტიუკრია მაინც)
        executeJavaScript("window.scrollTo(0, 0)");

        for (SelenideElement parentElement : restPage.hotelPrices) {
            ElementsCollection childElements = parentElement.$$(By.cssSelector(":first-child"));

            for (SelenideElement childElement : childElements) {
                String costOfChildElements = childElement.getText();
                String costWithoutSign = costOfChildElements.replace("₾", "");

                double costValue = Double.parseDouble(costWithoutSign);

                try {
                    assertFalse(costValue < Double.parseDouble(data.minPrice) || costValue >  Double.parseDouble(data.maxPrice));
                }
                catch (AssertionError error){
                    throw new AssertionError("Current Cost is not in the selected range " + data.minPrice + " to " + data.maxPrice + ", and its: "  + costValue );

                }
            }
        }
        return this;

    }


}

