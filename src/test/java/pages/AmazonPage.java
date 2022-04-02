package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPage {

    WebDriver driver;
    //Bu page sayfası oluşturulduğunda mutlaka yapmamız gereken şey
    // vir constructor oluşturup driver e ilk değeri atamaktır.
    public AmazonPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "searchDropdownBox")
    public WebElement dropDown;
@FindBy(id="twotabsearchtextbox")
    public WebElement aramaKtusu;
 @FindBy(xpath="//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement sonucYazısı;
@FindBy(xpath = "(//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal'])[1]")
    public WebElement ilkÜrün;
}
