package steps;

import base.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import utils.DriverFactory;

public class StepDefinitions
{

    @Given("I navigate to the computer database app url {string}")
    public void i_navigate_to_the_computer_database_app_url(String url)
    {
        BasePage.driverUtils.navigateToUrl(url);
        System.out.println("Home Page Title is: " + BasePage.driverUtils.getPageTitle());

    }

    @Then("I should see a page with heading {string}")
    public void i_should_see_a_page_with_heading(String expectedCountMsg)
    {

        String computersCount = BasePage.homePage.verifyComputersFoundText();
        System.out.println("Computers Count Text is: "+ computersCount);
        Assertions.assertEquals(computersCount,expectedCountMsg);
    }

    @And("I should see Add a new computer button on the page")
    public void iShouldSeeAddANewComputerButtonOnThePage()
    {
        Assertions.assertTrue(BasePage.homePage.verifyAddaNewComputerBtn(),
                "Add a New Computer Button is displayed");
    }


    @When("I click on Add a new computer button")
    public void iClickOnAddANewComputerButton()
    {
       BasePage.homePage.clickAddaNewComputerBtn();
    }

    @Then("I should be redirected to a new page from where I can add a new computer")
    public void iShouldBeRedirectedToANewPageFromWhereICanAddANewComputer()
    {
       String pageTitle = BasePage.driverUtils.getPageTitle();
        System.out.println("Page Title is: " + pageTitle);
    }

    @Then("The new page should have a heading {string}")
    public void the_new_page_should_have_a_heading(String addComputerexpectedHeading)
    {
        String addComputerActualHeading = BasePage.addAComputerPage.verifyAddAComputerHeading();
        System.out.println("Heading is: " + addComputerActualHeading);
        Assertions.assertEquals(addComputerActualHeading,addComputerexpectedHeading);
    }




    @Then("I should see four fields labelled")
    public void i_should_see_four_fields_labelled(io.cucumber.datatable.DataTable dataTable)
    {

        String computerName = BasePage.addAComputerPage.verifyComputerNameLabel();
        String introduced = BasePage.addAComputerPage.verifyIntroducedLabel();
        String discontinued = BasePage.addAComputerPage.verifyDiscontinuedLabel();
        String company = BasePage.addAComputerPage.verifyCompanyLabel();
        Assertions.assertEquals(computerName,dataTable.cell(1,0));
        Assertions.assertEquals(introduced,dataTable.cell(2,0));
        Assertions.assertEquals(discontinued,dataTable.cell(3,0));
        Assertions.assertEquals(company,dataTable.cell(4,0));



    }

    @Then("I should see two buttons")
    public void i_should_see_two_buttons(io.cucumber.datatable.DataTable dataTable) {

        Assertions.assertTrue(BasePage.addAComputerPage.verifyCreateThisComputerBtn(),
                "create this computer button is displayed");
        Assertions.assertTrue(BasePage.addAComputerPage.verifyCancelBtn(),
                "cancel button is displayed");


    }

    @When("I add a computer in the Add a New Computer view")
    public void i_add_a_computer_in_the_add_a_new_computer_view()
    {
       BasePage.homePage.clickAddaNewComputerBtn();
    }

    @When("I have already entered a name for a computer")
    public void i_have_already_entered_a_name_for_a_computer()
    {
        BasePage.addAComputerPage.enterComputerName("mac");
    }

    @When("Have not entered data into other fields")
    public void have_not_entered_data_into_other_fields()
    {

    }

    @When("I click Create this computer")
    public void i_Click_Create_This_Computer()
    {
        BasePage.addAComputerPage.clickCreateThisCompBtn();
    }


    @Then("It should not allow you to save")
    public void it_should_not_allow_you_to_save()
    {

    }

    @Then("It should indicate which fields are mandatory")
    public void it_should_indicate_which_fields_are_mandatory()
    {
      String errorMsg =  BasePage.editComputerPage.verifyComputerNameErrorMsg();
        System.out.println(errorMsg);
    }

    @When("I need to stop what I am doing and go back to the main view")
    public void i_need_to_stop_what_i_am_doing_and_go_back_to_the_main_view()
    {

    }

    @When("I click cancel button")
    public void i_click_cancel_button()
    {
       BasePage.addAComputerPage.clickCancelBtn();
    }

    @Then("It should take me back to the main computer database view")
    public void it_should_take_me_back_to_the_main_computer_database_view()
    {
        String computersCount = BasePage.homePage.verifyComputersFoundText();
        System.out.println("Computers Count Text is: "+ computersCount);
    }

    @When("I have entered valid data to all the form fields")
    public void i_have_entered_valid_data_to_all_the_form_fields(io.cucumber.datatable.DataTable dataTable)
    {
          BasePage.addAComputerPage.enterComputerName(dataTable.cell(1,0));
          BasePage.addAComputerPage.enterIntroduced(dataTable.cell(1,1));
          BasePage.addAComputerPage.enterDiscontinued(dataTable.cell(1,2));
          BasePage.addAComputerPage.selectCompany(dataTable.cell(1,3));
    }

    @Then("It should save the computer to the database")
    public void it_should_save_the_computer_to_the_database()
    {

    }

    @Then("I should be redirected back to the homepage")
    public void i_should_be_redirected_back_to_the_homepage()
    {
        System.out.println("Home Page Title is: " + BasePage.driverUtils.getPageTitle());
    }

    @Then("I should be able to see the total number of computers count updated in the page heading")
    public void i_should_be_able_to_see_the_total_number_of_computers_count_updated_in_the_page_heading()
    {
        String computersCount = BasePage.homePage.verifyComputersFoundText();
        System.out.println("Computers Count Text is: "+ computersCount);

    }

    @Then("I should be able to filter and see the newly saved computer")
    public void i_should_be_able_to_filter_and_see_the_newly_saved_computer() {

    }

    @When("I enter {string} {string} {string} {string} in the Add a New Computer view with invalid data")
    public void iEnterInTheAddANewComputerViewWithInvalidData(String cn, String i, String d, String c)
    {

        BasePage.addAComputerPage.enterComputerName(cn);
        BasePage.addAComputerPage.enterIntroduced(i);
        BasePage.addAComputerPage.enterDiscontinued(d);
        BasePage.addAComputerPage.selectCompanyByText(c);
    }


    @Then("I should be shown appropriate error message.")
    public void i_should_be_shown_appropriate_error_message()
    {

    }


    @When("I click on any computer name")
    public void iClickOnAnyComputerName()
    {
        BasePage.homePage.clickAceComputerName();
    }


    @Then("I should be navigated to edit computer page")
    public void iShouldBeNavigatedToEditComputerPage()
    {
      String actualEditText = BasePage.editComputerPage.verifyEditComputerText();
        System.out.println(actualEditText);
    }

    @And("I should see already saved details of the computer in the appropriate fields.")
    public void iShouldSeeAlreadySavedDetailsOfTheComputerInTheAppropriateFields()
    {
       String val = BasePage.editComputerPage.verifyComputerName("value");
        System.out.println(val);
    }

    @And("I should see two buttons as below")
    public void i_Should_See_Two_Buttons_AsBelow(io.cucumber.datatable.DataTable dataTable)
    {
        Assertions.assertTrue(BasePage.editComputerPage.verifySaveThisComputerBtn(),
                "save this computer button is displayed");
        Assertions.assertTrue(BasePage.addAComputerPage.verifyCancelBtn(),
                "cancel button is displayed");

    }

    @When("I have cleared the data from all the fields")
    public void iHaveClearedTheDataFromAllTheFields()
    {
        BasePage.editComputerPage.clearComputerName();
    }


    @And("I click Save this computer")
    public void iClickSaveThisComputer()
    {
        BasePage.editComputerPage.clickSaveThisCompBtn();

    }

    @When("I  enter valid data to all the form fields")
    public void iEnterValidDataToAllTheFormFields(io.cucumber.datatable.DataTable dataTable)
    {
          BasePage.editComputerPage.clearComputerName();

        BasePage.addAComputerPage.enterComputerName(dataTable.cell(1,0));
        BasePage.addAComputerPage.enterIntroduced(dataTable.cell(1,1));
        BasePage.addAComputerPage.enterDiscontinued(dataTable.cell(1,2));
        BasePage.addAComputerPage.selectCompanyByText(dataTable.cell(1,3));
    }

    @Then("It should update the computer to the database")
    public void itShouldUpdateTheComputerToTheDatabase()
    {
        String msg = BasePage.homePage.verifyConfMessage();
        System.out.println("Confirmation message after update is: " + msg);
    }


    @And("I see the button Delete this computer")
    public void iSeeTheButtonDeleteThisComputer() 
    {
      Assertions.assertTrue(BasePage.editComputerPage.verifyDeleteThisCompBtn(),
              "Delete this computer button is displayed");  
    }

    @When("I click Delete this computer button")
    public void iClickDeleteThisComputerButton() 
    {
        BasePage.editComputerPage.clickDeleteThisComputerBtn();
    }

    @Then("The computer should be removed from the database")
    public void theComputerShouldBeRemovedFromTheDatabase()
    {
        String msg = BasePage.homePage.verifyConfMessage();
        System.out.println("Confirmation message after clicking on delete is: " + msg);
    }

    @And("The computer should not be listed when I filter with the computer name")
    public void theComputerShouldNotBeListedWhenIFilterWithTheComputerName(io.cucumber.datatable.DataTable dataTable)
    {
         BasePage.homePage.enterTextIntoFilterByNameTextbox(dataTable.cell(1,0));
         BasePage.homePage.clickFilterByNameButton();
    }

    @And("I should see a filter section where computers can be filtered by their name")
    public void iShouldSeeAFilterSectionWhereComputersCanBeFilteredByTheirName()
    {
       Assertions.assertTrue(BasePage.homePage.verifyFilterTextbox(),"Filter Text box is displayed");
       Assertions.assertTrue(BasePage.homePage.verifyFilterButton(),"Filter Button is displayed");
    }

    @And("I should see {int} number of computers on each page within the computers listing page")
    public void iShouldSeeNumberOfComputersOnEachPageWithinTheComputersListingPage(int linkCount)
    {
           int actualCount = BasePage.homePage.getNumberOfComputers();
        System.out.println("Number of computers per page are:  " + actualCount);
        Assertions.assertEquals(linkCount,actualCount);
    }

    @And("I should also see appropriate Previous and Next links which will help me navigate through the table")
    public void iShouldAlsoSeeAppropriatePreviousAndNextLinksWhichWillHelpMeNavigateThroughTheTable()
    {
         Assertions.assertTrue(BasePage.homePage.verifyPreviousLink(),"Previous link is displayed");
         Assertions.assertTrue(BasePage.homePage.verifyNextLink(),"Next link is displayed");

    }

    @When("I add in a name to the Filter by computer name field {string}")
    public void iAddInANameToTheFilterByComputerNameField(String cn)
    {
        BasePage.homePage.enterTextIntoFilterByNameTextbox(cn);
    }


    @And("I click on the Filter by name button")
    public void iClickOnTheFilterByNameButton()
    {
        BasePage.homePage.clickFilterByNameButton();
    }


    @Then("I should be able to see filtered set of computers with name as requested")
    public void iShouldBeAbleToSeeFilteredSetOfComputersWithNameAsRequested()
    {
        String computersCount = BasePage.homePage.verifyComputersFoundText();
        System.out.println("Computers Count Text is: "+ computersCount);
    }

    @When("I click on the table header column Computer name")
    public void iClickOnTheTableHeaderColumnComputerName()
    {
        BasePage.homePage.clickComputerNameLink();
    }


    @Then("The table contents will be sorted in the descending order of the Computer name")
    public void theTableContentsWillBeSortedInTheDescendingOrderOfTheComputerName()
    {
        String changedLinkText = BasePage.homePage.verifyComputersSort();
        System.out.println("Text after descending sort order is: " + changedLinkText);
    }

    @When("I click on the table header column Computer name once again")
    public void iClickOnTheTableHeaderColumnComputerNameOnceAgain()
    {
        BasePage.homePage.clickComputerNameLink();
    }


    @Then("The table contents will be sorted in the ascending order of the Computer name")
    public void theTableContentsWillBeSortedInTheAscendingOrderOfTheComputerName()
    {
        String changedLinkText = BasePage.homePage.verifyComputersSort();
        System.out.println("Text after ascending sort order is: " + changedLinkText);
    }

    @When("I click on the table header column Introduced")
    public void iClickOnTheTableHeaderColumnIntroduced()
    {
        BasePage.homePage.clickIntroducedLink();
    }

    @Then("The table contents will be sorted in the descending order of the Introduced date")
    public void theTableContentsWillBeSortedInTheDescendingOrderOfTheIntroducedDate()
    {
        String changedLinkText = BasePage.homePage.verifyIntroducedSort();
        System.out.println("Text after descending sort order is: " + changedLinkText);
    }

    @When("I click on the table header column Introduced once again")
    public void iClickOnTheTableHeaderColumnIntroducedOnceAgain()
    {
        BasePage.homePage.clickIntroducedLink();
    }

    @Then("The table contents will be sorted in the ascending order of the Introduced date")
    public void theTableContentsWillBeSortedInTheAscendingOrderOfTheIntroducedDate()
    {
        String changedLinkText = BasePage.homePage.verifyIntroducedSort();
        System.out.println("Text after ascending sort order is: " + changedLinkText);
    }


    @When("I click on the table header column Discontinued")
    public void iClickOnTheTableHeaderColumnDiscontinued()
    {
        BasePage.homePage.clickDiscontinuedLink();
    }

    @Then("The table contents will be sorted in the descending order of the Discontinued date")
    public void theTableContentsWillBeSortedInTheDescendingOrderOfTheDiscontinuedDate()
    {
        String changedLinkText = BasePage.homePage.verifyDiscontinuedSort();
        System.out.println("Text after descending sort order is: " + changedLinkText);
    }

    @When("I click on the table header column Discontinued once again")
    public void iClickOnTheTableHeaderColumnDiscontinuedOnceAgain()
    {
        BasePage.homePage.clickDiscontinuedLink();
    }


    @Then("The table contents will be sorted in the ascending order of the Discontinued date")
    public void theTableContentsWillBeSortedInTheAscendingOrderOfTheDiscontinuedDate()
    {
        String changedLinkText = BasePage.homePage.verifyDiscontinuedSort();
        System.out.println("Text after ascending sort order is: " + changedLinkText);
    }

    @When("I click on the table header column Company")
    public void iClickOnTheTableHeaderColumnCompany()
    {
        BasePage.homePage.clickCompanyLink();
    }


    @Then("The table contents will be sorted in the descending order of the Company name")
    public void theTableContentsWillBeSortedInTheDescendingOrderOfTheCompanyName()
    {
        String changedLinkText = BasePage.homePage.verifyCompanySort();
        System.out.println("Text after descending sort order is: " + changedLinkText);
    }


    @When("I click on the table header column Company once again")
    public void iClickOnTheTableHeaderColumnCompanyOnceAgain()
    {
        BasePage.homePage.clickCompanyLink();
    }


    @Then("The table contents will be sorted in the ascending order of the Company name")
    public void theTableContentsWillBeSortedInTheAscendingOrderOfTheCompanyName()
    {
        String changedLinkText = BasePage.homePage.verifyCompanySort();
        System.out.println("Text after ascending sort order is: " + changedLinkText);
    }

    @When("I click on the Next button from within the pagination section")
    public void iClickOnTheNextButtonFromWithinThePaginationSection()
    {
        BasePage.homePage.clickNextLink();
    }


    @Then("I should be able to see the next {int} results from the list")
    public void iShouldBeAbleToSeeTheNextResultsFromTheList(int count)
    {
        int actualCount = BasePage.homePage.getNumberOfComputers();
        System.out.println("Number of computers per page are:  " + actualCount);
        Assertions.assertEquals(count,actualCount);
    }


    @And("The current page's display details in the pagination section should update accordingly")
    public void theCurrentPageSDisplayDetailsInThePaginationSectionShouldUpdateAccordingly()
    {
        String pageDisplayText = BasePage.homePage.getPageDisplayText();
        System.out.println("Page Display Text is: " + pageDisplayText);
    }


    @When("I click on the Previous button from within the pagination section")
    public void iClickOnThePreviousButtonFromWithinThePaginationSection()
    {
        BasePage.homePage.clickPreviousLink();
    }


    @Then("I should be able to see the previous {int} results from the list")
    public void iShouldBeAbleToSeeThePreviousResultsFromTheList(int count)
    {
        int actualCount = BasePage.homePage.getNumberOfComputers();
        System.out.println("Number of computers per page are:  " + actualCount);
        Assertions.assertEquals(count,actualCount);
    }


    @And("The current page's display details in the pagination section should update again")
    public void theCurrentPageSDisplayDetailsInThePaginationSectionShouldUpdateAgain()
    {
        String pageDisplayText = BasePage.homePage.getPageDisplayText();
        System.out.println("Page Display Text is: " + pageDisplayText);
    }
}
