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
    public DatePicker setDateAfter(int value){
        Date date = new Date().setDate(value);
        $$(format("[data-month='%s']", date.getMonth())).
                findBy(Condition.exactText(String.valueOf(date.getDay()))).click();
        return this;
    }

    public static void main(String[] args) {
        Date date = new Date().setDate(55);
        System.out.println(format("%s.%s", date.getDay(), date.getMonth()));
    }

    private static class Date {
        private int day = 0, month = 0;

        Date setDate(int value){
            int lastDayOfCurrentMonth = Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH);
            int futureDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + value;
            int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
            int futureMonth = currentMonth + 1;
            while (futureDay > lastDayOfCurrentMonth){
                if(12 >= futureMonth){
                    futureDay-=lastDayOfCurrentMonth;
                    futureMonth = month;
                } else {
                    futureDay-=lastDayOfCurrentMonth;
                }
            }
            this.day = futureDay;
            this.month = futureMonth;
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
