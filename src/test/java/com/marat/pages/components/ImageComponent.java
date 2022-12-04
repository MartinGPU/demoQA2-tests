package com.marat.pages.components;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class ImageComponent {

    private final SelenideElement uploadImg = $("#uploadPicture");

    public void downloadImage(String value) {
        uploadImg.uploadFromClasspath(value);
    }
}
