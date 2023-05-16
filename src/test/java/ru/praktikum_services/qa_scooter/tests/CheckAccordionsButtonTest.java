package ru.praktikum_services.qa_scooter.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum_services.qa_scooter.page_objects.Main;
@RunWith(Parameterized.class)
public class CheckAccordionsButtonTest {
    private WebDriver driver;
    private final String accordionLabel;
    private final String accordionData;

    private final boolean accordionDataIsDispalyed;

    public CheckAccordionsButtonTest(String accordionLabel, String accordionData, boolean accordionDataIsDispalyed){
        this.accordionLabel = accordionLabel;
        this.accordionData = accordionData;
        this.accordionDataIsDispalyed = accordionDataIsDispalyed;
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Parameterized.Parameters
    public static Object[][] testData(){
        return new Object[][] {
                {"Сколько это стоит? И как оплатить?",
                        "Да, обязательно. Всем самокатов! И Москве, и Московской области.", false},
                {"Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат." +
                        " Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
                true},
                {"Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая." +
                        " Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента," +
                        " когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30," +
                        " суточная аренда закончится 9 мая в 20:30.", true}
        };
    }

    @Test
    public void checkAccordionsButton(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        Main mp = new Main(driver);

        mp.waitForLoadQuestions();
        mp.clickAccordionTitleByText(accordionLabel);
        Assert.assertEquals(
                "Отображается корректный текст при раскрытти аккордеона?",accordionDataIsDispalyed,
                mp.checkAccordionDataIsDispalyed(accordionData));
    }
}
