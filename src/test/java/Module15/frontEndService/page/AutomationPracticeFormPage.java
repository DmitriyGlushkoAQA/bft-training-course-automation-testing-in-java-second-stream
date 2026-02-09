package Module15.frontEndService.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import Module15.frontEndService.BaseSelenide;
import Module15.frontEndService.pageElements.*;
import org.awaitility.core.ConditionTimeoutException;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Slf4j
public class AutomationPracticeFormPage extends BaseSelenide {

    private File patchFile = new File("src/test/java/Module15/file/Screenshot 2025-06-25 162004.png");

    private String baseUrl = "https://demoqa.com/automation-practice-form";

    // Элементы формы регистрации
    private Input elementFirstName = new Input("First Name", $x("//*[@id='firstName']"));
    private Input elementLastName = new Input("Last Name", $x("//*[@id='lastName']"));
    private Input elementUserEmail = new Input("Email", $x("//*[@id='userEmail']"));
    private RadioButton radioButtonGenderMale = new RadioButton("Male", $("label[for=\"gender-radio-1\"]"));
    private RadioButton radioButtonGenderFemale = new RadioButton("Female", $("label[for=\"gender-radio-2\"]"));
    private RadioButton radioButtonGenderOther = new RadioButton("Other", $("label[for=\"gender-radio-3\"]"));
    private Input inputUserNumber = new Input("Phone Number", $("#userNumber"));
    private SelenideElement inputDateOfBirth = $("#dateOfBirthInput");
    private SelenideElement inputDateOfBirthMonth = $(".react-datepicker__month-select");
    private SelenideElement inputDateOfBirthYear = $(".react-datepicker__year-select");
    private SelenideElement inputDateOfBirthDay = $(".react-datepicker__day--0");
    private SelenideElement inputSubjectsInput = $("#subjectsInput");
    private ByText byTextHobbies = new ByText("Hobbies", $x("//*[@id='hobbiesWrapper']"));
    private UploadFile inputUploadPicture = new UploadFile("Picture", $("#uploadPicture"));
    private Input inputCurrentAddress = new Input("Current Address", $("#currentAddress"));
    private ByText stateAndCity = new ByText("stateCity", $("#stateCity-wrapper"));
    private SelenideElement inputState = $("#state");
    private SelenideElement inputCity = $("#city");
    private Button buttonSubmit = new Button("Submit", $x("//*[@id='submit']"));
    private Button buttonClose = new Button("Close", $x("//*[@id='closeLargeModal']"));
    private SelenideElement modalWindow = $(".modal-body");

    @Step("Открыть страницу Регистрации формы")
    public AutomationPracticeFormPage openPage() {
        try {
            openUrl(baseUrl);
        } catch (Exception e) {
            throw new RuntimeException("Страница не загрузилась за " + timeOut + " секунд");
        }
        return this;
    }

    @Step("Ввести Имя")
    public AutomationPracticeFormPage inputFirstName(String firstName) {
        log.info("Ввод Имени: {}", firstName);
        elementFirstName.setInput(firstName);
        return this;
    }

    @Step("Ввести Фамилию")
    public AutomationPracticeFormPage inputLastName(String lastName) {
        log.info("Ввод Фамилии: {}", lastName);
        elementLastName.setInput(lastName);
        return this;
    }

    @Step("Ввести Email")
    public AutomationPracticeFormPage inputEmail(String email) {
        log.info("Ввод емайл: {}", email);
        elementUserEmail.setInput(email);
        return this;
    }

    @Step("Выбрать пол")
    public AutomationPracticeFormPage selectGender(String gender) {
        log.info("Ввод Пола: {}", gender);
        switch (gender.toLowerCase()) {
            case "male":
                radioButtonGenderMale.setRadioBatton();
                break;
            case "female":
                radioButtonGenderFemale.setRadioBatton();
                break;
            case "other":
                radioButtonGenderOther.setRadioBatton();
                break;
            default:
                throw new IllegalArgumentException("Некорректный пол");
        }
        return this;
    }

    @Step("Ввести Номер телефона")
    public AutomationPracticeFormPage inputMobile(String phone) {
        log.info("Ввод Телефона: {}", phone);
        inputUserNumber.setInput(phone);
        return this;
    }

    @Step("Ввести дату рождения")
    public AutomationPracticeFormPage inputDateOfBitrh(String month, String year, String day) {
        log.info("Ввод даты рождения");
        log.info("Год: {}", year);
        log.info("Месяц: {}", month);
        log.info("Число: {}", day);
        inputDateOfBirth.click();
        inputDateOfBirthMonth.selectOption(month);
        inputDateOfBirthYear.selectOption(year);
        String daySelector = String.format(".react-datepicker__day--0%s", day);
        $(daySelector).click();
        return this;
    }

    @Step("Выбрать предметы")
    public AutomationPracticeFormPage selectSubjects(String... subjects) {
        log.info("Ввод Предмета: {}", subjects);
        for (String subject : subjects) {
            inputSubjectsInput.setValue(subject).pressEnter();
        }
        return this;
    }

    @Step("Выбрать хобби")
    public AutomationPracticeFormPage selectHobbies(String hobby) {
        log.info("Ввод Хобби: {}", hobby);
        byTextHobbies.selectByText(hobby);
        return this;
    }

    @Step("Загрузить фото")
    public AutomationPracticeFormPage uploadPhoto() {
        log.info("Загрузка файла");
        inputUploadPicture.uploadFile(patchFile);
        return this;
    }

    @Step("Ввести Адрес")
    public AutomationPracticeFormPage inputAddress(String address) {
        log.info("Ввод Адреса: {}", address);
        inputCurrentAddress.setInput(address);
        return this;
    }

    @Step("Выбрать штат и город")
    public AutomationPracticeFormPage selectAddress(String stateValue, String cityValue) {
        log.info("Ввод Штата: {}", stateValue);
        log.info("Ввод Города: {}", cityValue);
        inputState.scrollIntoView(true);
        inputState.click();
        stateAndCity.selectByText(stateValue);
        inputCity.click();
        stateAndCity.selectByText(cityValue);
        return this;
    }

    @Step("Отправить форму")
    public AutomationPracticeFormPage submitForm() {
        log.info("Нажать Submit");
        buttonSubmit.buttonClick();
        return this;
    }

    @Step("Закрыть таблицу")
    public AutomationPracticeFormPage closeForm() {
        log.info("Закрыть таблицу");
        buttonClose.buttonClick();
        return this;
    }

    @Step("Проверка результата в модальном окне, ключа {key} и значения {value}")
    public AutomationPracticeFormPage checkResultForm(String key, String value) {
        try {
            modalWindow.shouldBe(Condition.visible);
            log.info("Проверяем наличие ключа '" + key + "' и значения '" + value + "'");
            modalWindow.shouldHave(text(key), text(value));
        } catch (ConditionTimeoutException e) {
            String errorMessage = String.format(
                    "Ошибка при проверке модального окна:\n" +
                            "Ожидаемый ключ: '%s'\n" +
                            "Ожидаемое значение: '%s'\n" +
                            "Модальное окно не содержит требуемых данных",
                    key, value
            );
            throw new RuntimeException(errorMessage, e);
        } catch (Exception e) {
            String errorMessage = String.format(
                    "Произошла ошибка при проверке модального окна:\n" +
                            "Ожидаемый ключ: '%s'\n" +
                            "Ожидаемое значение: '%s'\n" +
                            "Ошибка: %s",
                    key, value, e.getMessage()
            );
            throw new RuntimeException(errorMessage, e);
        }
        return this;
    }

    @Step("Проверить цвет input в не заполненном обязательном поле fileName")
    public AutomationPracticeFormPage checkRedFileName() {
        elementFirstName.checkRedColor();
        return this;
    }

    @Step("Проверить цвет input в не заполненном обязательном поле lastName")
    public AutomationPracticeFormPage checkRedLastName() {
        elementLastName.checkRedColor();
        return this;
    }

    @Step("Проверить цвет input в заполненном обязательном поле lastName")
    public AutomationPracticeFormPage checkGreenLastName() {
        elementLastName.checkGreenColor();
        return this;
    }

    @Step("Проверить цвет input в НЕ валидно заполненном обязательном поле Mobile")
    public AutomationPracticeFormPage checkRedMobile() {
        inputUserNumber.checkRedColor();
        return this;
    }

    @Step("Проверить цвет input в НЕ валидно заполненном обязательном поле Gender")
    public AutomationPracticeFormPage checkRedGender() {
        radioButtonGenderMale.checkRedColor();
        return this;
    }

}
