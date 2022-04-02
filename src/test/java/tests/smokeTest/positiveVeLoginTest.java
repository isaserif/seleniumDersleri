package tests.smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import unites.ConfigReader;
import unites.Driver;

public class positiveVeLoginTest {

//2) Bir Class olustur : PositiveTestVeLoginTest
//3) Bir test method olustur positiveLoginTest()
   @Test
    public void positiveLoginTest(){

//http://qa-environment.concorthotel.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("CHUrl"));
        QAConcortPage qaConcortPage=new QAConcortPage();
//login butonuna bas
        qaConcortPage.loginButton1.click();
//test data username: manager ,
        qaConcortPage.userNameButton.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
//test data password : Manager1!
        qaConcortPage.passwordButton.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        qaConcortPage.getLoginButton2.click();
//Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
       Assert.assertTrue(qaConcortPage.başarılıGirişTesti.isDisplayed(),"test başarısız");
       System.out.println(qaConcortPage.başarılıGirişTesti.getText());

}}
