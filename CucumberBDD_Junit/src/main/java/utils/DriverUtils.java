package utils;

import io.cucumber.java.eo.Se;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DriverUtils
{
    public void navigateToUrl(String url)
    {
        DriverFactory.driver.navigate().to(url);

    }

    public void pageRefresh()
    {
        DriverFactory.driver.navigate().refresh();
    }

    public String getPageTitle()
    {
        return DriverFactory.driver.getTitle();
    }

    public String getUrl()
    {
        return DriverFactory.driver.getCurrentUrl();
    }

    public String getText(WebElement element)
    {
        return element.getText();
    }


    public void selectByValue(WebElement element,String val)
    {
        Select select = new Select(element);
        select.selectByValue(val);
    }

    public void selectByVisibleText(WebElement element,String text)
    {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }


    public String  getAttributeValue(WebElement element,String att)
    {
        return element.getAttribute(att);
    }
}
