package Steps;

import Data.Data;
import Pages.SushiPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class SushiPageSteps {
    SushiPage sushiPage = new SushiPage();
    Data data = new Data();

    @Step("Making first sushi offer favourite")
    public SushiPageSteps makeFav(){
        sushiPage.firstElementFav.click();
        return this;
    }

    @Step("verifying that Login Window has appeared")
    public SushiPageSteps loginWindowChecker(){
        sushiPage.loginWindow.shouldHave(Condition.attribute("style", "right: 0px;"));
        return this;
    }
    @Step("Checking if vouchers on first sushi are sold out")
    public SushiPageSteps checkVouchersAvailability(){
        sushiPage.soldOut.shouldNotHave(Condition.attribute("data-width", "100"));
        return this;
    }

    @Step("Sort by descending cost")
    public SushiPageSteps descendingSort(){
       sushiPage.sorting.selectOptionContainingText(data.sortByDescending);
        return this;
    }

    //დავალებაში მოთხოვნილი იყო პირველის ფასის შედარებია მეორესთან მაგრამ მე უფრო დინამური გავხადე და ეხლა შესაძლებელია ნებისიმიერი ორი პროდუქტის(სუშის) ფასის შედარება ( საბოლოოდ გადავაკეთე ერთ პროდუქტზე და მის მოდმევნოზე ესე უფრო ლოგიკური იქნება და უფრო შეეფერება მოთხოვნილებას)
    // ეხლა აქ ისე მიწერია როგორც დავალებაშია მოთხოვნილი პირველს ვნახულობ რომ მეტია მეორეზე მაგრამ სხვებზეც იმუშავებდა ( მაგალითად მეორე და მესამეზე და ა.შ)
    @Step("Checking if the price of the first item is higher than the price of its next item")
    public SushiPageSteps checkIfFirstPriceIsHigherThanNextPrice(int first){
        SelenideElement firstItem = sushiPage.sushiPrices.get(first).$(By.cssSelector(":first-child"));
        SelenideElement nextItemAfterFirst = sushiPage.sushiPrices.get(first + 1).$(By.cssSelector(":first-child"));
        String firstItemWithoutSign = firstItem.getText().replace("₾", "");
        String nextItemWithoutSign = nextItemAfterFirst.getText().replace("₾", "");
        Assert.assertTrue(Double.parseDouble(firstItemWithoutSign)  > Double.parseDouble(nextItemWithoutSign) );
        return this;
    }

    @Step("Navigate to the first returned item")
    public SushiPageSteps clickingOnFirstSushi(){
        sushiPage.firstElementClick.click();
        return this;
    }

}
