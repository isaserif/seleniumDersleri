package tests.day17_ExcellAutomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class C01_RedExcel {
  @Test
    public void test() throws IOException {
//7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/test/java/resources/ulkeler.xlsx";
//8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fileInputStream=new FileInputStream(dosyaYolu);
//9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook=WorkbookFactory.create(fileInputStream);
//10. WorkbookFactory.create(fileInputStream)
//11. Worksheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet= workbook.getSheet("sayfa1");
//12. Row objesi olusturun sheet.getRow(index)
        Row row= sheet.getRow(2);
//13. Cell objesi olusturun row.getCell(index)
        Cell cell= row.getCell(3);
        System.out.println(cell);}

    @Test
    public void test2()throws IOException{
//7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/test/java/resources/ulkeler.xlsx";
//8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fileInputStream=new FileInputStream(dosyaYolu);
//9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook=WorkbookFactory.create(fileInputStream);
//10. WorkbookFactory.create(fileInputStream)
//11. Worksheet objesi olusturun workbook.getSheetAt(index)

//12. Row objesi olusturun sheet.getRow(index)

//13. Cell objesi olusturun row.getCell(index)
      Cell cell=  workbook.getSheet("sayfa1").getRow(5).getCell(3);
        System.out.println(cell);
      // Secilen hücredeki yazının Luanda olduğunu test edin.

        //Assert.assertEquals(cell,"Luanda");
        //cell' in data türü cell Luanda ise String hata veririr.
      Assert.assertEquals(cell.toString(),"Luanda");
     // Ya da String manipulation yaparız cell data türünü "cast" yapmalıyız. getStringCellValue()
        Assert.assertEquals(cell.getStringCellValue(),"Luanda");
        // index i 3 olan satırdaki index i 2 olan hücredeki yazıyı büyük harfle yazdırın
        Cell cell1=  workbook.getSheet("sayfa1").getRow(3).getCell(2);
        System.out.println(cell1.toString().toUpperCase(Locale.ROOT));

        System.out.println(workbook.getSheet("sayfa1").getLastRowNum()+"  SON SATIR İNDEXİ: ");
        System.out.println(workbook.getSheet("sayfa1").getPhysicalNumberOfRows()+"  FİZİKİ OLARAK KULLANILAN SATIR SAYISI");
   // getLastRowNum()); SON SATIRIN İNDEX İNİ VERİR.
   //getPhysicalNumberOfRows()); İSE FİZİKİ OLARAK KULLANILAN SATIR SAYISINI VERİR.

  }

@Test
    public void test3() throws IOException {
   //tablodaki ikinci sutunu bir list olarak yazdıralım
    List<String>ikinciSutun = new ArrayList<>();

    String dosyaYolu="src/test/java/resources/ulkeler.xlsx";
    FileInputStream fileInputStream=new FileInputStream(dosyaYolu);
    Workbook workbook=WorkbookFactory.create(fileInputStream);

for (int i=0;i<=workbook.getSheet("sayfa1").getLastRowNum();i++){
  ikinciSutun.add(  workbook.getSheet("sayfa1").getRow(i).getCell(1).toString());
}
    System.out.println(ikinciSutun);
// Aile başlayan şehirleri liste yapıp yazdırın.
    List<String>aIleBaslayanSehirler=new ArrayList<>();
    for (String each:ikinciSutun){
        if (each.startsWith("A")){
            aIleBaslayanSehirler.add(each);
        }
    }
    System.out.println(aIleBaslayanSehirler);
    //EĞER TÜM DATAYI JAVADA KULLANILABİLİR BİR COLLECTİON A ÇEVİRMEK İSTERSEK
    // EN UYGUN YAPI MAP OLUR.
    //MAP İÇİN UNIGUE DEĞERLERE SAHİP BİR SUTUNU KEY, GERİYE KALAN TÜM SUTUNLARI İSE
    // VİRGÜLLE AYRILAN STRİNG LER OLARAK VALUE YAPMALIYIZ.
    // KEY=TURKEY=ANKARA,TURKİYR,ANKARA
          {
              Map<String,String>ulkelerMap=new HashMap<>();
              String key="";
              String value="";
    for (int i=0;i<workbook.getSheet("sayfa1").getLastRowNum();i++){
key=workbook.getSheet("sayfa1").getRow(i).getCell(0).toString();
value=workbook.getSheet("sayfa1").getRow(i).getCell(1).toString()+","+
        workbook.getSheet("sayfa1").getRow(i).getCell(2).toString()+","+
        workbook.getSheet("sayfa1").getRow(i).getCell(2).toString();
ulkelerMap.put(key,value);
    }
              System.out.println(ulkelerMap);
    // BİZ JAVA METHODLARINI VE KOLLECTİONS İ KULLANARAK EXCEL DEKİ DATALARI
    //MANUPİLE EDEBİLECEĞİMİZ JAVA ORTAMINA ALABİLİRİZ.
    }
}





}
