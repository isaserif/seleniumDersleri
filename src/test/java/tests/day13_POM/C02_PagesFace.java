package tests.day13;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import unites.TestBase;

public class C02_PagesFace extends TestBase {
    //facebook sayfasına gidin.
    //kulanıcı adı:techproed
    //sifre:12345
    //yazdığınızda giriş yapamadığınızı test edin
    @Test
    public void testPOM(){
       driver.get("https://www.facebook.com");
        FacebookPage facebookPage=new FacebookPage(driver);
        facebookPage.kullanıcıAdı.sendKeys("techproed");
        facebookPage.sifre.sendKeys("1234");
        facebookPage.giris.click();
        Assert.assertTrue(facebookPage.girisBasarısız.isDisplayed());





    }
}
