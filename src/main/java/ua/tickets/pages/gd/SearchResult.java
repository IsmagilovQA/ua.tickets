package ua.tickets.pages.gd;

import com.codeborne.selenide.Condition;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;

public class SearchResult {

    public SearchResult(){
        $("[data-auto-controller='GdSearchResultsController']").waitUntil(Condition.visible, 10000);
    }

    @Step
    public SearchResult selectThirdClassTicket(){
        $("[data-car-class='third'] a").click();
        return this;
    }

    @Step
    public SearchResult chooseFirstAvailableSit(){
        $("a.one-seat").click();
        return this;
    }

}
