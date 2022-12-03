package com.marat.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName");
    private final String FORM_TITLE = "Student Registration Form";


    public void openPage() {
        open("/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
    }

    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public void typeLastName(String value) {
        lastNameInput.setValue(value);
    }

    public void checkResultsValue(String key, String value) {
        $x("//td[text()='" + key + "']").parent()
                .shouldHave(text(value));
    }
}