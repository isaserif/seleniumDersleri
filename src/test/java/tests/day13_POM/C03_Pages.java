package tests.day13_POM;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import unites.TestBase;

public class C03_Pages extends TestBase {
    @Test
    public void test(){
// amazon ana sayfasına gidin
    driver.get("https://amazon.com");
    AmazonPage amazonPage=new AmazonPage(driver);
// dropdown menüden book katagorisini secin
    Select select=new Select(amazonPage.dropDown);
   select.selectByVisibleText("Books");
// java için arama yapın
        amazonPage.aramaKtusu.sendKeys("java"+Keys.ENTER);
//sonuç sayısını yazdırın
        System.out.println(amazonPage.sonucYazısı.getText());
        System.out.println(amazonPage.sonucYazısı);
// buluna ilk ürününün isminde java geçtiğini test edin
        Assert.assertTrue(amazonPage.ilkÜrün.getText().contains("Java"));

}}
