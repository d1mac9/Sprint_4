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

    //Валидационная подсказка поля "Имя"
    private final By validationHintNameFld = By.xpath(
            ".//input[@placeholder = '* Имя']/following-sibling::div");
    //Поле "Фамилия"
    private final By surnameFld = By.xpath(".//input[@placeholder = '* Фамилия']");

    //Валидационная подсказка поля "Фамилия"
    private final By validationHintSurnameFld = By.xpath(
            ".//input[@placeholder = '* Фамилия']/following-sibling::div");

    //Поле "Адрес"
    private final By addressFld = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");

    //Валидационная подсказка поля "Адрес"
    private final By validationHintAddressFld = By.xpath(
            ".//input[@placeholder = '* Адрес: куда привезти заказ']/following-sibling::div");


    //Поле "Станция метро"
    private final By undergroundFld = By.className("select-search__input");

    //Валидационная подсказка поля "Станция метро"
    private final By validationHintUndergroundFld = By.xpath(
            ".//div[contains(@class , 'Order_MetroError')]");
    //Поле "Телефон"
    private final By phoneFld = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    //Валидационная подсказка поля "Телефон"
    private final By validationHintPhoneFld = By.xpath(
            ".//input[@placeholder = '* Телефон: на него позвонит курьер']/following-sibling::div");
    //Кнопка "Далее"
    private final By nextBtn = By.xpath(".//button[text()='Далее']");

    public PersonalData(WebDriver driver) {
        this.driver = driver;
    }

    public PersonalData waitUntilNameFldLoaded() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(nameFld));
        return this;
    }

    public PersonalData checkValidationHints(By locator){
        driver.findElement(locator).isDisplayed();
        String text = driver.findElement(locator).getText();
             Assert.assertTrue(
                     String.format("Элемент '%s' не отображается", text),
                     driver.findElement(locator).isDisplayed());
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
    public PersonalData checkValidationHintNameFld(String hint){
        checkValidationHints(validationHintNameFld);
        Assert.assertEquals(
                "Соответствие текста подсказки", hint, driver.findElement(validationHintNameFld).getText());
        return this;
    }

    public PersonalData setSurnameFld(String surname) {
        driver.findElement(surnameFld).clear();
        driver.findElement(surnameFld).sendKeys(surname);
        return this;
    }
    public PersonalData checkValidationHintSurnameFld(String hint){
        checkValidationHints(validationHintSurnameFld);
        Assert.assertEquals(
                "Соответствие текста подсказки", hint, driver.findElement(validationHintSurnameFld).getText());
        return this;
    }

    public PersonalData setAddressFld(String address) {
        driver.findElement(addressFld).clear();
        driver.findElement(addressFld).sendKeys(address);
        return this;
    }
    public PersonalData checkValidationHintAddressFld(String hint){
        checkValidationHints(validationHintAddressFld);
        Assert.assertEquals(
                "Соответствие текста подсказки", hint, driver.findElement(validationHintAddressFld).getText());
        return this;
    }

    public PersonalData setUndergroundFld(String underground) {
        driver.findElement(undergroundFld).click();
        //Выбор станции метро из списка
        String undergroundElemFromLst = ".//li[@class = 'select-search__row']//div[text() = '%s']";
        driver.findElement(By.xpath(String.format(undergroundElemFromLst, underground))).click();
        return this;
    }

    public PersonalData checkValidationHintUndergroundFld(String hint){
        checkValidationHints(validationHintUndergroundFld);
        Assert.assertEquals(
                "Соответствие текста подсказки", hint, driver.findElement(validationHintUndergroundFld).getText());
        return this;
    }

    public PersonalData setPhoneFld(String phone) {
        driver.findElement(phoneFld).clear();
        driver.findElement(phoneFld).sendKeys(phone);
        return this;
    }

    public PersonalData checkValidationHintPhoneFld(String hint){
        checkValidationHints(validationHintPhoneFld);
        Assert.assertEquals(
                "Соответствие текста подсказки", hint, driver.findElement(validationHintPhoneFld).getText());
        return this;
    }

    public PersonalData clickNextBtn() {
        driver.findElement(nextBtn).click();
        return this;
    }


}
