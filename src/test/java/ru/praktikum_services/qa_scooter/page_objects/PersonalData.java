package ru.praktikum_services.qa_scooter.page_objects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalData {
    private final WebDriver driver;
    //Заголовок "Для кого самокат"
    private final By mainLbl = By.xpath(".//div[text()='Для кого самокат']");

    //Поле "Имя"
    private final By nameFld = By.xpath(".//input[@placeholder = '* Имя']");
    //Поле "Фамилия"
    private final By surnameFld = By.xpath(".//input[@placeholder = '* Фамилия']");
    //Поле "Адрес"
    private final By addressFld = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    //Поле "Станция метро"
    private final By undergroundFld = By.className("select-search__input");
    private final By phoneFld = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    //Кнопка "Далее"
    private final By nextBtn = By.xpath(".//button[text()='Далее']");

    public PersonalData(WebDriver driver) {
        this.driver = driver;
    }

    public PersonalData waitUntilNameFldLoaded() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(nameFld));
        return this;
    }

    public PersonalData isDisplayedMainLbl() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(mainLbl));
        Assert.assertTrue("Проверка загрузки заголовка Для кого самокат", driver.findElement(mainLbl).isDisplayed());
        return this;
    }

    public PersonalData setNameFld(String name) {
        driver.findElement(nameFld).clear();
        driver.findElement(nameFld).sendKeys(name);
        return this;
    }

    public PersonalData setSurnameFld(String surname) {
        driver.findElement(surnameFld).clear();
        driver.findElement(surnameFld).sendKeys(surname);
        return this;
    }

    public PersonalData setAddressFld(String address) {
        driver.findElement(addressFld).clear();
        driver.findElement(addressFld).sendKeys(address);
        return this;
    }

    public PersonalData setUndergroundFld(String underground) {
        driver.findElement(undergroundFld).click();
        //Выбор станции метро из списка
        String undergroundElemFromLst = ".//li[@class = 'select-search__row']//div[text() = '%s']";
        driver.findElement(By.xpath(String.format(undergroundElemFromLst, underground))).click();
        return this;

    }

    public PersonalData setPhoneFld(String phone) {
        driver.findElement(phoneFld).clear();
        driver.findElement(phoneFld).sendKeys(phone);
        return this;
    }

    public PersonalData clickNextBtn() {
        driver.findElement(nextBtn).click();
        return this;
    }


}
