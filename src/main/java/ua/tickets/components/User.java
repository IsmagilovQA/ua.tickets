package ua.tickets.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;

public class User {

    private String component;

    public User(String component){
        this.component = component;
    }

    @Step
    public User fillFirstName(String value){
        $(component+" [id*=firstname]").setValue(value);
        return this;
    }

    @Step
    public User fillLastName(String value){
        $(component+" [id*=lastname]").setValue(value);
        return this;
    }

    @Step
    public User fillEmail(String value){
        $(component+" #email").setValue(value);
        return this;
    }

    @Step
    public User fillName(String value){
        $(component+" #name").setValue(value);
        return this;
    }

    @Step
    public User nameShouldBe(String value){
        $(component+" .passenger-form__name label").shouldHave(Condition.text(value));
        return this;
    }

    @Step
    public User fillPhoneNumber(String value){
        $(component+" #phone_number").setValue(value);
        return this;
    }

    @Step
    public User acceptOfferta(){
        $(component+" #acceptIATA ins").scrollTo();
        Selenide.executeJavaScript("$('#acceptIATA ins').click()");
        return this;
    }

    @Step
    public User submit(){
        $(component+" [type='submit']").click();
        return this;
    }

    public void preloaderShouldBeVisible(){
        $(".big-preloader__place").shouldBe(Condition.visible);
    }

}
