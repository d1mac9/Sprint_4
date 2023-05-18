package ru.praktikum_services.qa_scooter.page_objects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderModal {
    private final WebDriver driver;
    //Лейбл "Заказ оформлен"
    private final By confirmLbl = By.xpath(
            ".//div[contains(@class , 'Order_ModalHeader__') and text() = 'Заказ оформлен']");
    // Кнопка "Да"
    private final By confirmBtn = By.xpath(".//div[contains(@class , 'Order_Buttons__')]/button[text()='Да']");

    public OrderModal(WebDriver driver) {
        this.driver = driver;
    }

    public OrderModal checkIsDisplayedConfirmLbl() {
        Assert.assertTrue(driver.findElement(confirmLbl).isDisplayed());
        return this;
    }

    public OrderModal clickConfirmBtn() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(confirmBtn));
        driver.findElement(confirmBtn).click();
        return this;
    }


}
