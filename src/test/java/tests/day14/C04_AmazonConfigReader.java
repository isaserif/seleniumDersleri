package tests.day14;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import unites.ConfigReader;
import unites.TestBase;

public class C04_AmazonConfigReader extends TestBase {

    @Test
    public void test(){
// Amazon sayfasına gidin
driver.get(ConfigReader.getProperty("AmazonUrl"));
        AmazonPage amazonPage=new AmazonPage(driver);
// Nutella için arama yapın
amazonPage.aramaKtusu.sendKeys(ConfigReader.getProperty("AmazonArananKelime")+Keys.ENTER);
//sonuç sayısını yazdırın ve sonuç yazısının nutella içerdiğini test edin
        System.out.println(amazonPage.sonucYazısı.getText());
        Assert.assertTrue(amazonPage.sonucYazısı.getText().contains(ConfigReader.getProperty("AmazonArananKelime")));
    }
}
