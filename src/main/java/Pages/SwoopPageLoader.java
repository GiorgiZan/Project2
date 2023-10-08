package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SwoopPageLoader {
    public SelenideElement
            loading = $(".loader").$(".spinner");
}
