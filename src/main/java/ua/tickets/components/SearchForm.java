package ua.tickets.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.yandex.qatools.allure.annotations.Step;
import ua.tickets.pages.gd.SearchResult;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class SearchForm {

    private SelenideElement fieldDeparture = $("#from_name_as"),
                        fieldArrival = $("#to_name");

    @Step
    public SearchForm oneSideShouldBeChecked(){
        $("#one_side").shouldBe(Condition.checked);
        return this;
    }

    @Step
    public SearchForm setRoundTrip(){
        $(byXpath("//*[@id='round_trip']//..")).click();
        return this;
    }

    @Step
    public SearchForm chooseDeparture(String value){
        this.fillDeparture(value);
        $("#ui-id-1 li strong").shouldHave(Condition.text(value));
        this.fieldDeparture.pressEnter();
        return this;
    }

    @Step
    public SearchForm chooseArrival(String value){
        this.fillArrival(value);
        $("#ui-id-1 li strong").shouldHave(Condition.text(value));
        this.fieldArrival.pressEnter();
        return this;
    }

    @Step
    public SearchForm fillDeparture(String value){
        this.fieldDeparture.sendKeys(value);
        return this;
    }

    @Step
    public SearchForm fillArrival(String value){
        this.fieldArrival.sendKeys(value);
        return this;
    }

    @Step
    public static SearchResult submitSearch(){
        $("[type='submit']").click();
        return new SearchResult();
    }

}
