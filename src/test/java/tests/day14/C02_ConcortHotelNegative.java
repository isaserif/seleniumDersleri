package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import unites.TestBase;

public class C02_ConcortHotelNegative extends TestBase {

@Test
    public void testNegative(){

    //http://qa-environment.koalaresorthotels.com adresine git
    driver.get("http://www.concorthotel.com/");
    ConcortHotelPage concortHotelPage=new ConcortHotelPage(driver);

    //login butonuna bas
    concortHotelPage.loginButton1.click();

    //test data username: manager1 ,
    concortHotelPage.userNameButton.sendKeys("manager1");

    //test data password : manager1!
    concortHotelPage.passwordButton.sendKeys("Manager1!");
    concortHotelPage.getLoginButton2.click();

    //Degerleri girildiginde sayfaya girilemedigini test et
    Assert.assertTrue(concortHotelPage.başarısızGirişTesti.isDisplayed());
    System.out.println(concortHotelPage.başarısızGirişTesti.getText());
}









}
