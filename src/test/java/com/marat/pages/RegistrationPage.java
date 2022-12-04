package com.marat.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private final SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            numberInput = $("#userNumber"),
            subjectInput = $("#subjectsInput"),
            addressInput = $("#currentAddress"),
            formSubmit = $("#submit"),
            formTitle2 = $("#example-modal-sizes-title-lg"),
            closeForm = $(byText("Close"));

    public RegistrationPage openPage() {
        String FORM_TITLE = "Student Registration Form";
        open("/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
        return this;
    }

    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public void typeEmail(String value) {
        emailInput.setValue(value);
    }

    public void typePhoneNumber(String value) {
        numberInput.setValue(value);
    }

    public void typeSubject(String value) {
        subjectInput.setValue(value).pressEnter();
    }

    public void typeAddress(String value) {
        addressInput.setValue(value);
    }

    public RegistrationPage submit() {
        formSubmit.pressEnter();
        return this;
    }

    public RegistrationPage checkModalTitle() {
        String FORM_TITLE2 = "Thanks for submitting the form";
        formTitle2.shouldHave(text(FORM_TITLE2));
        return this;

    }

    public RegistrationPage checkResultsValue(String key, String value) {
        $x("//td[text()='" + key + "']")
                .parent()
                .shouldHave(text(value));
        return this;
    }

    public void close() {
        closeForm.pressEnter();
    }
}