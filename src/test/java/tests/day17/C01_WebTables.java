package tests.day17;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;

public class C01_WebTables {

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

        //1.pages sayfasında  Bir metod oluşturun : printData(int row, int column);
        String actualData=qaConcortPage.printData(3, 5);

        //2. Satır(row) ve sütun(column) numarasını girdiğinizde, printData metodu bu
        //hücredeki(cell) veriyi yazdırmalıdır.

        //3. Ve bu metodu printData() methodunu cagirmak icin kullanin.
        //b. Örnek: printData (3,5); => 3. satır, 5. Sütundaki veriyi yazdırmalıdır
        //4. yazdirilan datanin olmasi gereken dataya esit oldugunu test edin

        //Assert i bu clasta yapmak istiyorsak istenen datanın bu class a dönmesini sağlamalıyız.
        Assert.assertEquals(actualData,"1");

    }
}