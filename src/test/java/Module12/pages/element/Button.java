package Module12.pages.element;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class Button {

    String name;
    SelenideElement element;

    public Button(String name, SelenideElement element) {
        this.name = name;
        this.element = element;
    }

    public Button click() {
        element.shouldBe(Condition.visible, Condition.enabled).click();
        return this;
    }
}