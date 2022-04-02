package tests.day18_writeExcel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.*;

public class C01_WriteExcel {

    @Test
    public void test() throws IOException {
        //) Yeni bir Class olusturalim WriteExcel
        //2) Yeni bir test method olusturalim writeExcelTest()
        //3) Adimlari takip ederek 1.satira kadar gidelim
        String path="src/test/java/resources/ulkeler.xlsx";
        FileInputStream fileInputStream=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        //4) 4.hucreye yeni bir cell olusturalim
        workbook.getSheet("sayfa1").getRow(0).createCell(4).setCellValue("Nufus");
        //5) Olusturdugumuz hucreye “Nufus” yazdiralim
        //6) 2.satir nufus kolonuna 1500000 yazdiralim
        workbook.getSheet("sayfa1").getRow(1).createCell(4).setCellValue(1500000);
        //7) 10.satir nufus kolonuna 250000 yazdiralim
        workbook.getSheet("sayfa1").getRow(9).createCell(4).setCellValue(250000);
        //8) 15.satir nufus kolonuna 54000 yazdiralim
        workbook.getSheet("sayfa1").getRow(14).createCell(4).setCellValue(540000);
        //9) Dosyayi kaydedelim
         FileOutputStream fileOutputStream=new FileOutputStream(path);
         workbook.write(fileOutputStream);
        //10)Dosyayi kapatalim
        fileOutputStream.close();
        fileInputStream.close();
        workbook.close();
    }




}
