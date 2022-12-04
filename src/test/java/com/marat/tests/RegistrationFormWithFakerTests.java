package com.marat.tests;

import com.github.javafaker.Faker;
import com.marat.pages.RegistrationPage;
import com.marat.pages.components.*;
import org.junit.jupiter.api.Test;
import static com.marat.tests.TestData.*;

public class RegistrationFormWithFakerTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    CalendarComponent calendarComponent = new CalendarComponent();
    ImageComponent imageComponent = new ImageComponent();
    DropDownListingComponent dropDownListingComponent = new DropDownListingComponent();
    RadioButtonComponent radioButtonComponent = new RadioButtonComponent();
    CheckBoxComponent checkBoxComponent = new CheckBoxComponent();
    Faker faker = new Faker();

    String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            userAddress = faker.address().fullAddress();


    @Test
    void fillFormTest() {
        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(userEmail);
        radioButtonComponent.selectRadioButton();
        registrationPage.typePhoneNumber(userNumber);
        calendarComponent.setDate("February", "1987");
        registrationPage.typeSubject(userSubject);
        checkBoxComponent.selectCheckBox();
        imageComponent.downloadImage("img/photo_2022-11-10_13-45-13.jpg");
        registrationPage.typeAddress(userAddress);
        dropDownListingComponent.setState(userState).setCity(userCity);
        registrationPage
                .submit()
                .checkModalTitle()
                .checkResultsValue("Student Name", firstName + " " + lastName)
                .checkResultsValue("Student Email", userEmail)
                .checkResultsValue("Gender", userGender)
                .checkResultsValue("Mobile", userNumber)
                .checkResultsValue("Date of Birth", userBirthDate)
                .checkResultsValue("Subjects", userSubject)
                .checkResultsValue("Hobbies", userHobbies)
                .checkResultsValue("Picture", userImage)
                .checkResultsValue("Address", userAddress)
                .checkResultsValue("State and City", userState + " " + userCity)
                .close();
    }
}