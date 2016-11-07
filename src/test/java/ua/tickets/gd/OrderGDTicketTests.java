package ua.tickets.gd;

import com.codeborne.selenide.Configuration;
import org.junit.Before;
import org.junit.Test;
import ua.tickets.components.DatePicker;
import ua.tickets.components.Payment;
import ua.tickets.components.SearchForm;
import ua.tickets.components.User;
import ua.tickets.pages.gd.GDHomePage;
import ua.tickets.pages.gd.SearchResult;
import ua.tickets.utils.BaseTest;

import static com.codeborne.selenide.Selenide.open;
import static ua.tickets.utils.Random.generateRandomEmail;
import static ua.tickets.utils.Random.generateRandomString;

public class OrderGDTicketTests extends BaseTest {

    @Before
    public void before(){
        Configuration.baseUrl = "https://gd.tickets.ua/en";
    }

    @Test
    public void EndToEndTest(){
        String testValue = generateRandomString();
        GDHomePage.openGDHomePage();
        new SearchForm().oneSideShouldBeChecked().setRoundTrip().
                chooseDeparture("Dnipro").fillArrival("Lviv");
        new DatePicker().setDateAfter(3).setDateAfter(6);
        SearchForm.submitSearch().
                selectThirdClassTicket().chooseFirstAvailableSit();
        User user = new User(".passenger-form");
        user.fillLastName(testValue).fillFirstName(testValue).
        fillEmail(generateRandomEmail()).fillPhoneNumber("112223333").
                acceptOfferta().submit().
                preloaderShouldBeVisible();

        new SearchResult().selectThirdClassTicket().chooseFirstAvailableSit();
        user.fillLastName(testValue+2).fillFirstName(testValue+2)
                .submit().
                preloaderShouldBeVisible();
        new Payment().fillCreditCartWithTestData().submit().cartDataShouldHaveError();
    }

    @Test
    public void withoutSearchTest(){
        String testValue = generateRandomString();
        open("/preloader/~2210707~2218999~15.11.2016~2~ukraine~0~18.11.2016~~~0");
        new SearchResult().selectThirdClassTicket().chooseFirstAvailableSit();
        User user = new User(".passenger-form");
        user.fillLastName(testValue).fillFirstName(testValue).
                fillEmail(generateRandomEmail()).fillPhoneNumber("112223333").
                acceptOfferta().submit().
                preloaderShouldBeVisible();

        new SearchResult().selectThirdClassTicket().chooseFirstAvailableSit();
        user.fillLastName(testValue+2).fillFirstName(testValue+2)
                .submit().
                preloaderShouldBeVisible();
        new Payment().fillCreditCartWithTestData().submit().cartDataShouldHaveError();
    }
}
