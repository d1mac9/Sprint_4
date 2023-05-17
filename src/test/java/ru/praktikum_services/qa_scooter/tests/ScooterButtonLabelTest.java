package ru.praktikum_services.qa_scooter.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.praktikum_services.qa_scooter.page_objects.Header;

import static ru.praktikum_services.qa_scooter.model.config.AppConfig.*;

@RunWith(Parameterized.class)
public class ScooterButtonLabelTest extends BaseTest {
    private final String startUrl;

    public ScooterButtonLabelTest(String startUrl) {
        this.startUrl = startUrl;
    }

    @Parameterized.Parameters
    public static Object[][] testData(){
        return new Object[][] {
                {MAIN_URL},
                {ORDER_URL},
                {STATUS_URL}
        };
    }
    @Test
    public void scooterButtonLabelClickReturnToMainPageTest(){
        driver.get(startUrl);
        new Header(driver)
                .clickScooterLblBtn()
                .checkMainURL(MAIN_URL);
    }
}
