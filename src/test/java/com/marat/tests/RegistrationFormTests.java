package com.marat.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTests extends TestBase{

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "2560x1440";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Crocodile");
        $("#lastName").setValue("Dandy");
        $("#userEmail").setValue("Dandy@mail.gru");
        $(byText("Male")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $((".react-datepicker__month-select")).selectOption("February");
        $((".react-datepicker__year-select")).selectOption("1987");
        $((".react-datepicker__day--010")).click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("img/photo_2022-11-10_13-45-13.jpg");
        $("#currentAddress").setValue("Pushkin Street 22");
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Karnal").pressEnter();
        $("#submit").pressEnter();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(byTagName("tbody")).shouldHave(text("Crocodile Dandy"),
                text("Dandy@mail.gru"),
                text("Male"),
                text("1234567890"),
                text("10 February,1987"),
                text("Math"),
                text("Music"),
                text("photo_2022-11-10_13-45-13.jpg"),
                text("Pushkin Street 22"),
                text("Haryana Karnal"));
        $(byText("Close")).pressEnter();
    }
}
