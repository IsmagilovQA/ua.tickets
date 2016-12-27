package ua.tickets.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Calendar;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DatePicker {

    public DatePicker(){
        $("#ui-datepicker-div").shouldBe(Condition.visible);
    }

    /**
     * Method for setting date after current date
     * @param value
     * Digit for calculation the required date
     * @return
     * return itself
     */
    @Step
    public DatePicker setDateAfter(int value){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, value);
        System.out.println(calendar.getTime());
        System.out.println(calendar.get(Calendar.MONTH));
        $$(by("data-month", String.valueOf(calendar.get(Calendar.MONTH)))).
                findBy(Condition.exactText(String.valueOf(calendar.get(Calendar.DATE)))).click();
        return this;
    }

    @Step
    public DatePicker setStartDate(int value){
        this.sendJSToDatePicker("#departure_date", value);
        return this;
    }

    @Step
    public DatePicker setEndDate(int value){
        this.sendJSToDatePicker("#departure_date_1,#departure_date_back", value);
        return this;
    }

    private void sendJSToDatePicker(String selector, int plusDays){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, plusDays);
        String date = String.format("%s.%s.%s", calendar.get(Calendar.DATE), calendar.get(Calendar.MONTH)+1, calendar.get(Calendar.YEAR));
        System.out.println(String.format("$('%s').datepicker('setDate', '%s')", selector, date));
        Selenide.executeJavaScript(String.format("$('%s').datepicker('setDate', '%s')", selector, date));
    }

}
