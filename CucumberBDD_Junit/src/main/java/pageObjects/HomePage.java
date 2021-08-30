package pageObjects;



import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverFactory;
import utils.DriverUtils;

import java.util.List;


public class HomePage {
    WebDriver driver;


    @FindBy(xpath="//h1[contains(text(),'computers found')]")
    public WebElement computersFoundText;


    @FindBy(id="add")
    public WebElement addAnewComputerBtn;

    @FindBy(linkText = "ACE")
    public WebElement aceComputerName;

    @FindBy(className = "warning")
    public WebElement confMsg;

    @FindBy(id="searchbox")
    public WebElement filterByNameTextBox;

    @FindBy(id="searchsubmit")
    public WebElement filterByNameBtn;

    @FindBy(linkText = "← Previous")
    public WebElement previousLink;

    @FindBy(linkText = "Next →")
    public WebElement nextLink;

    @FindBy(linkText = "Computer name")
    public WebElement computerNameLink;

    @FindBy(linkText = "Introduced")
    public WebElement introducedLink;

    @FindBy(linkText = "Discontinued")
    public WebElement discontinuedLink;

    @FindBy(linkText = "Company")
    public WebElement companyLink;

    @FindBy(xpath = "(//tbody//tr//td//a)[1]")
    public WebElement computerNameFirstRes;

    @FindBy(xpath = "(//tbody//tr//td[2])[1]")
    public WebElement introducedFirstRes;

    @FindBy(xpath = "(//tbody//tr//td[3])[1]")
    public WebElement discontinuedFirstRes;

    @FindBy(xpath = "(//tbody//tr//td[4])[1]")
    public WebElement companyFirstRes;

    @FindBy(css = ".current a")
    public WebElement pageDisplayText;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


   public String verifyComputersFoundText()
   {
      return BasePage.driverUtils.getText(computersFoundText);
   }

   public boolean verifyAddaNewComputerBtn()
   {
      return addAnewComputerBtn.isDisplayed();
   }

    public void clickAddaNewComputerBtn()
    {
        addAnewComputerBtn.click();
    }

    public void clickAceComputerName()
    {
        aceComputerName.click();
    }

    public String verifyConfMessage()
    {
      return BasePage.driverUtils.getText(confMsg);
    }

    public void enterTextIntoFilterByNameTextbox(String cn)
    {
        filterByNameTextBox.sendKeys(cn);
    }

    public void clickFilterByNameButton()
    {
        filterByNameBtn.click();
    }

    public  boolean verifyFilterTextbox()
    {
        return filterByNameTextBox.isDisplayed();

    }

    public  boolean verifyFilterButton()
    {
        return filterByNameBtn.isDisplayed();

    }


   public int getNumberOfComputers()
   {
      return DriverFactory.driver.findElements(By.cssSelector("tbody > tr >  td > a")).size();
   }



   public boolean verifyPreviousLink()
   {
       return previousLink.isDisplayed();
   }

    public void clickNextLink()
    {
        nextLink.click();
    }

    public void clickPreviousLink()
    {
        previousLink.click();
    }

    public boolean verifyNextLink()
    {
        return nextLink.isDisplayed();
    }
    public void clickComputerNameLink()
    {
        computerNameLink.click();
    }

    public void clickIntroducedLink()
    {
        introducedLink.click();
    }

    public void clickDiscontinuedLink()
    {
        discontinuedLink.click();
    }

    public void clickCompanyLink()
    {
        companyLink.click();
    }

    public String verifyComputersSort()
    {
        return BasePage.driverUtils.getText(computerNameFirstRes);
    }

    public String verifyIntroducedSort()
    {
        return BasePage.driverUtils.getText(introducedFirstRes);
    }

    public String verifyDiscontinuedSort()
    {
        return BasePage.driverUtils.getText(discontinuedFirstRes);
    }

    public String verifyCompanySort()
    {
        return BasePage.driverUtils.getText(companyFirstRes);
    }


    public String getPageDisplayText()
    {
        return BasePage.driverUtils.getText(pageDisplayText);
    }
}
