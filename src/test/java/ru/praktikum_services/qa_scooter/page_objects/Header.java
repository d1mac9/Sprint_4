package ru.praktikum_services.qa_scooter.page_objects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static ru.praktikum_services.qa_scooter.model.config.AppConfig.YANDEX_URL;


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
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(orderBtn));
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

    public Header checkNewTabURL() {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Assert.assertEquals("Проверка соответствия URL в новой вкладке", YANDEX_URL, driver.getCurrentUrl());
        return this;
    }
}
