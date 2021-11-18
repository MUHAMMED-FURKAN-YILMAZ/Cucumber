Feature: 1013 Kullanici DB util ile concort Hotel database'ini test eder

  @dbutil
  Scenario: TC19 DB util ile Concort Hotel Database Read Test

    Given kullanici DBUtil ile CHQA database'ine baglanir
    And kullanici DBUtil ile "tHOTELROOM" tablosundaki "Price" verilerini alir
    And kullanici DBUtil ile "Price" sutunundaki 5. fiyatin 470 oldugunu test eder



  @dbupdate
  Scenario: TC20 Kullanici tHOTEL tablosundan istedigi Emaili update eder

    Given kullanici DBUtil ile CHQA database'ine baglanir
    Then  DBU IDHotel degeri 1016 olan kaydin Email degerini "elveda@gmail.com" yapar