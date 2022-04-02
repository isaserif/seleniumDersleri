package tests.day16;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import unites.ConfigReader;
import unites.Driver;
import unites.TestBase;

public class C01_E2ETest extends TestBase {

    //2. Bir metod olusturun: RoomCreateTest()
    @Test
    public void roomCreateTest() throws InterruptedException {
        QAConcortPage qaConcortPage=new QAConcortPage();
        //3. http://www.concorthotel.com/ adresine gidin.
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        qaConcortPage.loginButton1.click();
        //4. Username textbox ve password metin kutularını locate edin ve aşağıdaki verileri girin.
        //a. Username : manager b. Password : Manager1!
        //5. Login butonuna tıklayın.

        qaConcortPage.userNameButton.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
        qaConcortPage.passwordButton.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));

        qaConcortPage.getLoginButton2.click();
        //6. Hotel Management menusunden Add Hotelroom butonuna tıklayın.
        qaConcortPage.hotelManagement.click();
        qaConcortPage.hotelRooms.click();
        qaConcortPage.addHotelRooms.click();
Thread.sleep(1000);
        //7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        Select select=new Select(qaConcortPage.idMenüDropdown);
        select.selectByVisibleText(ConfigReader.getProperty("QHAIdHotelDropdown"));

        Faker faker=new Faker();
        Actions actions=new Actions(Driver.getDriver());
        actions
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().zipCode())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().name())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().city())
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("CHQADescriptionMesaj"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("CHQAPriceDegeri"))
                .perform();
                select=new Select(qaConcortPage.typRoomDropdown);
                select.selectByVisibleText(ConfigReader.getProperty("CHQARoomDegeri"));
                Thread.sleep(1000);
                actions
                        .sendKeys(Keys.TAB)
                        .sendKeys(String.valueOf(faker.number().numberBetween(0,3)))
                        .sendKeys(Keys.PAGE_DOWN)
                        .sendKeys(Keys.TAB)
                        .sendKeys(String.valueOf(faker.number().numberBetween(4,8)))
                        .sendKeys(Keys.TAB)
                        .sendKeys(Keys.SPACE)
                        .sendKeys(Keys.TAB)
                                .perform();
                Thread.sleep(1000);
                qaConcortPage.saveButtonu.click();
        //8. Save butonuna basin.
        //9. “HotelRoom was inserted successfully” textinin göründüğünü test edin.
        Assert.assertTrue(qaConcortPage.kayıtBşarılıTexti.isEnabled());
        //10. OK butonuna tıklayın.
        qaConcortPage.enterButtonuElememti.click();
        actions.
                sendKeys(Keys.PAGE_UP).perform();

        //11. Hotel rooms linkine tıklayın.
        //12. "LIST OF HOTELROOMS" textinin göründüğünü TEST EDIN..
        qaConcortPage.hotelroomsLinki.click();
        Assert.assertTrue(qaConcortPage.listHotelRoomsLinki.isEnabled());
        Driver.closeDriver();

    }
}