package ru.praktikumservices.qascooter.pageobject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.praktikumservices.qascooter.helper.Helpers;

import java.util.ArrayList;
import java.util.List;

public class Header {
    private final WebDriver driver;
    //Заголовок "Яндекс"
    private final By yandexLblBtn = By.xpath(".//a[@rel = 'noopener noreferrer']");
    //Заголовок "Самокат"
    private final By scooterLblBtn = By.xpath(".//a[contains(@class , 'Header_LogoScooter')]");
    //Кнопка "Заказать"
    private final By orderBtn = By.xpath(".//button[@class ='Button_Button__ra12g' and text() = 'Заказать']");

    public Header(WebDriver driver) {
        this.driver = driver;
    }

    public Header waitForLoadHeaderBtn() {
        Helpers.waitForLoadElement(orderBtn, driver);
        return this;
    }

    public Header clickYandexLblBtn() {
        driver.findElement(yandexLblBtn).click();
        return this;
    }

    public Header clickScooterLblBtn() {
        driver.findElement(scooterLblBtn).click();
        return this;
    }

    public Header clickOrderBtn() {
        driver.findElement(orderBtn).click();
        return this;
    }

    public Header checkMainURL(String url) {
        Assert.assertEquals("Проверка соответствия URL стартовой странице", url, driver.getCurrentUrl());
        return this;
    }

    public Header checkNewTabURL(String url) {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Assert.assertEquals("Проверка соответствия URL в новой вкладке", url, driver.getCurrentUrl());
        return this;
    }
}
