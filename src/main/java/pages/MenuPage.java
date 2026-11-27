package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MenuPage {
    private final SelenideElement menu = $("#menu");
    private final SelenideElement enabledItem = $("#ui-id-3");
    private final SelenideElement downloadsItem = $("#ui-id-4");
    private final SelenideElement pdfItem = $("#ui-id-5");
    private final SelenideElement csvItem = $("#ui-id-6");
    private final SelenideElement excelItem = $("#ui-id-7");

    public MenuPage openPage() {
        open("https://the-internet.herokuapp.com/jqueryui/menu");
        return this;
    }

    public MenuPage checkMenuVisible() {
        menu.shouldBe(Condition.visible);
        return this;
    }

    public MenuPage openEnabledMenu() {
        enabledItem.hover();
        return this;
    }

    public MenuPage checkDownloadsVisible() {
        downloadsItem.shouldBe(Condition.visible);
        return this;
    }

    public MenuPage openDownloadsSubmenu() {
        downloadsItem.hover();
        return this;
    }

    public MenuPage checkSubmenuVisible() {
        pdfItem.shouldBe(Condition.visible);
        csvItem.shouldBe(Condition.visible);
        excelItem.shouldBe(Condition.visible);
        return this;
    }

    public MenuPage checkPdfDisabled() {
        pdfItem.shouldHave(Condition.attribute("aria-disabled", "true"));
        return this;
    }

    public MenuPage checkCsvEnabled() {
        csvItem.shouldNotHave(Condition.attribute("aria-disabled", "true"));
        return this;
    }

    public MenuPage checkExcelEnabled() {
        excelItem.shouldNotHave(Condition.attribute("aria-disabled", "true"));
        return this;
    }
}
