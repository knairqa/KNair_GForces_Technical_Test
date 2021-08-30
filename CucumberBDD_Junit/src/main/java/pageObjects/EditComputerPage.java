package pageObjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditComputerPage
{
    WebDriver driver;

    @FindBy(xpath = "//h1[text()='Edit computer']")
    public WebElement editComputerText;



    @FindBy(id="name")
    public WebElement computerNameTextbox;

    @FindBy(xpath = "//input[@value='Save this computer']")
    public WebElement saveThisCompBtn;

    @FindBy(className = "warning")
    public WebElement errorMsg;

    @FindBy(xpath = "//input[@value='Delete this computer']")
    public WebElement deleteCompBtn;

    public EditComputerPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


   public String verifyEditComputerText()
   {
      return BasePage.driverUtils.getText(editComputerText);
   }

   public String verifyComputerName(String a)
   {
      return BasePage.driverUtils.getAttributeValue(computerNameTextbox,a);
   }

    public boolean verifySaveThisComputerBtn()
    {
        return saveThisCompBtn.isDisplayed();
    }

    public String verifyComputerNameErrorMsg()
    {
        return BasePage.driverUtils.getText(errorMsg);
    }

    public void clearComputerName()
    {
        computerNameTextbox.clear();
    }

    public void clickSaveThisCompBtn()
    {
        saveThisCompBtn.click();
    }

    public boolean verifyDeleteThisCompBtn()
    {
        return deleteCompBtn.isDisplayed();
    }

    public void clickDeleteThisComputerBtn()
    {
        deleteCompBtn.click();
    }


}
