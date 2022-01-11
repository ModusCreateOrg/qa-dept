Feature: Ecosia website uses
    To verify all the advantages in using Ecosia.com

    Scenario: Search for a keyword in Ecosia search engine
        Given I open the Ecosia home page
        And the title is "Ecosia"
        Then the user enters keyword "Docker"
        Then the user submits the keyword
        Then the user verifies the search results for "Docker"
 