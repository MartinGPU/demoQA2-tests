package com.marat.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class DropDownListingComponent {

    private final SelenideElement stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input");

    public DropDownListingComponent setState(String value) {
        stateInput.setValue(value).pressEnter();
        return this;
    }

    public void setCity(String value) {
        cityInput.setValue(value).pressEnter();
    }
}
