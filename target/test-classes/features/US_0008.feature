@US_0008
  Feature: US_0008 Password segment on Homepage should be editable

    Background: Go to GMIBank page
      Given User goes to GMIBank page
      And User click menuIcon
      And User click signInButton
      And User enter the valid username
      And User enter the valid password
      And User click the Sign in button
      And User click menuIcon
      And User click password icon
      And User click current password and enter current password

    @TC_0801
      Scenario: TC_0801 The old password should not be used
        And User click new password and enter current password
        And User click new password confirmation and enter current password
        And User click save button
        And User sees not saved message
        Then User sign out to website

      @TC_0802
      Scenario Outline: TC_0802 There should be at least 1 lowercase char for stronger password and see the level chart change accordingly
        And User click new password and user enter "<new password>"
        And User sees password strength on the "<level>" bar
        Then User sign out to website

        Examples:
          |new password|level|
          | bb         | 1   |
          | Bb         | 2   |
          | +b         | 2   |
          | 2b         | 2   |
          | bB+        | 3   |
          | bB+2       | 4   |


      @TC_0803
      Scenario Outline: TC_0803 There should be at least 1 uppercase char and see the level  chart change accordingly
        And User click new password and user enter "<new password>"
        And User sees password strength on the "<level>" bar
        Then User sign out to website

        Examples:
          |new password|level|
          | CC         | 1   |
          | cC         | 2   |
          | -C         | 2   |
          | 3C         | 2   |
          | Cc-        | 3   |
          | Cc-3       | 4   |


    @TC_0804
    Scenario Outline: TC_0804 There should be at least 1 digit  and see the level  chart change accordingly
      And User click new password and user enter "<new password>"
      And User sees password strength on the "<level>" bar
      Then User sign out to website

      Examples:
        |new password|level|
        | 44         | 1   |
        | d4         | 2   |
        | D4         | 2   |
        | !4         | 2   |
        | 4dD        | 3   |
        | 4dD!       | 4   |


    @TC_0805
    Scenario Outline: TC_0805 There should be at least 1 special char and see the level bar change accordingly
      And User click new password and user enter "<new password>"
      And User sees password strength on the "<level>" bar
      Then User sign out to website

      Examples:
        |new password|level|
        | **         | 1   |
        | e*         | 2   |
        | E*         | 2   |
        | 5*         | 2   |
        | *eE        | 3   |
        | *eE5       | 4   |


