
Feature:GMIBank guvenli Sifre

  Background:
    Given kullanici gmibank sayfasina gider
    Then gmibank giris butonuna tiklar
    Then gmibank register butonuna tiklar
    And gmibank password kutusuna tiklar

  Scenario Outline: Password Red Test
    Given "<password>" girer
    Then gmibank Password strength red gorunur
    Examples:
      | password |
      |1111      |
      |AAAA      |

  Scenario Outline: Password Orange Test
    Given "<passwordOrange>" girer
    Then gmibank Password strength orange gorunur
    Examples:
      | password |
      |11AA      |
      |AA22      |
