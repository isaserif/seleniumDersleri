package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import unites.ConfigReader;
import unites.TestBase;

public class C03_TestPositiveConfiguration extends TestBase {
@Test
    public void positiveTestConfig(){
    //http://qa-environment.koalaresorthotels.com adresine git
    driver.get(ConfigReader.getProperty("CHUrl"));
    //login butonuna bas
    ConcortHotelPage concortHotelPage=new ConcortHotelPage(driver);
    concortHotelPage.loginButton1.click();
    //test data username: manager ,
    concortHotelPage.userNameButton.sendKeys(ConfigReader.getProperty("CHValidUsername"));
    //test data password : Manager1!
    concortHotelPage.passwordButton.sendKeys(ConfigReader.getProperty("CHValidPassword"));
    concortHotelPage.getLoginButton2.click();
    //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
    Assert.assertTrue(concortHotelPage.başarılıGirişTesti.isDisplayed());
    System.out.println("başarılı giriş yazısı: "+concortHotelPage.başarılıGirişTesti.getText());
}}
