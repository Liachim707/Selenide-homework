package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.FormPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.closeWebDriver;

class FormTests {
    private FormPage formPage;

    @BeforeEach
    void setUp() {
        formPage = new FormPage();
        formPage.openPage();
    }

    @Test
    void formFieldsShouldBeVisible() {
        formPage.checkFormVisible();
    }

    @Test
    void userShouldBeAbleToEnterAndSelectData() {
        formPage.setFirstName("Ivan").setLastName("Ivanov")
                .setEmail("ivan.ivanov@example.com").selectMaleGender()
                .setMobile("9876543210").setSubject("Math")
                .selectSportsHobby().setAddress("Moscow, Red Square");

        formPage.getFirstName().shouldHave(value("Ivan"));
        formPage.getLastName().shouldHave(value("Ivanov"));
        formPage.getEmail().shouldHave(value("ivan.ivanov@example.com"));
        formPage.getMobile().shouldHave(value("9876543210"));
        formPage.getSubject().shouldHave(value("Math"));
        formPage.getAddress().shouldHave(value("Moscow, Red Square"));

        if (!formPage.isMaleSelected()) throw new AssertionError("Мужской пол не выбран");
        if (!formPage.isSportsHobbySelected()) throw new AssertionError("Хобби «Спорт» не выбрано");
    }

    @Test
    void requiredFirstNameShouldBeValidated() {
        formPage.submit();
        if (!formPage.isFirstNameValueMissing()) {
            throw new AssertionError("Пустое обязательное поле First Name не прошло HTML5-валидацию");
        }
    }

    @Test
    void validFormShouldBeSubmitted() {
        formPage.setFirstName("Ivan").setLastName("Ivanov")
                .setEmail("ivan.ivanov@example.com").selectMaleGender()
                .setMobile("9876543210").setSubject("Math")
                .selectSportsHobby().setAddress("Moscow, Red Square").submit();

        $("#example-modal-sizes-title-lg").shouldBe(com.codeborne.selenide.Condition.visible)
                .shouldHave(text("Thanks for submitting the form"));
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }
}
