package pageObjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddAComputerPage {
    WebDriver driver;

    @FindBy(xpath = "//h1[text()='Add a computer']")
    public WebElement addAcomputerHeading;



    @FindBy(xpath = "//label[text()='Computer name']")
    public WebElement computerNameLabel;


    @FindBy(xpath = "//label[text()='Introduced']")
    public WebElement introducedLabel;

    @FindBy(xpath = "//label[text()='Discontinued']")
    public WebElement discontinuedLabel;


    @FindBy(xpath = "//label[text()='Company']")
    public WebElement companyLabel;

    @FindBy(xpath = "//input[@value='Create this computer']")
    public WebElement createThisCompBtn;



    @FindBy(xpath = "//a[text()='Cancel']")
    public WebElement cancelBtn;


    @FindBy(id="name")
    public WebElement computerNameTextbox;

    @FindBy(id="introduced")
    public WebElement introducedTextbox;

    @FindBy(id="discontinued")
    public WebElement discontinuedTextbox;

    @FindBy(id="company")
    public WebElement companyDropdown;



    public AddAComputerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public String verifyAddAComputerHeading()
    {
        return BasePage.driverUtils.getText(addAcomputerHeading);
    }

    public String verifyComputerNameLabel()
    {
        return BasePage.driverUtils.getText(computerNameLabel);
    }

    public String verifyIntroducedLabel()
    {
       return BasePage.driverUtils.getText(introducedLabel);
    }


    public String verifyDiscontinuedLabel()
    {
      return BasePage.driverUtils.getText(discontinuedLabel);
    }

    public String verifyCompanyLabel()
    {
       return BasePage.driverUtils.getText(companyLabel);
    }



    public boolean verifyCreateThisComputerBtn()
    {
       return createThisCompBtn.isDisplayed();
    }

    public boolean verifyCancelBtn()
    {
        return cancelBtn.isDisplayed();
    }


    public void enterComputerName(String name)
    {
        computerNameTextbox.sendKeys(name);
    }

    public void enterIntroduced(String i)
    {
        introducedTextbox.sendKeys(i);
    }

    public void enterDiscontinued(String d)
    {
       discontinuedTextbox.sendKeys(d);
    }

    public void selectCompany(String v)
    {
        BasePage.driverUtils.selectByValue(companyDropdown,v);
    }
    public void clickCreateThisCompBtn()
    {
        createThisCompBtn.click();
    }

    public void clickCancelBtn()
    {
        cancelBtn.click();
    }
    public void selectCompanyByText(String t)
    {
        BasePage.driverUtils.selectByVisibleText(companyDropdown,t);
    }
}
