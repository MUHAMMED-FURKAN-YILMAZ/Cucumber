Feature: US2001_GMIBank Pozitif login

  Scenario:  TC01 Pozitif login Testi

    When kullanici gmibank sayfasina gider
    Then sayfaya giris yapar
    And sayfaya giris yaptigini dogrular
    Then gmibanl signout butonuna tiklar
    And gmibank sayfasinda cikis yaptigini dogrular