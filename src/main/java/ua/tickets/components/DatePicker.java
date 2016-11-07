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
        Date date = new Date().setDate(value);
        $$(format("[data-month='%s']", date.getMonth())).
                findBy(Condition.exactText(String.valueOf(date.getDay()))).click();
        return this;
    }

    /**
     * Testing calculation of future date
     * @param args
     */
    public static void main(String[] args) {
        Date date = new Date().setDate(24);
        System.out.println(format("%s.%s", date.getDay(), date.getMonth()));
    }

    private static class Date {
        private int day = 0, month = 0;

        /**
         * Calculation of date
         * @param value
         * Not more 30
         * @return
         * new Date()
         */
        Date setDate(int value){
            int lastDayOfCurrentMonth = Calendar.getInstance().getActualMaximum(Calendar.DATE);
            this.day = Calendar.getInstance().get(Calendar.DATE)+value;
            this.month = Calendar.getInstance().get(Calendar.MONTH);
            while (day > lastDayOfCurrentMonth) {
                day -= lastDayOfCurrentMonth;
                month++;
                if(12 == month) {
                    lastDayOfCurrentMonth = 31;
                    month=0;
                }
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
