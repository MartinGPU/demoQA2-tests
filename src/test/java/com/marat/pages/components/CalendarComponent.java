package com.marat.pages.components;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    private final SelenideElement
            formDateOfBirth = $("#dateOfBirthInput"),
            selectMonth = $((".react-datepicker__month-select")),
            selectYear = $((".react-datepicker__year-select")),
            selectDay = $((".react-datepicker__day--010"));

    public void setDate(String month, String year) {
        formDateOfBirth.click();
        selectMonth.selectOption(month);
        selectYear.selectOption(year);
        selectDay.click();
    }
}
