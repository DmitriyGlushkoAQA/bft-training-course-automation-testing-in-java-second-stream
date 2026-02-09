package Module15.frontEndService.pageElements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;

@Slf4j
public class ByText {

    private Integer waitForElement = 10;

    @Getter
    private String name;
    private SelenideElement selector;

    public ByText(String name, SelenideElement selector) {
        this.name = name;
        this.selector = selector;
    }

    @Step("Выбрать элемент по тексту")
    public ByText selectByText(String text) {
        try {
            selector.shouldBe(Condition.enabled, Duration.ofSeconds(waitForElement)).scrollIntoView(true);
            selector.$(byText(text)).click();
        } catch (Exception e) {
            log.error("Ошибка выбора элемента");
            e.printStackTrace();
        }
        return this;
    }
}
