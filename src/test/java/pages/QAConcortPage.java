package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import unites.ConfigReader;
import unites.Driver;

import java.util.List;
import java.util.WeakHashMap;

public class QAConcortPage {
  public WebDriver driver;

  public QAConcortPage() {
    PageFactory.initElements(Driver.getDriver(), this);
  }

  @FindBy(xpath = "//*[@id=\"navLogon\"]/a")
  public WebElement loginButton1;

  @FindBy(id = "UserName")
  public WebElement userNameButton;

  @FindBy(id = "Password")
  public WebElement passwordButton;
  @FindBy(id = "btnSubmit")
  public WebElement getLoginButton2;

  @FindBy(xpath = "//span[text()='ListOfUsers']")
  public WebElement başarılıGirişTesti;
  @FindBy(xpath = "//span[text()='Try again please']")
  public WebElement başarısızGirişTesti;


  @FindBy(xpath = "(//span[@class='title'])[3]")
  public WebElement hotelManagement;
  @FindBy(xpath = "/html/body/div[3]/div[1]/div/ul/li[3]/ul/li[2]/ul/li[2]")
  public WebElement hotelRooms;
  @FindBy(xpath = "//span[text()='Add Hotel ']")
  public WebElement addHotel;
  @FindBy(xpath = "/html/body/div[3]/div[2]/div/div[3]/div/div/div[1]/div[2]/a")
  public WebElement addHotelRooms;
  @FindBy(xpath = "/html/body/div[3]/div[1]/div/ul/li[3]/ul/li[2]/ul/li[1]/a")
  public WebElement hotelList;
  @FindBy(xpath = "//*[@id=\"Code\"]")
  public WebElement addcode1;

  @FindBy(xpath = "//*[@id=\"IDGroup\"]")
  public WebElement dropdownMenü;

  @FindBy(xpath = "//*[@id=\"IDHotel\"]")
  public WebElement idMenüDropdown;
  @FindBy(id = "IDGroupRoomType")
  public WebElement typRoomDropdown;
  @FindBy(id = "btnSubmit")
  public WebElement saveButtonu;
  @FindBy(xpath = "/html/body/div[5]/div/div/div[1]/div")
  public WebElement kayıtBşarılıTexti;
  @FindBy(xpath = "//a[text()='Hotelrooms']")
  public WebElement hotelroomsLinki;
  @FindBy(xpath = "/html/body/div[3]/div[2]/div/div[3]/div/div/div[1]/div[1]/span")
  public WebElement listHotelRoomsLinki;
  @FindBy(xpath = "/html/body/div[5]/div/div/div[2]/button")
  public WebElement enterButtonuElememti;

  @FindBy(xpath = "//div[@class='bootbox-body']")
  public WebElement addBaşarılıGiriş;

  //---------------------------------------------------------
  //WEP TAPLES LOCATELERİ
  @FindBy(xpath = "//*[@id=\"UserName\"]")
  public WebElement userNameWebTables;
  @FindBy(xpath = "//*[@id=\"Password\"]")
  public WebElement passWordWebTables;
  @FindBy(xpath = "//*[@id=\"add-form\"]/div[3]/button")
  public WebElement loginInWebTablesButton;
  @FindBy(xpath = "//thead/tr[1]/th")
  public List<WebElement>baslıklarListesi;
  @FindBy(xpath = "//tbody")
  public WebElement tümBody;
  @FindBy(xpath = "//tbody//tr")
public List<WebElement>toplamSatırSayısı;
  @FindBy(xpath = "//*[@id=\"datatable_ajax\"]/tbody/tr[1]")
  public WebElement tablodaBirinciSatır;

  @FindBy(xpath = "//tbody//tr//td[4]")
  public List<WebElement> dördüncüSütun;



  public void login() {
    QAConcortPage qaConcortPage = new QAConcortPage();
    Driver.getDriver().get(ConfigReader.getProperty("CHWTUrl"));
    qaConcortPage.userNameWebTables.sendKeys(ConfigReader.getProperty("userNameWebTables"));
    qaConcortPage.passWordWebTables.sendKeys(ConfigReader.getProperty("passWordWebTables"));
    qaConcortPage.loginInWebTablesButton.click();

    }


  public String printData(int satır, int sutun) {
    //örnekteki haliyle 3 satır 4. sutun daki elemanı yazdıralım.
    // String xpath=//tbody//tr[3]//td[5]
    String xpath="//tbody//tr["+sutun+"]//td["+satır+"]";
    //satır no:3, sutun no:5
    //String xpath=//tbody//tr[3]//td[5]

    //değişmeyecek kısımları string değişecek kısımları parametre ismi
    //olarak yazdık.
    //System.out.println("satır no:"+satır+"sutun no:"+sutun);
String istenenData= Driver.getDriver().findElement(By.xpath(xpath)).getText();
    System.out.println("satır no"+satır+",sutun no:"+sutun+ "'deki data:"+istenenData);

    return istenenData;

  }
}


