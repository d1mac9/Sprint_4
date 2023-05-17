package ru.praktikum_services.qa_scooter.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.praktikum_services.qa_scooter.page_objects.Main;

import static ru.praktikum_services.qa_scooter.model.config.AppConfig.MAIN_URL;

@RunWith(Parameterized.class)
public class CheckAccordionsButtonTest extends BaseTest {
    private final String accordionLabel;
    private final String accordionData;

    private final boolean accordionDataIsDisplayed;

    public CheckAccordionsButtonTest(String accordionLabel, String accordionData, boolean accordionDataIsDispalyed) {
        this.accordionLabel = accordionLabel;
        this.accordionData = accordionData;
        this.accordionDataIsDisplayed = accordionDataIsDispalyed;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][]{
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
    public void checkAccordionsButton() {
        driver.get(MAIN_URL);

        new Main(driver)
                .waitForLoadQuestions()
                .clickAccordionTitleByText(accordionLabel)
                .checkAccordionDataIsDisplayed(accordionData, accordionDataIsDisplayed);
    }
}
