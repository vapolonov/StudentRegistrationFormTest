package ru.apolonov.pages;

import com.codeborne.selenide.SelenideElement;
import ru.apolonov.pages.components.CalendarComponent;
import ru.apolonov.pages.components.GenderComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationsPage {
    //locators & elements
    private final String FORM_TITLE = "Student Registration Form";
    private final String POPUP_TITLE = "Thanks for submitting the form";
    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            phoneNumberInput = $("#userNumber"),
            subjectInput = $("#subjectsInput"),
            resultsTable = $(".table-responsive"),
            hobbiesSelect = $("#hobbiesWrapper"),
            pictureLoad = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateClick = $("#state"),
            stateSelect = $("#stateCity-wrapper"),
            cityClick = $("#city"),
            citySelect = $("#stateCity-wrapper"),
            button = $("#submit"),
            popupTitle = $("#example-modal-sizes-title-lg");

    public CalendarComponent calendar = new CalendarComponent();
    public GenderComponent gender = new GenderComponent();

    //actions
    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
    }

    public RegistrationsPage typeFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationsPage typeLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationsPage typeEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationsPage typePhoneNumber(String value) {
        phoneNumberInput.setValue(value);
        return this;
    }

    public RegistrationsPage typeSubjects(String value1, String value2) {
        subjectInput.setValue(value1).pressEnter();
        subjectInput.setValue(value2).pressEnter();
        return this;
    }

    public RegistrationsPage selectHobbies(String value1, String value2) {
        hobbiesSelect.$(byText(value1)).click();
        hobbiesSelect.$(byText(value2)).click();
        return this;
    }

    public void loadPicture(String url) {
        pictureLoad.uploadFile(new File(url));
    }

    public RegistrationsPage typeAddress(String value) {
        addressInput.setValue(value);
        return this;
    }

    public void selectState(String value) {
        stateClick.scrollTo().click();
        stateSelect.$(byText(value)).click();
    }

    public void selectCity(String value) {
        cityClick.click();
        citySelect.$(byText(value)).click();
    }

    public void sendForm() {
        button.click();
    }

    public void checkPopupTitle() {
        popupTitle.shouldHave(text(POPUP_TITLE));
    }


    public RegistrationsPage checkResultsValue(String key, String value) {
        resultsTable.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }


}
