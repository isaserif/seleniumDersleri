package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookPage {

    WebDriver driver;

    public FacebookPage(WebDriver driver){
        this.driver=driver;
       PageFactory.initElements(driver,this);
    }
    @FindBy(xpath="//*[@id='email']")
    public WebElement kullanıcıAdı;
    @FindBy(id="pass")
    public WebElement sifre;
   @FindBy(name = "login")
    public WebElement giris;
   @FindBy(className = "_9ay7")
   public WebElement girisBasarısız;

}


