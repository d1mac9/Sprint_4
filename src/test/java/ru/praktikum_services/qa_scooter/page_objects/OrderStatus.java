package ru.praktikum_services.qa_scooter.page_objects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static ru.praktikum_services.qa_scooter.helper.Helpers.waitForLoadElement;

public class OrderStatus {
    private final WebDriver driver;

    private final By bannerOrderNotFound = By.xpath(".//img[@alt = 'Not found']");

    public OrderStatus(WebDriver driver) {
        this.driver = driver;
    }

    public OrderStatus checkBannerNotFound() {
        waitForLoadElement(bannerOrderNotFound, driver);
        Assert.assertTrue("Должен отображаться баннер", driver.findElement(bannerOrderNotFound).isDisplayed());
        return this;
    }
}
