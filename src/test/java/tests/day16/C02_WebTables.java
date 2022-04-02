package tests.day16;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import unites.ConfigReader;
import unites.TestBase;

import java.sql.Driver;

public class C02_WebTables extends TestBase {

    //● login() metodun oluşturun ve oturum açın.
    //● http://qa-environment.koalaresorthotels.com /admin/HotelRoomAdmin adresine
    //gidin
    //○ Username : manager
    //○ Password : Manager1!
    @Test
            public void test() {

        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.login();
        qaConcortPage.hotelManagement.click();
        qaConcortPage.hotelroomsLinki.click();


        //● table() metodu oluşturun
        //○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        //○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        for (WebElement each : qaConcortPage.baslıklarListesi) {
            System.out.println(each.getText());
            System.out.println(qaConcortPage.baslıklarListesi.size());
            //TÜM Body yazdırmak için
            System.out.println(qaConcortPage.tümBody.getText());
            //● printRows() metodu oluşturun //tr
            //○ table body’sinde bulunan toplam satir(row) sayısını bulun.
            System.out.println("tablodaki satırlar sayısı=  "+qaConcortPage.toplamSatırSayısı.size());
            //○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
            //satırları sırasıyla yazdırmak için
            System.out.println("1.satır="+qaConcortPage.tablodaBirinciSatır.getText());
            for (int i=0;i<qaConcortPage.toplamSatırSayısı.size();i++) {
                System.out.println(i + 1 + "satır:" + qaConcortPage.toplamSatırSayısı.get(i));
            }}
            //○ 4.satirdaki(row) elementleri konsolda yazdırın
            for (WebElement each: qaConcortPage.dördüncüSütun) {
                System.out.println(each.getText());

           }



    }


}


