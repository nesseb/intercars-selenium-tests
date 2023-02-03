Feature: Shopping basket operation
  Scenario Outline: Should remove tires for given cars model
    Given user selects a vehicle "<brand>" "<model>" with "<engine>" engine
    When user add <howManyTires> tires to the shopping basket
    Then basket should contain selected tires
    When user remove selected tires from shopping basket
    Then shopping basket should be empty

    Examples:
      | brand  | model               | engine                  | howManyTires |
      | Audi   | A3 (8P1) 2003 - 2012| 1.6 FSI (BLP, BLF, BAG) | 4            |
      | BMW    | 3 (E46) 1997 - 2005 | 318 d (M47 D20 (204D1)) | 4            |
