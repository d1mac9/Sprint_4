package ru.praktikum_services.qa_scooter.page_objects;

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
    // Кнопка "Посмотреть статус"
    private final By checkStatusBtn = By.xpath(".//div[contains(@class , 'Order_NextButton__')]" +
            "/button[text()='Посмотреть статус']");
    //Заголовок "Номер заказа"
    private final By orderNumberLbl = By.xpath(".//div[contains(@class , 'Order_Text__')]"); //109722
    public OrderModal(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDisplayedConfirmLbl(){
        return driver.findElement(confirmLbl).isDisplayed();
    }
    public void clickConfirmBtn(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(confirmBtn));
        driver.findElement(confirmBtn).click();
    }


}
