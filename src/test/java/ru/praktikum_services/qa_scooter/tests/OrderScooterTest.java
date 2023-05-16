package ru.praktikum_services.qa_scooter.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import ru.praktikum_services.qa_scooter.page_objects.Header;
import ru.praktikum_services.qa_scooter.page_objects.LoanDetails;
import ru.praktikum_services.qa_scooter.page_objects.OrderModal;
import ru.praktikum_services.qa_scooter.page_objects.PersonalData;

import static ru.praktikum_services.qa_scooter.model.constans.RentalPeriods.DAY;
import static ru.praktikum_services.qa_scooter.model.constans.RentalPeriods.DAY_2;

@RunWith(Parameterized.class)
public class OrderScooterTest {
    private WebDriver driver;
    private final String name;
    private final String surname;
    private final String address;
    private final String underground;
    private final String phone;
    private final String date;
    private final String rentalPeriod;
    private final boolean isBlack;
    private final boolean isGrey;
    private final String comment;

    public OrderScooterTest(
            String name, String surname, String address, String underground, String phone, String date,
            String rentalPeriod, boolean isBlack, boolean isGrey, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.underground = underground;
        this.phone = phone;
        this.date = date;
        this.rentalPeriod = rentalPeriod;
        this.isBlack = isBlack;
        this.isGrey = isGrey;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][]{
                {"Имя", "Фамилия", "Адрес д 2, к 3", "Черкизовская", "+79998887766", "15.05.2023", DAY,
                        true, true, "Заказать еду хотел, а тут..."},
                {"НовоеИмя", "ДругаяФамилия", "Адрес записан по другому д 6", "Черкизовская", "+78889994455",
                        "18.05.2023", DAY_2, false, false, "Это яндекс еда?"},
        };
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void orderScooterHappyPathTest() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        Header objHeader = new Header(driver);
        objHeader.waitForLoadHeaderBtn();
        objHeader.clickOrderBtn();

        PersonalData objPd = new PersonalData(driver);
        objPd.waitUntilNameFldLoaded();
        objPd.setNameFld(name);
        objPd.setSurnameFld(surname);
        objPd.setAddressFld(address);
        objPd.setUndergroundFld(underground);
        objPd.setPhoneFld(phone);
        objPd.clickNextBtn();

        LoanDetails objLoan = new LoanDetails(driver);
        objLoan.setDateFld(date);
        objLoan.setRentalPeriodDrpDwn(rentalPeriod);
        objLoan.setScooterColourChkBx(isBlack, isGrey);
        objLoan.setCommentFld(comment);
        objLoan.clickOrderBtn();

        OrderModal objOm = new OrderModal(driver);
        objOm.clickConfirmBtn();

        Assert.assertTrue(objOm.isDisplayedConfirmLbl());
    }
}
