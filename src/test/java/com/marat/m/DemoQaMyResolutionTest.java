package com.marat.m;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DemoQaMyResolutionTest {
    @Test
    void taskResolution(){
    open("https://demoqa.com/automation-practice-form");
    $("#firstName").setValue("Crocodile");
    $("#lastName").setValue("Dandy");
    $("#userEmail").setValue("Dandy@mail.gru");
    }
}
