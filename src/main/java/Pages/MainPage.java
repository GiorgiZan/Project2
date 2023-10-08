package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    // იდეაში უს უფრო ჰედერ პეიგ და ჰედერ სტეპს გამოდის მაგრამ სახელს  MainPage და MainPageSteps დავტოვებ მაინც
    public SelenideElement
            restButton = $(By.xpath("//li[contains(@class, 'MoreCategories')][contains(normalize-space(), 'დასვენება')]")),
            categories = $((".categoriesTitle")),
//            food = $(("li[cat_id='CatId-3']")), ეს ალტერნატივაა არ ვიცი რომელი სჯოიბა ალბათ ტექტსით უკეთესია (ორივეზე მუშაობს)
            food = $(By.linkText("კვება")),
            sushi = $(By.linkText("სუში")),

            login = $((".HeaderTools.swoop-login"));

}
