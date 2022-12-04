package com.marat.pages.components;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CheckBoxComponent {

    private final SelenideElement formCheckBox = $(byText("Music"));

    public void selectCheckBox() {
        formCheckBox.click();
    }
}
