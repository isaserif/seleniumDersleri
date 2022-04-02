package tests.smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import unites.ConfigReader;
import unites.Driver;
import unites.TestBase;

public class C02_NegativeVeLoginTest extends TestBase {
    //1) smokeTest paketi altinda yeni bir Class olustur: NegativeTest
    //2) http://www.concorthotel.com/ adresine git

    //3 Farkli test Methodunda 3 senaryoyu test et

    //- yanlisSifre
    QAConcortPage qaConcortPage;
    @Test(priority = -2,groups = "birinciGrup")
    public void yanlisSifre(){
Driver.getDriver().get(ConfigReader.getProperty("CHUrl"));
qaConcortPage=new QAConcortPage();
qaConcortPage.loginButton1.click();
qaConcortPage.userNameButton.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
qaConcortPage.passwordButton.sendKeys(ConfigReader.getProperty("CHQAInValidPassword"));
qaConcortPage.getLoginButton2.click();
        Assert.assertTrue(qaConcortPage.başarısızGirişTesti.isDisplayed());


    }
    //- yanlisKulllanici
    @Test(dependsOnMethods = "yanlisSifre",groups = "birinciGrup")
    public void yanlisKulllanici(){
        qaConcortPage=new QAConcortPage();
        qaConcortPage.loginButton1.click();
        qaConcortPage.userNameButton.clear();
        qaConcortPage.userNameButton.sendKeys(ConfigReader.getProperty("CHQAInValidUsername"));
        qaConcortPage.passwordButton.clear();
        qaConcortPage.passwordButton.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        qaConcortPage.getLoginButton2.click();
        Assert.assertTrue(qaConcortPage.başarısızGirişTesti.isDisplayed());
    }
    //- yanlisSifreKullanici
    @Test(dependsOnMethods = "yanlisSifre")
    public void yanlisSifreVeKullanici(){
        qaConcortPage=new QAConcortPage();
        qaConcortPage.loginButton1.click();
        qaConcortPage.userNameButton.click();
        qaConcortPage.userNameButton.sendKeys(ConfigReader.getProperty("CHQAInValidUsername"));
        qaConcortPage.passwordButton.clear();
        qaConcortPage.passwordButton.sendKeys(ConfigReader.getProperty("CHQAInValidPassword"));
        qaConcortPage.getLoginButton2.click();
        Assert.assertTrue(qaConcortPage.başarısızGirişTesti.isDisplayed());
       Driver.closeDriver();
    }
    //test data yanlis username: manager1 , yanlis password : manager1!
    //3) Login butonuna bas
    //4) Verilen senaryolar ile giris yapilamadigini test et
}
