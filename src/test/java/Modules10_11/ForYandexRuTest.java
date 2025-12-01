package Modules10_11;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class ForYandexRuTest {

    public static final String SEARCH_STRING = "//textarea[@placeholder='Найдётся всё']";
    public static final String SEARCH_BUTTON = "button[aria-label='Найти']";
    public static final String RED_ICON = "path[fill='#F8604A']";

    @Test
    @DisplayName("Первый тест")
    public void openFindAndCheckRedIconUpperLeftCornerTest() {
        step("Открыть страницу \"ya.ru\"");
        open("https://ya.ru/");

        step("Ввести значение \"БФТ\" в поисковую строку и нажать на кнопку поиска");
        $x(SEARCH_STRING).shouldBe(visible).setValue("БФТ");
        $(SEARCH_BUTTON).click();

        step("Проверить, что красный значок в левом верхнем углу страницы отображается");
        $(RED_ICON).shouldBe(visible);
    }
}