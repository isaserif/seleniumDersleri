package tests.day19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import unites.Driver;
import unites.ReusableMethods;
import unites.TestBaseRapor;

public class C02_WindowHandleRaporu extends TestBaseRapor {
    @Test
    public void tets(){
        extentTest=extentReports.createTest("window Handle Test","yeni Sayfada new windoe yazısı");
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        extentTest.info("istenen adrese gidildi");
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        extentTest.info("linke tıklandı");


        ReusableMethods.switchToWindow("New Window");
        extentTest.info("yeni sayfa açıldı");
        WebElement newwindowYazıElementi=Driver.getDriver().findElement(By.tagName("h3"));
        extentTest.info("test edeceğimiz yazı locate edildi");
        Assert.assertTrue(newwindowYazıElementi.isDisplayed());
        extentTest.pass("yazının görünür olduğu test edildi");

    }
}
