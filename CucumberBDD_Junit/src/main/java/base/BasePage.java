package base;

import pageObjects.AddAComputerPage;
import pageObjects.HomePage;
import pageObjects.EditComputerPage;
import utils.DriverFactory;
import utils.DriverUtils;

public class BasePage
{
    public static HomePage homePage;

    public static EditComputerPage editComputerPage;

    public static AddAComputerPage addAComputerPage;

    public static DriverUtils driverUtils;

    public static void initPages()
    {
        homePage = new HomePage(DriverFactory.driver);
        editComputerPage = new EditComputerPage(DriverFactory.driver);
        addAComputerPage = new AddAComputerPage(DriverFactory.driver);
        driverUtils = new DriverUtils();


    }


}
