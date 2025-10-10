Feature: Interaction with the LuloX chatbox
  As a user of the LuloX website
  I want to interact with the available chatbox
  So that I can verify its proper functionality

  Scenario Outline: Open and interact with the chatbox
    Given the user navigates to the LuloX website "<url>"
    When the user sees the chatbox and clicks on the chatbox to open it
    And the user interacts with the chatbox
    Then the user receives a response from the chat

    Examples:
      | url               |
      | https://lulox.co/ |