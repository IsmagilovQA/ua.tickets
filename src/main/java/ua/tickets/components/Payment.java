package ua.tickets.components;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class Payment {

    public Payment(){
        $("[data-auto-controller='PaymentController']").shouldBe(Condition.visible);
    }

    public Payment fillCreditCartWithTestData(){
        $("#card_number_0").sendKeys("1234");
        $("#card_number_1").sendKeys("5678");
        $("#card_number_2").sendKeys("4321");
        $("#card_number_3").sendKeys("1234");
        $("#card_date_month").sendKeys("12");
        $("#card_date_year").sendKeys("20");
        $("#card_holder").sendKeys("TestName TestSurname");
        $("#card_cvv").sendKeys("123");
        return this;
    }

    public Payment submit(){
        $("[type='submit']").click();
        return this;
    }

    public void cartDataShouldHaveError(){
        $(".card_data samp.error").shouldBe(Condition.visible);
    }

}
