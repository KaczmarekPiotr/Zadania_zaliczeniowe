Feature: Buying some Stuff

  Scenario Outline: logged user can make and order

    Given an open browser with https://prod-kurs.coderslab.pl
    When select Sign in button
    And <email> and <password> is entered
    And CLOTHES button is selected
    And Hummingbird Printed Sweater is chosen
    And Size <size> is selected
    And Quantity <quantity> is chosen
    And Add to cart is selected
    And Proceed to checkout is selected
    And Address is confirmed
    And Shipping metode is chosen to PresaShop "pick up in store"
    And Pay by check is chosen and terms of service are checked
    And Order button is clicked
    Then Printscreen of order confirmation is done

    Examples:
      | email              | password | size | quantity |
      | d1786537@urhen.com | 12345    | M    | 5        |
