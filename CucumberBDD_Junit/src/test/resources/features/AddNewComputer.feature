Feature: Application Should allow users to add new computers to the database for searching at a later date
  As A product manager
  I want frontend users to be able to update the database
  So That I dont have to book time with a database administrator

  Background: Navigate to the computer database app
    Given I navigate to the computer database app url "http://computer-database.gatling.io/computers"


  @new
  Scenario: There should be a link to the new section that allows users to add computers to the database

    Then  I should see a page with heading "574 computers found"
    And   I should see Add a new computer button on the page

  @new
  Scenario: User should be able to access the new section

    When   I click on Add a new computer button
    Then  I should be redirected to a new page from where I can add a new computer
    And   The new page should have a heading "Add a computer"

  @ui
  Scenario: The page to add new computer should have four new fields and two buttons

    When   I click on Add a new computer button
    And   The new page should have a heading "Add a computer"
    Then  I should see four fields labelled
      | fields        |
      | Computer name |
      | Introduced    |
      | Discontinued  |
      | Company       |
    And I should see two buttons
      | buttons              |
      | Create this computer |
      | Cancel               |

  @create
  Scenario: Application should not allow new computers to be added unless all fields are populated
    When  I add a computer in the Add a New Computer view
    And   I have already entered a name for a computer
    But   Have not entered data into other fields
    When  I click Create this computer
    Then  It should not allow you to save
    And   It should indicate which fields are mandatory

  @cancel
  Scenario: Application Should allow me to cancel the operation
    When  I add a computer in the Add a New Computer view
    But   I need to stop what I am doing and go back to the main view
    When  I click cancel button
    Then  It should take me back to the main computer database view

  @createvalid
  Scenario: Application should allow new computers to be added with all fields populated
    When  I add a computer in the Add a New Computer view
    And   I have entered valid data to all the form fields
      | Computer name | Introduced | Discontinued | CompanyValue |
      | OM007         | 1996-09-21 | 2006-06-15   | 1            |
    When  I click Create this computer
    Then  It should save the computer to the database
    And   I should be redirected back to the homepage
    And  I should be able to see the total number of computers count updated in the page heading
    And   I should be able to filter and see the newly saved computer


  @multiple
  Scenario Outline: Application should not allow new computers to be added with invalid data
    When  I add a computer in the Add a New Computer view
    And   I enter "<Computer name>" "<Introduced>" "<Discontinued>" "<Company>" in the Add a New Computer view with invalid data
    And   I click Create this computer
    Then  I should be shown appropriate error message.
    Examples:
      | Computer name | Introduced | Discontinued | Company |
      | @%^1          | 2016-01-10 | 2015-01-10   | OMRON   |
      | *&^%          | 00000      | 00000        | OMRON   |
      | #$562         | 2016-01-10 | 2018-01-10   | OMRON   |
      | !@#$          | 2016-01-10 | 2018-01-10   | OMRON   |
      | ^&$@          | 2323534    | 2018-01-10   | OMRON   |
      | (*&^^)        | 2016-01-10 | abcd         | OMRON   |
      | KR100         | sdefsdffdf | 2018-06-21   | OMRON   |