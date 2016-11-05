package ua.tickets.gd;

import com.codeborne.selenide.Configuration;
import org.junit.Before;
import org.junit.Test;
import ua.tickets.components.DatePicker;
import ua.tickets.components.SearchForm;
import ua.tickets.pages.gd.GDHomePage;
import ua.tickets.utils.BaseTest;

public class FirstTest extends BaseTest {

    @Before
    public void before(){
        Configuration.baseUrl = "https://gd.tickets.ua/en";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void Test(){
        GDHomePage.openGDHomePage();
        new SearchForm().oneSideShouldBeChecked().setRoundTrip().
                chooseDeparture("Dnipro").fillArrival("Lviv");
        new DatePicker().setDateAfter(3).setDateAfter(6);
        SearchForm.submitSearch();

    }
}
