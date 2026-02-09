package Module15.frontEndService.pageElements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.time.Duration;

@Slf4j
public class UploadFile {

    private Integer waitForElement = 10;

    @Getter
    private String name;
    private SelenideElement selector;

    public UploadFile(String name, SelenideElement selector) {
        this.name = name;
        this.selector = selector;
    }

    @Step("Загрузить файл")
    public UploadFile uploadFile(File pathFile) {
        try {
            selector.shouldBe(Condition.enabled, Duration.ofSeconds(waitForElement)).scrollIntoView(true);
            selector.uploadFile(pathFile);
        } catch (Exception e) {
            log.error("Не удалось загрузить файл");
            e.printStackTrace();
        }
        return this;
    }
}
