package ru.praktikumservices.qascooter.tests;

import org.junit.Test;
import ru.praktikumservices.qascooter.pageobject.Header;
import ru.praktikumservices.qascooter.pageobject.OrderStatus;
import ru.praktikumservices.qascooter.pageobject.PersonalData;

import static ru.praktikumservices.qascooter.model.config.AppConfig.*;

public class OrderScooterFunctionalTest extends BaseTest {

    @Test
    public void yandexButtonLabelClickTest(){
        driver.get(MAIN_URL);
        new Header(driver)
                .clickYandexLblBtn()
                .checkNewTabURL(YANDEX_URL);

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
