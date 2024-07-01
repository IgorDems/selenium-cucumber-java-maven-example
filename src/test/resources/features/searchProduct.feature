Feature: Search and order products


#  Background:


  Scenario: Search product on Home and Offers pages
    Given User is on GreenCart Landing page
    When user searched with shortname "Tom" and extract the actual name of product
    Then user searched for the shortname "Tom" in offers to check product exist
    And prodname in Offrer Page have to mathces with prodname Landing Page