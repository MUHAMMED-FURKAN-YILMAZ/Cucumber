
Feature: US1004 ebay sayfasinda kelime arama

  Scenario: TC08 kullanici ebay'de istedigi kelimeyi aratip test eder
   # Bu test CALISMAZ
    Given kullanici "ebayUrl" sayfasina gider
    Then "nutella" icin arama yapar
    And sonucun "nutella" icerdigini test eder
    Then sayfayi kapatir

    # Burada tum stepdefinition'lar tanimli gibi gorunse de testimiz calismaz
    # Cunku arama yapar ve sonucu test eder stepdefinition'lari amazon sayfasina gore locate edilmisti
    # burada yeniden locate etmemiz gerekirken ayni cumleyi yazdigimiz icin
    # bizden yeni stepdefinition istemedi
    # Bu yüzden gherkin ile yazdiginiz cumlelerin tam tanimlayici olmasi ONEMLIDIR