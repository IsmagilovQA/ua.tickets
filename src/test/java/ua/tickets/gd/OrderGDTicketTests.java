package ua.tickets.gd;

import com.codeborne.selenide.Condition;
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

    @Test
    public void orderTicketWithSearchTest(){
        String testValue = generateRandomString();
        GDHomePage.openGDHomePage();
        new SearchForm().oneSideShouldBeChecked().setRoundTrip().
                fillDeparture("Lviv").chooseArrival("Kiev");
        new DatePicker().setStartDate(34).setEndDate(36);
        SearchForm.submitSearch().
                selectThirdClassTicket().chooseFirstAvailableSit();
        User user = new User(".passenger-form");
        user.fillLastName(testValue).fillFirstName(testValue).
        fillEmail(generateRandomEmail()).fillPhoneNumber("112223333").
                acceptOfferta().submit().
                preloaderShouldBeVisible();

        new SearchResult().selectThirdClassTicket().chooseFirstAvailableSit();
        user.submit().
                preloaderShouldBeVisible();
        new Payment().fillCreditCartWithTestData().submit();
        $(".card_data samp.error").shouldBe(Condition.visible);
    }

}
