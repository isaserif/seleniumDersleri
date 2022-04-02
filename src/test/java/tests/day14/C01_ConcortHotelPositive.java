package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import unites.TestBase;

public class C01_ConcortHotelPositive extends TestBase{
    @Test
    public void positiveLoginTest(){
//http://www.concorthotel.com/ adresine git
        driver.get("http://www.concorthotel.com/");
        ConcortHotelPage concortHotelPage=new ConcortHotelPage(driver);
//login butonuna bas
        concortHotelPage.loginButton1.click();
//test data username: manager ,
        concortHotelPage.userNameButton.sendKeys("manager");
//test data password : Manager1!
        concortHotelPage.passwordButton.sendKeys("Manager1!");
        concortHotelPage.getLoginButton2.click();
//Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(concortHotelPage.başarılıGirişTesti.isDisplayed());
        System.out.println(concortHotelPage.başarılıGirişTesti.getText());

    }}
