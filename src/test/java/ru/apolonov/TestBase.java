package ru.apolonov;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import ru.apolonov.pages.RegistrationsPage;

public class TestBase {

    RegistrationsPage registrationsPage = new RegistrationsPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

}
