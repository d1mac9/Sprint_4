package ru.praktikum_services.qa_scooter.tests;

import org.junit.Test;
import ru.praktikum_services.qa_scooter.page_objects.Header;
import ru.praktikum_services.qa_scooter.page_objects.Main;
import ru.praktikum_services.qa_scooter.page_objects.OrderStatus;
import ru.praktikum_services.qa_scooter.page_objects.PersonalData;

import static ru.praktikum_services.qa_scooter.model.config.AppConfig.*;

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

    @Test
    public void personalDataValidationHintsTest(){
        String nameFldHint = "Введите корректное имя";
        String surnameFldHint = "Введите корректную фамилию";
        String addressFldHint = "Введите корректный адрес";
        String undergroundFldHint = "Выберите станцию";
        String phoneFldHint = "Введите корректный номер";


        driver.get(ORDER_URL);

        new PersonalData(driver)
                .waitUntilNameFldLoaded()
                .clickNextBtn()
                .checkValidationHintNameFld(nameFldHint)
                .checkValidationHintSurnameFld(surnameFldHint)
                .checkValidationHintAddressFld(addressFldHint)
                .checkValidationHintUndergroundFld(undergroundFldHint)
                .checkValidationHintPhoneFld(phoneFldHint);
    }
    @Test
    public void checkBannerOrderNotFoundTest(){
        String parameter = "?t=71165563435";
        driver.get(STATUS_URL+parameter);

        new OrderStatus(driver)
                .checkBannerNotFound();
    }
}
