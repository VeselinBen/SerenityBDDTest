Feature: Testing coinmarketcap.com

  Background:
    Given I navigate to CoinMarketcap web page

  Scenario: Check NFT price than I will comeback to Cryptocurrencies
    Given I want to check NFTs price
    When I comeback to Cryptocurrencies
    Then I will verify all results are displayed

  Scenario: Check atrributes for 5-10 coins
    Given I Select from 5 to 10 coins
    When I navigate on history data of random coin
    And I change data range to display last 7 days
    Then I will check the attributes of the coin

  Scenario: Check Spotlight criptocurrencies and most visited
    Given I select spotlight coins
    When I navigate to most visited coins
    And open most visited coins in new tab
    Then I verify most visited page
