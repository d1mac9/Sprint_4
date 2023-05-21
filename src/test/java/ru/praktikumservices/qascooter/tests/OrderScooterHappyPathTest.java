package ru.praktikumservices.qascooter.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.praktikumservices.qascooter.pageobject.*;

import static ru.praktikumservices.qascooter.model.config.AppConfig.MAIN_URL;
import static ru.praktikumservices.qascooter.model.constant.RentalPeriods.DAY;
import static ru.praktikumservices.qascooter.model.constant.RentalPeriods.DAY_2;

@RunWith(Parameterized.class)
public class OrderScooterHappyPathTest extends BaseTest {
    private final boolean isOrderHeaderLocationBtn;
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

    public OrderScooterHappyPathTest(
            boolean isOrderHeaderLocationBtn, String name, String surname, String address, String underground, String phone, String date,
            String rentalPeriod, boolean isBlack, boolean isGrey, String comment) {
        this.isOrderHeaderLocationBtn = isOrderHeaderLocationBtn;
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
                {true,"Имя", "Фамилия", "Адрес д 2, к 3", "Черкизовская", "+79998887766", "15.05.2023", DAY,
                        true, true, "Заказать еду хотел, а тут..."},
                {false,"НовоеИмя", "ДругаяФамилия", "Адрес записан по другому д 6", "Черкизовская", "+78889994455",
                        "18.05.2023", DAY_2, false, false, "Это яндекс еда?"},
        };
    }

    @Test
    public void orderScooterHappyPathTest() {
        driver.get(MAIN_URL);

        if(isOrderHeaderLocationBtn) {
            new Header(driver)
                    .waitForLoadHeaderBtn()
                    .clickOrderBtn();
        } else {
            new Main(driver)
                    .clickOrderBtn();
        }

        new PersonalData(driver)
                .waitUntilNameFldLoaded()
                .setNameFld(name)
                .setSurnameFld(surname)
                .setAddressFld(address)
                .setUndergroundFld(underground)
                .setPhoneFld(phone)
                .clickNextBtn();

        new LoanDetails(driver)
                .setDateFld(date)
                .setRentalPeriodDrpDwn(rentalPeriod)
                .setScooterColourChkBx(isBlack, isGrey)
                .setCommentFld(comment)
                .clickOrderBtn();

        new OrderModal(driver)
                .clickConfirmBtn()
                .checkIsDisplayedConfirmLbl();
    }
}
