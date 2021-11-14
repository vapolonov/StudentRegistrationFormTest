package ru.apolonov.pages.components;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    private SelenideElement dateInput = $("#dateOfBirthInput"),
            monthSelect = $(".react-datepicker__month-select"),
            yearSelect = $(".react-datepicker__year-select");

    public void setDay(String day) {
        SelenideElement daySelect =
                $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)");
        daySelect.click();
    }

    public void setDate(String day, String month, String year) {
        dateInput.click();
        monthSelect.selectOption(month);
        yearSelect.selectOption(year);
        setDay("09");
    }
}