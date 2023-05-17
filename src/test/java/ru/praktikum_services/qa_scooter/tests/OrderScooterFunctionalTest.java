package ru.praktikum_services.qa_scooter.tests;

import org.junit.Test;
import ru.praktikum_services.qa_scooter.page_objects.Header;
import ru.praktikum_services.qa_scooter.page_objects.Main;
import ru.praktikum_services.qa_scooter.page_objects.PersonalData;

import static ru.praktikum_services.qa_scooter.model.config.AppConfig.MAIN_URL;

public class OrderScooterFunctionalTest extends BaseTest {

    @Test
    public void orderButtonLowerClickTest() {
        driver.get(MAIN_URL);

        new Main(driver)
                .clickOrderBtn();

        new PersonalData(driver)
                .isDisplayedMainLbl();
    }

    @Test
    public void yandexButtonLabelClickTest(){
        driver.get(MAIN_URL);
        new Header(driver)
                .clickYandexLblBtn()
                .checkNewTabURL();

    }
}
