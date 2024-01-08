Feature: Testing Star Wars API


  Scenario: Verify endpoint people/2/

    Given I have the base URL 'https://swapi.dev/api/'
    When I request the endpoint 'people/2/'
    Then the response status should be 200
    And the response should contain "gold" for the skin color
    And the response should contain 6 films


  Scenario: Verify second movie endpoint from people/2/
    Given I have the base URL 'https://swapi.dev/api/'
    And I requested the endpoint 'people/2/'
    When I request the endpoint of the second movie from the response
    Then the response status should be 200
    And the release date should be in the correct date format
    And the response should contain multiple characters
    And the response should contain multiple planets
    And the response should contain multiple starships
    And the response should contain multiple vehicles
    And the response should contain multiple species

  Scenario Outline: Verify first planet from the last film's response
    Given I have the base URL 'https://swapi.dev/api/'
    And I requested the endpoint 'people/2/'
    And I requested the endpoint of the second movie from the response
    When I request the endpoint of the first planet from the last film
    Then the response status should be 200
    And gravity should match exactly <gravity>
    And the terrains should match exactly <terrains>
    Examples:
      | gravity    | terrains            |
      | 1 standard | plains, seas, mesas |

  Scenario: Verify matching response from planet URL
    Given I have the base URL 'https://swapi.dev/api/'
    And I requested the endpoint 'people/2/'
    And I requested the endpoint of the second movie from the response
    And I request the endpoint of the first planet from the last film
    When I request the planet URL
    Then the response status should be 200
    And the response should match exactly as the previous one

  Scenario: Verify /films/7/ for 404 response
    Given I have the base URL 'https://swapi.dev/api/'
    When I request the endpoint '/films/7/'
    Then the response status should be 404