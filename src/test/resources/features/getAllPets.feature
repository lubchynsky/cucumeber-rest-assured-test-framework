Feature: Test to get all pets from be api

  Scenario: Get all pets and assert list is not empty
    Given we have pets be api
    When we get all pets
    Then there should be some pets returned