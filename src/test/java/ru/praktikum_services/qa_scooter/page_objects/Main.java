package ru.praktikum_services.qa_scooter.page_objects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Main {

    private final WebDriver driver;

    //Заголовок "Вопросы о важном"
    private final By questions = By.xpath(".//div[text() = 'Вопросы о важном']");

    //Кнопка раскрытия аккордеона
    private final By accordionTitle = By.className("accordion__button");
    // Текст внутри аккордеона
    private final By accordionData = By.className("accordion__panel");

    private final By orderBtn = By.xpath(".//div[contains(@class, 'Home_FinishButton')]" +
            "/button[text() = 'Заказать']");

    public Main(WebDriver driver) {
        this.driver = driver;
    }

    public Main waitForLoadQuestions() {
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(questions).getText() != null
                && !driver.findElement(questions).getText().isEmpty()
        ));
        return this;
    }

    public Main clickAccordionTitleByText(String text) {
        WebElement element = driver.findElement(accordionTitle);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(By.xpath(String.format(".//div[text()='%s']", text))).click();
        return this;
    }

    public Main checkAccordionDataIsDisplayed(String text, boolean actualDisplayed) {
        boolean isDisplayed = driver.findElement(By.xpath(String.format(".//div/p[text()='%s']", text))).isDisplayed();
        Assert.assertEquals(
                "Отображается текст при раскрытии аккордеона?", isDisplayed, actualDisplayed);
        return this;
    }

    public Main clickOrderBtn() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(orderBtn));
        WebElement element = driver.findElement(orderBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        return this;
    }

}
