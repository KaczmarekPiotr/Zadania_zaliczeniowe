Feature: Create New Address

  Scenario Outline: user can add new address

    Given an open browser with https://prod-kurs.coderslab.pl
    When select Sign in button
    And Email <email> is entered in E-mail input field
    And Password <password> is entered in Password input field
    And sign in button is selected
    And ADDRESSES button is selected
    And + Create new address option is chosen
    And a <alias> is entered in Alias input field
    And a <address> is entered in address input field
    And a <city> is entered in City input field
    And a <zipCode> is entered in Zip / Postal Code input field
    And a <phone> is entered in Phone input field
    And Save button is clicked
    Then New Address is added and equals <address>, <city>, <zipCode>, <phone>

    Examples:
      | email              | password | alias | address    | city   | zipCode | phone          |
      | d1786537@urhen.com | 12345    | Koks  | Dmowskiego | London | 43-100  | 0 700 77 77 77 |
