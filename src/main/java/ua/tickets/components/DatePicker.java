package ua.tickets.components;

import com.codeborne.selenide.Condition;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Calendar;

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
        Date date = new Date().setDate(value);
        $$(String.format("[data-month='%s']", date.getMonth())).
                findBy(Condition.exactText(String.valueOf(date.getDay()))).click();
        return this;
    }

    private class Date {
        private int day = 0, month = 0;

        Date setDate(int value){
            int maxDayOfMonth = Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH);
            int difDay;
            int newDay = Calendar.DAY_OF_MONTH + value;
            if (newDay > maxDayOfMonth){
                difDay = newDay - maxDayOfMonth;
                int newMonth = Calendar.getInstance().get(Calendar.MONTH)+1;
                day+=difDay;
                if(newMonth < 12){
                    this.month = newMonth;
                } else {
                    this.day = newDay;
                }
            } else {
                this.day = newDay;
                this.month = Calendar.getInstance().get(Calendar.MONTH);
            }
            return this;
        }

        int getDay() {
            return this.day;
        }
        int getMonth() {
            return this.month;
        }
    }

}
