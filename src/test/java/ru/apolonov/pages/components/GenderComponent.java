package ru.apolonov.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class GenderComponent {
    private SelenideElement genderSelect = $("#genterWrapper");


    public void setGender(String value) {
        genderSelect.$(byText(value)).click();
    }
}
