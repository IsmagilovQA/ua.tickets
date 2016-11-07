package ua.tickets.components;

import com.codeborne.selenide.Condition;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Calendar;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static java.lang.String.format;

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
    public DatePicker setDateAfterCurrent(int value){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, value);
        $$(format("[data-month='%s']", calendar.get(Calendar.MONTH))).
                findBy(Condition.exactText(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)))).click();
        return this;
    }

}
