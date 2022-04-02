package tests.day14;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import unites.ConfigReader;
import unites.TestBase;

public class C05_ConcortHotelNegativeConfiguration extends TestBase {
    @Test
    public void test(){
     //http://www.concorthotel.com/ adresine gidin
        driver.get(ConfigReader.getProperty("CHUrl"));
        ConcortHotelPage concortHotelPage=new ConcortHotelPage(driver);
        //login butonuna bas
        concortHotelPage.loginButton1.click();
        //test data username: manager1
        concortHotelPage.userNameButton.sendKeys(ConfigReader.getProperty("CHInValidUsername"));
        //test data password : manager1!
        concortHotelPage.passwordButton.sendKeys(ConfigReader.getProperty("CHInValidPassword")+ Keys.ENTER);
        //Degerleri girildiginde sayfaya girilemedigini test et
        Assert.assertTrue(concortHotelPage.başarısızGirişTesti.isDisplayed());











    }
}
