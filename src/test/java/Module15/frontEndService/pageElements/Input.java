package Module15.frontEndService.pageElements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import java.time.Duration;

import static Module15.variable.Variable.RGB_COLOR_GREEN;
import static Module15.variable.Variable.RGB_COLOR_RED;

@Slf4j
public class Input {

    private Integer waitForElement = 30;

    @Getter
    private String name;
    private SelenideElement selector;

    public Input(String name, SelenideElement selector) {
        this.name = name;
        this.selector = selector;
    }

    @Step("Ввод текста в поле")
    public Input setInput(String text) {
        try {
            selector.shouldBe(Condition.enabled, Duration.ofSeconds(waitForElement)).scrollIntoView(true);
            selector.setValue(text);
        } catch (Exception e) {
            log.error("Ошибка ввода текста в поле");
            e.printStackTrace();
        }
        return this;
    }

    @Step("Поле подсвечено красным")
    public Input checkRedColor() {
        selector.shouldBe(Condition.cssValue("border-color",
                RGB_COLOR_RED), Duration.ofSeconds(waitForElement));
        String resultColor = selector.getCssValue("border-color");
        Assert.assertEquals(RGB_COLOR_RED, resultColor);
        return this;
    }

    @Step("Поле подсвечено зелёным")
    public Input checkGreenColor() {
        selector.shouldBe(Condition.cssValue("border-color",
                RGB_COLOR_GREEN), Duration.ofSeconds(waitForElement));
        String resultColor = selector.getCssValue("border-color");
        Assert.assertEquals(RGB_COLOR_GREEN, resultColor);
        return this;
    }
}
