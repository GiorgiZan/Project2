package Steps;

import Pages.SwoopPageLoader;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

public class SwoopPageLoaderSteps {
    SwoopPageLoader swoopPageLoader = new SwoopPageLoader();

    @Step("waiting to load ")
    public SwoopPageLoaderSteps waitingToLoad(){
        swoopPageLoader.loading.shouldNot(Condition.visible);
        return this;
    }
}
