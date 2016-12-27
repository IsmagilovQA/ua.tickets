package ua.tickets.pages.gd;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;

public class GDHomePage {

    public GDHomePage(){
        $(by("data-auto-controller*", "GdSearchFormController")).shouldBe(Condition.visible);
    }

    public static GDHomePage openGDHomePage(){
        Selenide.open(Configuration.baseUrl);
        return new GDHomePage();
    }

}
