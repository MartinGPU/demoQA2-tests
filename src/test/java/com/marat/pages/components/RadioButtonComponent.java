package com.marat.pages.components;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RadioButtonComponent {

    private final SelenideElement formRadioButton = $(byText("Male"));
    public void selectRadioButton() {
        formRadioButton.click();
    }
}
