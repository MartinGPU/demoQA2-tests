package com.marat.m;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class DemoQaMyResolutionTest {
    @Test
    void taskResolution(){
    //Person
    open("https://demoqa.com/automation-practice-form");
    $("#firstName").setValue("Crocodile");
    $("#lastName").setValue("Dandy");
    $("#userEmail").setValue("Dandy@mail.gru");
    //Gender
    $(byText("Male")).click();
    $("#userNumber").setValue("1234567890");

    //birthDate
        $("#dateOfBirthInput").click();
        //Month
        $(byClassName("react-datepicker__month-select")).click();
        $(byValue("1")).click();
        //Year
        $(byClassName("react-datepicker__year-select")).click();
        $(byValue("1987")).click();
        //Day
        $(byClassName("react-datepicker__day--010")).click();
    //subject
        $("#subjectsInput").setValue("Math");
        $("#subjectsInput").pressEnter();
    //hobbies
        $(byText("Music")).click();
    //upload file
        $("#uploadPicture").uploadFromClasspath("img/photo_2022-11-10_13-45-13.jpg");
    //form filling
        $("#currentAddress").setValue("Pushkin Street 22");
        $("#react-select-3-input").setValue("Haryana");
        $("#react-select-3-input").pressEnter();
        $("#react-select-4-input").setValue("Karnal");
        $("#react-select-4-input").pressEnter();
        $("#submit").pressEnter();
    //modal-body checking
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(byTagName("tbody")).shouldHave(text("Crocodile Dandy"));
        $(byTagName("tbody")).shouldHave(text("Dandy@mail.gru"));
        $(byTagName("tbody")).shouldHave(text("Male"));
        $(byTagName("tbody")).shouldHave(text("1234567890"));
        $(byTagName("tbody")).shouldHave(text("10 February,1987"));
        $(byTagName("tbody")).shouldHave(text("Math"));
        $(byTagName("tbody")).shouldHave(text("Music"));
        $(byTagName("tbody")).shouldHave(text("photo_2022-11-10_13-45-13.jpg"));
        $(byTagName("tbody")).shouldHave(text("Pushkin Street 22"));
        $(byTagName("tbody")).shouldHave(text("Haryana Karnal"));
        // close modal-body
        $(byText("Close")).pressEnter();
    }
}
