package ua.tickets.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.yandex.qatools.allure.annotations.Step;
import ua.tickets.pages.gd.SearchResult;

import static com.codeborne.selenide.Selectors.by;
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
        $(by("for", "round_trip")).click();
        return this;
    }

    /**
     * Choose start point in visible list
     * @param value
     * Value that should be chosen
     * @return
     * itself
     */
    @Step
    public SearchForm chooseDeparture(String value){
        this.fillDeparture(value);
        $("#ui-id-1 li strong").shouldHave(Condition.text(value));
        this.fieldDeparture.pressEnter();
        return this;
    }

    /**
     * Choose end point in visible list
     * @param value
     * Value that should be chosen
     * @return
     * itself
     */
    @Step
    public SearchForm chooseArrival(String value){
        this.fillArrival(value);
        $("#ui-id-2 li strong").shouldHave(Condition.text(value));
        this.fieldArrival.pressEnter();
        return this;
    }

    /**
     * Fill exact start point
     * @param value
     * Value that should be filled
     * @return
     * itself
     */
    @Step
    public SearchForm fillDeparture(String value){
        this.fieldDeparture.sendKeys(value);
        $(".btn-clear").should(Condition.visible);
        return this;
    }

    /**
     * Fill exact end point
     * @param value
     * Value that should be filled
     * @return
     * itself
     */
    @Step
    public SearchForm fillArrival(String value){
        this.fieldArrival.sendKeys(value);
        $(".btn-clear").should(Condition.visible);
        return this;
    }

    @Step
    public static SearchResult submitSearch(){
        $("[type='submit']").click();
        return new SearchResult();
    }

}
