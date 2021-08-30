Feature: Application Should allow users to edit computers
  As A product manager
  I want frontend users to be able to update the database
  So That I dont have to book time with a database administrator

  Background: Navigate to the computer database app and goto edit computer page
    Given I navigate to the computer database app url "http://computer-database.gatling.io/computers"
    When  I click on any computer name
    Then  I should be navigated to edit computer page



  @edit1
  Scenario: The page to edit computer should have four new fields and two buttons

    Then  I should see four fields labelled
      | fields        |
      | Computer name |
      | Introduced    |
      | Discontinued  |
      | Company       |
    And I should see two buttons as below
      | buttons            |
      | Save this computer |
      | Cancel             |
    And I should see already saved details of the computer in the appropriate fields.


  @edit2
  Scenario: Application should not allow edit computers unless all fields are populated

    When  I have cleared the data from all the fields
    And   I click Save this computer
    Then  It should not allow you to save
    And   It should indicate which fields are mandatory

  @edit3
  Scenario: Application should allow me to cancel the operation
    But   I need to stop what I am doing and go back to the main view
    When  I click cancel button
    Then  It should take me back to the main computer database view

  @edit4
  Scenario: Application should allow computers to be edited with all fields populated

    When   I  enter valid data to all the form fields
      | Computer name | Introduced | Discontinued | Company |
      | IM007         | 1996-09-24 | 2005-09-18   | IBM     |
    And   I click Save this computer
    Then  It should update the computer to the database
    And   I should be redirected back to the homepage

  @edit5
  Scenario Outline: Application should not allow computers to be edited with invalid data
    When  I have cleared the data from all the fields
    And  I enter "<Computer name>" "<Introduced>" "<Discontinued>" "<Company>" in the Add a New Computer view with invalid data
    And   I click Save this computer
    Then  I should be shown appropriate error message.
    Examples:
      | Computer name | Introduced | Discontinued | Company |
      | £$%$%£        | 2022-01-10 | 2024-06-15   | OMRON   |
      | KC100         | 2016-01-10 | 2015-01-10   | OMRON   |
      | KB100         | 00000      | 00000        | OMRON   |
      |               | 2016-01-10 | 2018-01-10   | OMRON   |
      | KL100         |            | 2018-01-10   | OMRON   |
      | KR100         | 2016-01-10 | abcd         | OMRON   |
      | KR100         | sdefsdffdf | 2018-06-21   | OMRON   |

  @edit6
  Scenario: Application should allow computers to be deleted

    And   I see the button Delete this computer
    When  I click Delete this computer button
    Then  The computer should be removed from the database
    And   I should be redirected back to the homepage
    And   The computer should not be listed when I filter with the computer name
      | Computer name |
      | £$%$%£        |