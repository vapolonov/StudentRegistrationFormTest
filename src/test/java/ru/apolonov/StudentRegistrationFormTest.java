package ru.apolonov;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormTest extends TestBase {

    Faker faker = new Faker(new Locale("ru"));
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String phoneNumber = faker.number().digits(10);
    String country = faker.address().country();
    String city = faker.address().cityName();
    String street = faker.address().streetName();
    String houseNumber = faker.address().buildingNumber();


    @Test
    void fillFormTest() {
        registrationsPage.openPage();
        registrationsPage.typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(email)
                .typePhoneNumber(phoneNumber)
                .typeSubjects("Maths", "English")
                .selectHobbies("Sports", "Music")
                .typeAddress(country + ", " + city + ", " + street + ", " + houseNumber);

        registrationsPage.gender.setGender("Female");

        registrationsPage.calendar.setDate("09", "September", "1974");

        registrationsPage.loadPicture("src/test/resources/img/new.jpg");

        registrationsPage.selectState("Haryana");

        registrationsPage.selectCity("Panipat");

        registrationsPage.sendForm();

        registrationsPage.checkPopupTitle();

        registrationsPage.checkResultsValue("Student Name", firstName + " " + lastName)
                .checkResultsValue("Student Email", email)
                .checkResultsValue("Gender", "Female")
                .checkResultsValue("Mobile", phoneNumber)
                .checkResultsValue("Date of Birth", "09 September,1974")
                .checkResultsValue("Subjects", "Maths, English")
                .checkResultsValue("Hobbies", "Sports, Music")
                .checkResultsValue("Picture", "new.jpg")
                .checkResultsValue("Address", country + ", " + city + ", " + street + ", " + houseNumber)
                .checkResultsValue("State and City", "Haryana Panipat");
    }
}
