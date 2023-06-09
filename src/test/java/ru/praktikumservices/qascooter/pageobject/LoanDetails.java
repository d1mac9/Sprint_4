package ru.praktikumservices.qascooter.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.praktikumservices.qascooter.helper.Helpers;

public class LoanDetails {
    private final WebDriver driver;
    // Поле "Дата"
    private final By dateFld = By.xpath(".//div[@class = 'react-datepicker__input-container']/input[@type = 'text']");
    // Поле "Срок аренды"
    private final By rentalPeriodDrpDwn = By.xpath(".//span[@class = 'Dropdown-arrow']");

    //Чекбокс "Черная жемчужина"
    private final By scooterBlackChkBx = By.xpath(".//label[@for = 'black']");

    //Чекбокс "Черная жемчужина"
    private final By scooterGreyChkBx = By.xpath(".//label[@for = 'grey']");
    // Поле "Комментарий"
    private final By commentFld = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");
    // Кнопка "Заказать"
    private final By orderBtn = By.xpath(".//div[contains(@class , 'Order_Buttons__')]/button[text()='Заказать']");


    public LoanDetails(WebDriver driver) {
        this.driver = driver;
    }

    public LoanDetails waitForLoadDateFld() {
        Helpers.waitForLoadElement(dateFld, driver);
        return this;
    }

    public LoanDetails setDateFld(String date) {
        waitForLoadDateFld();
        driver.findElement(dateFld).clear();
        driver.findElement(dateFld).sendKeys(date);
        return this;
    }

    public LoanDetails setRentalPeriodDrpDwn(String rentalPeriod) {
        driver.findElement(rentalPeriodDrpDwn).click();
        driver.findElement(
                By.xpath(String.format(".//div[@class = 'Dropdown-menu']/div[text() = '%s']", rentalPeriod))).click();
        return this;
    }

    public LoanDetails setScooterColourChkBx(boolean isBlack, boolean isGrey) {
        if (isBlack) {
            driver.findElement(scooterBlackChkBx).click();
        }
        if (isGrey) {
            driver.findElement(scooterGreyChkBx).click();
        }
        return this;
    }

    public LoanDetails setCommentFld(String comment) {
        driver.findElement(commentFld).clear();
        driver.findElement(commentFld).sendKeys(comment);
        return this;
    }

    public LoanDetails clickOrderBtn() {
        driver.findElement(orderBtn).click();
        return this;
    }
}
