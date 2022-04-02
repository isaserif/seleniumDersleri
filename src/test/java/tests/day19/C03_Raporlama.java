package tests.day19;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import unites.ConfigReader;
import unites.Driver;
import unites.TestBaseRapor;

public class C03_Raporlama extends TestBaseRapor  {

    @Test
    public void test1(){
     extentTest=extentReports.createTest("Nutella Testi","sonuç sayısı 1000 den az olmalı");
        //Amazon sayfasına gidip nutella için arama yapalım
        Driver.getDriver().get(ConfigReader.getProperty("AmazonUrl"));
        extentTest.info("amazon sayfasına gidildi");
        WebElement aramaKutusu=Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys(ConfigReader.getProperty("AmazonArananKelime")+ Keys.ENTER);
        extentTest.info("nutella için arama yapıldı");
        //sonuç sayısının 1000 den az olduğunu test edelim
        WebElement sonucSayısıElementi=Driver.getDriver().findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div"));

        String sonuçYazısı=sonucSayısıElementi.getText();
        String sonucArrayi[]=sonuçYazısı.split(" ");
        int soncSayısı=Integer.parseInt(sonucArrayi[2]);
        extentTest.info("sonuç yazısı int haline getirildi");
        Assert.assertTrue(soncSayısı<1000);
        extentTest.pass("sonuç sayısının 1000 den az olduğu test edildi");
    }
    @Test
    public void test2(){
        //Amazon sayfasına gidip samsung için arama yapalım
        //sonuç sayısının 1000 den az olduğunu test edelim
        extentTest=extentReports.createTest("Samsung Testi","sonuç sayısı 1000 den az olmalı");
        //Amazon sayfasına gidip nutella için arama yapalım
        Driver.getDriver().get(ConfigReader.getProperty("AmazonUrl"));
        extentTest.info("amazon sayfasına gidildi");
        WebElement aramaKutusu=Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys(ConfigReader.getProperty("AmazonArananKelime2")+ Keys.ENTER);
        extentTest.info("samsung için arama yapıldı");
        //sonuç sayısının 1000 den az olduğunu test edelim
        WebElement sonucSayısıElementi=Driver.getDriver().findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div"));

        String sonuçYazısı=sonucSayısıElementi.getText();
        String sonucArrayi[]=sonuçYazısı.split(" ");

        String sonucAdedi=sonucArrayi[3];
       sonucAdedi= sonucAdedi.replaceAll(",","");
        int sonucSayısı=Integer.parseInt(sonucAdedi);
        extentTest.info("sonuç yazısı int haline getirildi");
        Assert.assertTrue(sonucSayısı<1000);
        extentTest.pass("sonuç sayısının 1000 den az olduğu test edildi");

    }
    @Test
    public void test3(){
        //amazon sayfasına gidip
        extentTest=extentReports.createTest("java Test","ilk üründe Java olamalı");
        Driver.getDriver().get(ConfigReader.getProperty("AmazonUrl"));
        extentTest.info("amazon sayfasına gidildi");
        Select select=new Select(Driver.getDriver().findElement(By.id("searchDropdownBox")));
        select.selectByVisibleText("Electronics");
        extentTest.info("Dropdown da Electronics kategorisi seçildi");
        //electronic kategorisinde java için arama yapalım
        WebElement aramaKutusu=Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
          aramaKutusu.sendKeys("java"+Keys.ENTER);
        extentTest.info("Electronics kategorisinde java için arama yapıldı");

        //çıkan sonuçlarda 2. sinin isminde java olduğunu test edelim.
        String ilkElementYazısı=Driver.getDriver().findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[2]/div/div/div/div/div[1]/span/a/div/img")).getText();
       Assert.assertTrue(ilkElementYazısı.equals("Java"));
        extentTest.pass("Electronics kategorisinde çıkan ilk ürün isminde java " +
                "olduğu test edildi");


    }
}
