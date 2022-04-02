package tests.day13_POM;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import unites.TestBase;

public class C01_Pages extends TestBase {
    // Amazon sayfasına gidin.
    //nutella için arama yapın
    //sonuç sayısını yazdırın ve sonuç yazısının nutella içerdiğini test edin
@Test
    public void testPOM(){
    driver.get("https://www.amazon.com");
    AmazonPage amazonPage=new AmazonPage(driver);
    amazonPage.aramaKtusu.sendKeys("nutella"+ Keys.ENTER);
    System.out.println(amazonPage.sonucYazısı.getText());
    Assert.assertTrue(amazonPage.sonucYazısı.getText().contains("nutella"),"sonuç yazısı nutella içermiyor");


}

}
