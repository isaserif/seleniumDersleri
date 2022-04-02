package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConcortHotelPage {
    WebDriver driver;
    public ConcortHotelPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }
@FindBy(id = "navLogon")
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



}
