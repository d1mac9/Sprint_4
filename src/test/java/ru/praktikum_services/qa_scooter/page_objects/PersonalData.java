package ru.praktikum_services.qa_scooter.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalData {
    private final WebDriver driver;

    //Поле "Имя"
    private final By nameFld = By.xpath(".//input[@placeholder = '* Имя']");
    //Поле "Фамилия"
    private final By surnameFld = By.xpath(".//input[@placeholder = '* Фамилия']");
    //Поле "Адрес"
    private final By addressFld = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    //Поле "Станция метро"
    private final By undergroundFld = By.className("select-search__input");

    //Выбор станции метро из списка
    private final String undergroundElemFromLst = ".//li[@class = 'select-search__row']//div[text() = '%s']";
    //Поле "Телефон"
    private final By phoneFld = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    //Кнопка "Далее"
    private final By nextBtn = By.xpath(".//button[text()='Далее']");

    public PersonalData(WebDriver driver){
        this.driver = driver;
    }
    public void waitUntilNameFldLoaded(){
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(nameFld));
    }

    public void setNameFld(String name){
        driver.findElement(nameFld).clear();
        driver.findElement(nameFld).sendKeys(name);
    }

    public void setSurnameFld(String surname){
        driver.findElement(surnameFld).clear();
        driver.findElement(surnameFld).sendKeys(surname);
    }
    public void setAddressFld(String address){
        driver.findElement(addressFld).clear();
        driver.findElement(addressFld).sendKeys(address);
    }
    public void setUndergroundFld(String underground){
        driver.findElement(undergroundFld).click();
        driver.findElement(By.xpath(String.format(undergroundElemFromLst , underground))).click();

    }
    public void setPhoneFld(String phone){
        driver.findElement(phoneFld).clear();
        driver.findElement(phoneFld).sendKeys(phone);
    }
    public void clickNextBtn(){
        driver.findElement(nextBtn).click();
    }


}
