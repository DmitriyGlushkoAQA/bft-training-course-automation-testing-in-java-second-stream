package Module15.testFrontEnd;

import io.qameta.allure.Step;
import Module15.frontEndService.page.AutomationPracticeFormPage;
import Module15.variable.EnumPracticeFormData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static Module15.variable.Variable.*;


public class TestAutomationEnumPracticeFormDataPage {

    AutomationPracticeFormPage automationPracticeFormPage = new AutomationPracticeFormPage();

    @BeforeEach
    void setUp() {
        automationPracticeFormPage.openPage();
    }

    @Tag("Валидные тесты проверки формы регистрации")
    @Test
    @Step("Заполнить полностью всю форму регистрации")
    @DisplayName("Заполнить полностью всю форму регистрации")
    public void testCase_1() {
        //Заполнение формы
        automationPracticeFormPage.inputFirstName(EnumPracticeFormData.VALID_DATA.getFirstName());
        automationPracticeFormPage.inputLastName(EnumPracticeFormData.VALID_DATA.getLastName());
        automationPracticeFormPage.inputEmail(EnumPracticeFormData.VALID_DATA.getEmail());
        automationPracticeFormPage.selectGender(EnumPracticeFormData.VALID_DATA.getGender());
        automationPracticeFormPage.inputMobile(EnumPracticeFormData.VALID_DATA.getMobile());
        automationPracticeFormPage.inputDateOfBitrh(
                EnumPracticeFormData.VALID_DATA.getBirthDateMonth(),
                EnumPracticeFormData.VALID_DATA.getBirthDateYear(),
                EnumPracticeFormData.VALID_DATA.getBirthDateDay()
        );
        automationPracticeFormPage.selectSubjects(EnumPracticeFormData.VALID_DATA.getSubject());
        automationPracticeFormPage.selectHobbies(EnumPracticeFormData.VALID_DATA.getHobby1());
        automationPracticeFormPage.uploadPhoto();
        automationPracticeFormPage.inputAddress(EnumPracticeFormData.VALID_DATA.getAddress());
        automationPracticeFormPage.selectAddress(EnumPracticeFormData.VALID_DATA.getState(), EnumPracticeFormData.VALID_DATA.getCity());
        automationPracticeFormPage.submitForm();

        //Проверка результата
        String studentName = EnumPracticeFormData.VALID_DATA.getFirstName() + " " + EnumPracticeFormData.VALID_DATA.getLastName();
        automationPracticeFormPage.checkResultForm(STUDENT_NAME, studentName);
        automationPracticeFormPage.checkResultForm(STUDENT_EMAIL, EnumPracticeFormData.VALID_DATA.getEmail());
        automationPracticeFormPage.checkResultForm(GENDER, EnumPracticeFormData.VALID_DATA.getGender());
        automationPracticeFormPage.checkResultForm(MOBILE, EnumPracticeFormData.VALID_DATA.getMobile());
        String dateOfBirth = EnumPracticeFormData.VALID_DATA.getBirthDateDay() + " " + EnumPracticeFormData.VALID_DATA.getBirthDateMonth() + "," +
                EnumPracticeFormData.VALID_DATA.getBirthDateYear();
        automationPracticeFormPage.checkResultForm(DATE_OF_BIRTH, dateOfBirth);
        automationPracticeFormPage.checkResultForm(SUBJECTS, EnumPracticeFormData.VALID_DATA.getSubject());
        automationPracticeFormPage.checkResultForm(HOBBIES, EnumPracticeFormData.VALID_DATA.getHobby1());
        String fileName = "Screenshot 2025-06-25 162004.png";
        automationPracticeFormPage.checkResultForm(PICTURE, fileName);
        automationPracticeFormPage.checkResultForm(ADDRESS, EnumPracticeFormData.VALID_DATA.getAddress());
        String stateAndCity = EnumPracticeFormData.VALID_DATA.getState() + " " + EnumPracticeFormData.VALID_DATA.getCity();
        automationPracticeFormPage.checkResultForm(STATE_AND_CITY, stateAndCity);
        automationPracticeFormPage.closeForm();
    }

    @Tag("Валидные тесты проверки формы регистрации")
    @Test
    @Step("Заполнить только обязательные поля в форме ввода")
    @DisplayName("Заполнить только обязательные поля в форме ввода")
    public void testCase_2() {
        //Заполнение формы
        automationPracticeFormPage.inputFirstName(EnumPracticeFormData.VALID_DATA.getFirstName());
        automationPracticeFormPage.inputLastName(EnumPracticeFormData.VALID_DATA.getLastName());
        automationPracticeFormPage.selectGender(EnumPracticeFormData.VALID_DATA.getGender());
        automationPracticeFormPage.inputMobile(EnumPracticeFormData.VALID_DATA.getMobile());
        automationPracticeFormPage.submitForm();
        //Проверка заполнения
        String studentName = EnumPracticeFormData.VALID_DATA.getFirstName() + " " + EnumPracticeFormData.VALID_DATA.getLastName();
        automationPracticeFormPage.checkResultForm(STUDENT_NAME, studentName);
        automationPracticeFormPage.checkResultForm(GENDER, EnumPracticeFormData.VALID_DATA.getGender());
        automationPracticeFormPage.checkResultForm(MOBILE, EnumPracticeFormData.VALID_DATA.getMobile());
        automationPracticeFormPage.closeForm();
    }

    @Tag("Валидные тесты проверки формы регистрации")
    @Test
    @Step("Проверка требования заполнения обязательных полей")
    @DisplayName("Проверка требования заполнения обязательных полей")
    public void testCase_3() {
        automationPracticeFormPage.submitForm();
        //Тест
        automationPracticeFormPage.checkRedFileName();
        automationPracticeFormPage.checkRedLastName();
        automationPracticeFormPage.checkRedMobile();
        automationPracticeFormPage.checkRedGender();
    }

    @Tag("Не Валидные тесты проверки формы регистрации")
    @Test
    @Step("Заполнить без обязательного поля fileName")
    @DisplayName("Заполнить без обязательного поля fileName")
    public void testCase_23() {
        automationPracticeFormPage.inputLastName(EnumPracticeFormData.VALID_DATA.getLastName());
        automationPracticeFormPage.submitForm();
        automationPracticeFormPage.checkRedFileName();
        automationPracticeFormPage.checkGreenLastName();
    }

    @Tag("Не Валидные тесты проверки формы регистрации")
    @Test
    @Step("Заполнить НЕ валидным номером телефона")
    @DisplayName("Заполнить НЕ валидным номером телефона")
    public void testCase_24() {
        automationPracticeFormPage.inputMobile(EnumPracticeFormData.INVALID_DATA.getMobile());
        automationPracticeFormPage.submitForm();
        automationPracticeFormPage.checkRedMobile();
    }
}
