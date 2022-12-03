package com.marat.tests;

import com.marat.pages.RegistrationPage;
import com.marat.pages.components.CalendarComponent;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.marat.tests.TestData.firstName;
import static com.marat.tests.TestData.lastName;

public class RegistrationFormWithPageObjectTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    CalendarComponent calendarComponent = new CalendarComponent();

    @Test
    void fillFormTest() {
        registrationPage.openPage();
        registrationPage.typeFirstName(firstName).typeLastName(lastName);
        $("#userEmail").setValue("Dandy@mail.gru");
        $(byText("Male")).click();
        $("#userNumber").setValue("1234567890");
        calendarComponent.setDate("10", "February", "1987");
        $("#subjectsInput").setValue("Math");
        $("#subjectsInput").pressEnter();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("img/photo_2022-11-10_13-45-13.jpg");
        $("#currentAddress").setValue("Pushkin Street 22");
        $("#react-select-3-input").setValue("Haryana");
        $("#react-select-3-input").pressEnter();
        $("#react-select-4-input").setValue("Karnal");
        $("#react-select-4-input").pressEnter();
        $("#submit").pressEnter();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        registrationPage.checkResultsValue("Student Name", firstName + " " + lastName);
//        $(byTagName("tbody")).shouldHave(text(firstName + " " + lastName),
//                text("Dandy@mail.gru"),
//                text("Male"),
//                text("1234567890"),
//                text("10 February,1987"),
//                text("Math"),
//                text("Music"),
//                text("photo_2022-11-10_13-45-13.jpg"),
//                text("Pushkin Street 22"),
//                text("Haryana Karnal"));
        $(byText("Close")).pressEnter();
    }
}
//59:21 (string format)