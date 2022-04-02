package tests.day19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import unites.Driver;
import unites.ReusableMethods;

public class C01_ReusableMethotsKullanımı {

     @Test
    public void testReasubleMethod(){
         Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
         Driver.getDriver().findElement(By.linkText("Click Here")).click();

         ReusableMethods.switchToWindow("New Window");
         WebElement newwindowYazıElementi=Driver.getDriver().findElement(By.tagName("h3"));
         Assert.assertTrue(newwindowYazıElementi.isDisplayed());
         ReusableMethods.waitFor(5);
         Driver.closeDriver();




     }



}
