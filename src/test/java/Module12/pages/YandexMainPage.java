package Module12.pages;

import Module12.pages.element.Button;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class YandexMainPage {

    SelenideElement searchString = $x("//textarea[@placeholder='Найдётся всё']");
    SelenideElement searchButton = $("button[aria-label='Найти']");
    private final Button userButton = new Button("Кнопка \"Найти\"", searchButton);

    @Step("Открываем страницу")
    public YandexMainPage openWebsite(String url) {
        open(url);
        return this;
    }

    @Step("Вводим значение в поисковую строку")
    public YandexMainPage setSearchQuery(String searchQuery) {
        searchString.setValue(searchQuery);
        return this;
    }

    @Step("Нажимаем на кнопку \"Найти\"")
    public YandexMainPage clickSearchButton() {
        userButton.click();
        return this;
    }
}