Feature: Application Should list all the computers from the database
  As A product manager
  I want frontend users to be able to see all the computers saved to the database

  Background: Navigate to the computer database app
    Given I navigate to the computer database app url "http://computer-database.gatling.io/computers"

 @list1
  Scenario: Users should be a able to access the application
    Then  I should see a page with heading "574 computers found"
    And   I should see a filter section where computers can be filtered by their name
    And   I should see Add a new computer button on the page
    And   I should see 10 number of computers on each page within the computers listing page
    And   I should also see appropriate Previous and Next links which will help me navigate through the table

  @list2
  Scenario Outline: Users should be able to filter computers by using the computer name

    When  I add in a name to the Filter by computer name field "<Filter by computer name>"
    And   I click on the Filter by name button
    Then  I should be able to see filtered set of computers with name as requested
    Examples:
      |  Filter by computer name    |
      |  acer                       |
      |  ibm                        |
      |  macintosh                  |


  @list3
  Scenario: Users should be able to sort the computers list by clicking the table header column named Computer name

    When  I click on the table header column Computer name
    Then  The table contents will be sorted in the descending order of the Computer name
    When  I click on the table header column Computer name once again
    Then  The table contents will be sorted in the ascending order of the Computer name

  @list4
  Scenario: Users should be able to sort the computers list by clicking the table header column named Introduced

    When  I click on the table header column Introduced
    Then  The table contents will be sorted in the descending order of the Introduced date
    When  I click on the table header column Introduced once again
    Then  The table contents will be sorted in the ascending order of the Introduced date

  @list5
  Scenario: Users should be able to sort the computers list by clicking the table header column named Discontinued

    When  I click on the table header column Discontinued
    Then  The table contents will be sorted in the descending order of the Discontinued date
    When  I click on the table header column Discontinued once again
    Then  The table contents will be sorted in the ascending order of the Discontinued date

  @list6
  Scenario: Users should be able to sort the computers list by clicking the table header column named Company

    When  I click on the table header column Company
    Then  The table contents will be sorted in the descending order of the Company name
    When  I click on the table header column Company once again
    Then  The table contents will be sorted in the ascending order of the Company name



  @list7
  Scenario: Users should be able to paginate through the computer list

    When  I click on the Next button from within the pagination section
    Then  I should be able to see the next 10 results from the list
    And   The current page's display details in the pagination section should update accordingly
    When  I click on the Previous button from within the pagination section
    Then  I should be able to see the previous 10 results from the list
    And   The current page's display details in the pagination section should update again