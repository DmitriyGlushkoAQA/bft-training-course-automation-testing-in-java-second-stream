package Module15.frontEndService.pageElements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import java.time.Duration;

import static Module15.variable.Variable.RGB_COLOR_RED;

@Slf4j
public class RadioButton {

    private Integer waitForElement = 10;

    @Getter
    private String name;
    private SelenideElement selector;

    public RadioButton(String name, SelenideElement selector) {
        this.name = name;
        this.selector = selector;
    }

    @Step("Выбрать radio button")
    public RadioButton setRadioBatton() {
        try {
            selector.shouldBe(Condition.enabled, Duration.ofSeconds(waitForElement)).scrollIntoView(true);
            selector.click();
        } catch (Exception e) {
            log.error("Ошибка выбора radio button");
            e.printStackTrace();
        }
        return this;
    }

    @Step("Radio button подсвечено красным")
    public RadioButton checkRedColor() {
        selector.shouldBe(Condition.cssValue("border-color",
                RGB_COLOR_RED), Duration.ofSeconds(waitForElement));
        String resultColor = selector.getCssValue("border-color");
        Assert.assertEquals(RGB_COLOR_RED, resultColor);
        return this;
    }
}
