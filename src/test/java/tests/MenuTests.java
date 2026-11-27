package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.MenuPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;

class MenuTests {
    private MenuPage menuPage;

    @BeforeEach
    void setUp() {
        menuPage = new MenuPage();
        menuPage.openPage();
    }

    @Test
    void menuShouldBeVisible() {
        menuPage.checkMenuVisible();
    }

    @Test
    void submenuShouldAppearAfterHover() {
        menuPage.checkMenuVisible().openEnabledMenu().checkDownloadsVisible()
                .openDownloadsSubmenu().checkSubmenuVisible();
    }

    @Test
    void menuItemsShouldHaveCorrectAvailability() {
        menuPage.openEnabledMenu().openDownloadsSubmenu()
                .checkPdfDisabled().checkCsvEnabled().checkExcelEnabled();
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }
}
