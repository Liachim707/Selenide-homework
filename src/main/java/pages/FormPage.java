package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;

public class FormPage {
    private final SelenideElement firstName = $("#firstName");
    private final SelenideElement lastName = $("#lastName");
    private final SelenideElement email = $("#userEmail");
    private final SelenideElement maleGender = $("#gender-radio-1");
    private final SelenideElement femaleGender = $("#gender-radio-2");
    private final SelenideElement mobile = $("#userNumber");
    private final SelenideElement subject = $("#subjectsInput");
    private final SelenideElement sportsHobby = $("#hobbies-checkbox-1");
    private final SelenideElement address = $("#currentAddress");
    private final SelenideElement submitButton = $("#submit");

    public FormPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        return this;
    }

    public FormPage checkFormVisible() {
        firstName.shouldBe(Condition.visible);
        lastName.shouldBe(Condition.visible);
        email.shouldBe(Condition.visible);
        maleGender.shouldBe(Condition.exist);
        femaleGender.shouldBe(Condition.exist);
        mobile.shouldBe(Condition.visible);
        subject.shouldBe(Condition.visible);
        sportsHobby.shouldBe(Condition.exist);
        address.shouldBe(Condition.visible);
        submitButton.shouldBe(Condition.visible);
        return this;
    }

    public FormPage setFirstName(String value) { firstName.setValue(value); return this; }
    public FormPage setLastName(String value) { lastName.setValue(value); return this; }
    public FormPage setEmail(String value) { email.setValue(value); return this; }
    public FormPage selectMaleGender() { $("label[for='gender-radio-1']").click(); return this; }
    public FormPage selectFemaleGender() { $("label[for='gender-radio-2']").click(); return this; }
    public FormPage setMobile(String value) { mobile.setValue(value); return this; }
    public FormPage setSubject(String value) { subject.setValue(value).pressEnter(); return this; }
    public FormPage selectSportsHobby() { $("label[for='hobbies-checkbox-1']").click(); return this; }
    public FormPage setAddress(String value) { address.setValue(value); return this; }
    public FormPage submit() { submitButton.scrollTo().click(); return this; }

    public SelenideElement getFirstName() { return firstName; }
    public SelenideElement getLastName() { return lastName; }
    public SelenideElement getEmail() { return email; }
    public SelenideElement getMobile() { return mobile; }
    public SelenideElement getSubject() { return subject; }
    public SelenideElement getAddress() { return address; }
    public boolean isMaleSelected() { return maleGender.isSelected(); }
    public boolean isSportsHobbySelected() { return sportsHobby.isSelected(); }
    public boolean isFirstNameValueMissing() {
        return executeJavaScript("return arguments[0].validity.valueMissing", firstName);
    }
}
