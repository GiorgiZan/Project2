
import Allure.AllureListener;
import Data.Data;
import Steps.*;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.testng.SoftAsserts;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.open;

@Listeners({AllureListener.class, SoftAsserts.class})
@Epic("Swoop.ge Test Project")
public class TestClass extends Configuration {
    Data data = new Data();
//    SoftAssert softAssert = new SoftAssert();
    SushiPageSteps sushiPageSteps = new SushiPageSteps();
    ProductChosenPageSteps productChosenPageSteps = new ProductChosenPageSteps();
    FacebookPopUpSteps facebookPopUpSteps = new FacebookPopUpSteps();
    SwoopPageLoaderSteps swoopPageLoaderSteps = new SwoopPageLoaderSteps();
    MainPageSteps mainPageSteps = new MainPageSteps();
    RestPageSteps restPageSteps = new RestPageSteps();
    RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps();
    DbInteractionSteps dbInteractionSteps = new DbInteractionSteps();
    SideBarPageSteps sideBarPageSteps = new SideBarPageSteps();

    @BeforeMethod(groups = {"Regression1", "Regression2"})
    public void openSwoopWebsite () {
        open("https://www.swoop.ge/");
    }
    @Test(groups = "Regression1", description = "Looking for budget hotel")
    @Description("Searching for hotel, price between 200 to 230 in this example")
    @Story("Hotel sort and search")
    @Feature("Hotel Search")
    public void firstMethod(){
        mainPageSteps.clickRestButton();
        sideBarPageSteps.setValueMinPrice(data.minPrice)
                .setValueMaxPrice(data.maxPrice)
                .pressSearchButton();
        swoopPageLoaderSteps.waitingToLoad();
        restPageSteps.checkSelectedRange();


    }

    @Test(groups = "Regression1", description = "Sushi time with discount vouchers!")
    @Description("Making sushi favourite logging in and buying it with vouchers")
    @Story("Making discounted sushi favourite")
    @Feature("Favourite sushi")
    public void secondMethod(){
        mainPageSteps.categoriesClick()
                .foodHover()
                .sushiClick();
        sushiPageSteps.makeFav()
                .loginWindowChecker()
                .checkVouchersAvailability();
    }

    @Test(groups = "Regression2", description = "Sorting sushi from highest to lowest and then comparing")
    @Description("Sushi sorting and then checking if first item price is higher than second item")
    @Story("Sushi sort with checker")
    @Feature("Sushi Sorting")
    public void thirdMethod(){
        mainPageSteps.categoriesClick()
                .foodHover()
                .sushiClick();
        sushiPageSteps.descendingSort();
        swoopPageLoaderSteps.waitingToLoad();

        sushiPageSteps.checkIfFirstPriceIsHigherThanNextPrice(0);  // აქ ჰარდს ვიყენებ მაგრამ სოფტის შემთხვევაში checkIfFirstPriceIsHigherThanNextPrice გადავცემდი softAsserts, ესე იქნებოდა  sushiPageSteps.checkIfFirstPriceIsHigherThanNextPrice(0, softAssert);  და ბოლოში     softAssert.assertAll();

    }

    @Test(groups = "Regression2", description = "Sharing a sushi product on social media")
    @Feature("Sharing on Social Media")
    @Story("Clicking on first sushi and then sharing  it on facebook because I LOVE SWOOP GE")
    @Description("Sharing first sushi product on Facebook page and validating that login window is visible ")
    public void forthMethod(){
        mainPageSteps.categoriesClick()
                .foodHover()
                .sushiClick();
        sushiPageSteps.clickingOnFirstSushi();
        productChosenPageSteps.clickingShare();

        facebookPopUpSteps.switchingToFacebookWindow()
                .validateLogin();

    }

    @Test(groups = "Regression2", description = "User registration and validation")
    @Feature("User Registration")
    @Story("registration via SQL Database")
    @Description("User registration from SQL database, validation, and cleanup.")
    public void fifthMethod(){
        int generatedUserId = dbInteractionSteps.insertUserIntoDatabase(data.firstName, data.lastName, data.phone, data.email, data.dateOfBirth, data.password);
        mainPageSteps.loginMenu();
        registrationPageSteps.registrationPage();

        dbInteractionSteps.sendUserInfoById(generatedUserId);
        registrationPageSteps.clickRegButton()
                .regErrorMessageChecker();

        dbInteractionSteps.deleteUserByIdFromDatabase(generatedUserId);
    }



}
