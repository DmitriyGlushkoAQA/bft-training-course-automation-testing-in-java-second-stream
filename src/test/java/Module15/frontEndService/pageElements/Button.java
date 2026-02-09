package Module15.frontEndService.pageElements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;

@Slf4j
public class Button {

    private Integer waitForElement = 10;

    @Getter
    private String name;
    private SelenideElement selector;

    public Button(String name, SelenideElement selector) {
        this.name = name;
        this.selector = selector;
    }

    @Step("Кликаем на кнопку")
    public Button buttonClick() {
        try {
            selector.shouldBe(Condition.enabled, Duration.ofSeconds(waitForElement)).scrollIntoView(true)
                    .click();
        } catch (Exception e) {
            log.error("Ошибка нажатия кнопки");
            e.printStackTrace();
        }
        return this;
    }
}
