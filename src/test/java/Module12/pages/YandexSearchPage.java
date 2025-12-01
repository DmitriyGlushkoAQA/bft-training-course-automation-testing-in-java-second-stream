package Module12.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class YandexSearchPage {

    SelenideElement redIconUpperLeftCorner = $("path[fill='#F8604A']");

    @Step("Проверяем, что красный значок в левом верхнем углу страницы отображается")
    public YandexSearchPage checkRedIconIsVisible() {
        redIconUpperLeftCorner.shouldBe(Condition.visible);
        return this;
    }
}