Feature: Calculator Assignment

  Scenario Outline: Functions on two numbers
    Given Opening calculator webpage
    When Entering '<n1>' in the calculator
    And Enter operator '<op>' in the calculator
    And Entering '<n2>' in the calculator
    Then Checking result as per '<expected>'

    Examples:
      | n1 | op | n2 | expected |
      |-234234 |+|345345 |111111|
      |234823 |- |-23094823|23329646|
      |4000   |/ |200     |20 |
      |423    |* |525     |222075  |




