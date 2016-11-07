package ua.tickets.utils;

import com.codeborne.selenide.Configuration;
import org.junit.Before;
import org.junit.Rule;
import ua.tickets.utils.report.CustomWatcher;

public abstract class BaseTest {

    @Rule
    public CustomWatcher watcher = new CustomWatcher();

    @Before
    public void before(){
        Configuration.baseUrl = "https://gd.tickets.ua/en";
    }

}
