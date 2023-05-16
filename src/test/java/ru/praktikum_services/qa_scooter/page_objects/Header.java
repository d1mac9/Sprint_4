package ru.praktikum_services.qa_scooter.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Header {
    private final WebDriver driver;
    //Кнопка "Заказать"
    private final By orderBtn = By.xpath(".//button[@class ='Button_Button__ra12g' and text() = 'Заказать']");

    public Header(WebDriver driver){
        this.driver = driver;
    }

    public void waitForLoadHeaderBtn(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(orderBtn));
    }

    public void clickOrderBtn(){
        driver.findElement(orderBtn).click();
    }
}
