Feature: Testing api CoinMarketCap

  Scenario Outline: Convert price of Coins in USD in Bs
    Given I send request for price of "<coin>"
    When I get price of "<coin>"
    Then I will convert "<coin>" in Bs
    Examples:
      | coin  |
      | BTC   |
      | USDT  |
      | ETH   |

  Scenario: Tehnical documentation for ETH information
    Given I send request for info of ETH
    When I got response i will check logo "https://s2.coinmarketcap.com/static/img/coins/64x64/1027.png", tehnical doc on github "https://github.com/ethereum/wiki/wiki/White-Paper"
    And I check symbol "ETH" and date "2015-08-07T00:00:00.000Z" od added coin
    Then I will verify platform tag name "mineable"


  Scenario: Getting info for first 10 id coins on coinmarketcap
    Given I send request for first 10 coins
    When I check which currency is mineable
    Then I will verify every coin
