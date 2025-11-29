package Module12.tests;

import Module12.settings.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class ForYandexRuTest extends BaseTest {

    @Test
    @DisplayName("ДЗ к модулю 12")
    public void openFindAndCheckRedIconUpperLeftCornerTest() {
        step("Открываем страницу, вводим в строку поиска значение, нажимаем кнопку \"Найти\"");
        yaMainPage.openWebsite("https://ya.ru/")
                .setSearchQuery("БФТ")
                .clickSearchButton();

        step("Проверяем, что красный значок в левом верхнем углу страницы отображается");
        yaSearchPage.checkRedIconIsVisible();
    }
}