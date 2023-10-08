package Steps;

import Pages.MainPage;
import io.qameta.allure.Step;

public class MainPageSteps {
    // იდეაში უს უფრო ჰედერ პეიგ და ჰედერ სტეპს გამოდის მაგრამ სახელს  MainPage და MainPageSteps დავტოვებ მაინც
    MainPage mainPage = new MainPage();

    @Step("Clicking on Rest button")
    public MainPageSteps clickRestButton(){
        mainPage.restButton.click();
        return this;
    }
    @Step ("Clicking on categories on main page")
    public MainPageSteps categoriesClick(){
        mainPage.categories.click();
        return this;
    }
    @Step("Hovering on Food in categories")
    public MainPageSteps foodHover(){
        mainPage.food.hover();
        return this;
    }
    @Step("Clicking on sushi section after hovering")
    public MainPageSteps sushiClick(){
        mainPage.sushi.click();
        return this;
    }
    @Step("Login Menu")
    public MainPageSteps loginMenu(){
        mainPage.login.click();
        return this;
    }
}
