package tests.day15;

import org.testng.annotations.Test;
import unites.ConfigReader;
import unites.Driver;

public class C01_DriverClassKullanımı {
    @Test(groups = "birinciGrup")
    public void test(){
        Driver.getDriver().get(ConfigReader.getProperty("Facebookurl"));
        Driver.getDriver().get(ConfigReader.getProperty("AmazonUrl"));
        Driver.getDriver().get(ConfigReader.getProperty("CHUrl"));
        Driver.closeDriver();

     //   Driver driver=new Driver();
        // Driver class ından obje üretilmesini istediğimiz için driver class ını
        // SINGLETON yapıyoruz.
        // bunun için default constructor yerine parametresiz bir constructor
        //oluşturup access modifier i private seçiyoruz.
    }
}
