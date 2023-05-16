package ru.praktikum_services.qa_scooter.page_objects;

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

    public Main(WebDriver driver){
        this.driver = driver;
    }


    public void waitForLoadQuestions() {
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(questions).getText() != null
                && !driver.findElement(questions).getText().isEmpty()
        ));
    }

    public void clickAccordionTitleByText(String text){
        WebElement element = driver.findElement(accordionTitle);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(By.xpath(String.format(".//div[text()='%s']", text))).click();
    }

    public boolean checkAccordionDataIsDispalyed(String text){
        return driver.findElement(By.xpath(String.format(".//div/p[text()='%s']", text))).isDisplayed();
    }

    public void clickOrderBtn(){
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(orderBtn));
        driver.findElement(orderBtn).click();
    }

}
