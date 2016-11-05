package ua.tickets.pages.gd;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class SearchResult {

    public SearchResult(){
        $("[data-auto-controller='GdSearchResultsController']").waitUntil(Condition.visible, 10000);
    }

}
