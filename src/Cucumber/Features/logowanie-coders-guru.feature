Feature: Logowanie CodersGuru

  Scenario Outline: user can create an account

    Given an open browser with https://tester.codersguru.pl/
    When zaloz konto button is selected
    And a keyword <email> is entered in E-mail input field
    And a keyword <imie> is entered in Imie input field
    And a keyword <nazwisko> is entered in Nazwisko input field
    And a keyword <haslo> is entered in Haslo input field
    And a keyword <haslo2> is entered in Powtorz haslo input field
    And a keyword <miasto> is entered in Miasto input field
    And a keyword <kod> is entered in Kod pocztowy input field
    And a keyword <ulica> is entered in Ulica input field
    And a keyword <nrDomu> is entered in Numer domu input field
    And Regulamin is checked and Zarejestruj button is clicked
    Then the logged in user is <imie>
    And close browser

    Examples:
      | email              | imie  | nazwisko  | haslo | haslo2 | miasto   | kod    | ulica | nrDomu |
      | lvr62892@eveav.com | Zenek | Zenkowski | 12345 | 12345  | Katowice | 43-200 | Polna | 6      |
