package ua.tickets.gd;

import com.codeborne.selenide.Condition;
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

import static com.codeborne.selenide.Selenide.$;
import static ua.tickets.utils.Random.generateRandomEmail;
import static ua.tickets.utils.Random.generateRandomString;

public class OrderGDTicketTests extends BaseTest {

    @Before
    public void before(){
        Configuration.baseUrl = "https://gd.tickets.ua/en";
        Configuration.holdBrowserOpen = true;
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
        new User(".passenger-form").fillLastName(testValue).fillFirstName(testValue).
        fillEmail(generateRandomEmail()).fillPhoneNumber("112223333").
                acceptOfferta().submit();
        $(".big-preloader__place").shouldBe(Condition.visible);
        new SearchResult().selectThirdClassTicket().chooseFirstAvailableSit();
        new User(".passenger-form").fillLastName(testValue+2).fillFirstName(testValue+2)
                .submit();
        $(".big-preloader__place").shouldBe(Condition.visible);
        new Payment().fillCreditCartWithTestData().submit().cartDataShouldHaveError();
    }
}
