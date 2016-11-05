package ua.tickets.utils;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.Rule;
import ua.tickets.utils.report.CustomWatcher;

public abstract class BaseTest {

    @Rule
    public CustomWatcher watcher = new CustomWatcher();

    protected static void clearCookies() {
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        Selenide.sleep(300);
    }

}
