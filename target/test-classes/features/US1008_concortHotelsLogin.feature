Feature: US1008 Concort Hotels Login

  Scenario: TC12 kullanici gecerli bilgilerle giris yapar
    Given kullanici "CHQAUrl" sayfasina gider
    Then CH login linkine tiklar
    And gecerli username girer
    And gecerli password girer
    And CH login butonuna basar
    Then sayfaya giris yaptigini kontrol eder
    And  sayfayi kapatir