Feature: Create pets via post

  Scenario Outline: Create pets and assert they were created
    Given we have pets be api
    When we create pet with name <Pet name>, type as <Pet type> and age <Pet age>
    Then pet should be created with name <Pet name>, type as <Pet type> and age <Pet age>

    Examples:
      | Pet name | Pet type | Pet age |
      | Rexio    | DOG      | 3       |
      | Lapka    | CAT      | 5       |
      | Rab      | RABBIT   | 1       |