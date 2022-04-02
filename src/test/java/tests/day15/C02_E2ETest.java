package test.day15;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import pages.QAConcortPage;
import unites.ConfigReader;
import unites.Driver;
import unites.TestBase;

public class C02_E2ETest extends TestBase {
//2. Bir metod olusturun: createHotel

@Test
    public void createHotel() {
        QAConcortPage qaConcortPage=new QAConcortPage();
//3. http://www.concorthotel.com/ adresine git.
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        qaConcortPage.loginButton1.click();
//4. Username textbox ve password metin kutularını locate edin ve asagidaki verileri
//girin.
//a. Username : manager
        qaConcortPage.userNameButton.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
//b. Password : Manager1!
        qaConcortPage.passwordButton.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
//5. Login butonuna tıklayın.
        qaConcortPage.getLoginButton2.click();
//6. Hotel Management/Hotel List menusunden ADD HOTEL butonuna tiklayin
        qaConcortPage.hotelManagement.click();
        qaConcortPage.hotelList.click();
        qaConcortPage.addHotel.click();
//7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        qaConcortPage.addcode1.click();
    Actions actions =new Actions(Driver.getDriver());

    Faker faker=new Faker();
    actions
            .sendKeys(faker.address().zipCode())
            .sendKeys(Keys.TAB)
            .sendKeys(faker.name().name())
            .sendKeys(Keys.TAB)
            .sendKeys(faker.address().fullAddress())
            .sendKeys(Keys.TAB)
            .sendKeys(faker.phoneNumber().phoneNumber())
            .sendKeys(Keys.TAB)
            .sendKeys(faker.internet().emailAddress())
            .sendKeys(Keys.TAB)
            .sendKeys(Keys.ENTER)
            .sendKeys(Keys.ARROW_DOWN)
            .sendKeys(Keys.ENTER)
            .sendKeys(Keys.TAB)
    //8. Save butonuna tıklayın.
            .sendKeys(Keys.ENTER).perform();
//9. “Hotel was inserted successfully” textinin göründüğünü test edin.
    Assert.assertTrue(qaConcortPage.addBaşarılıGiriş.isEnabled());
    actions.sendKeys(Keys.ENTER).perform();
//10. OK butonuna tıklayın.

Driver.getDriver().quit();



}

}
