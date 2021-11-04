Feature: US1007 editor sayfasina farkli kullanicilar ekleyebilmeliyim

  @editor
  Scenario Outline: TC11 editor sayfasina farkli kisiler ekleme

    Given kullanici "editorUrl" sayfasina gider
    Then new butonuna basar
    #And editor firsName kutusuna "<firstName>" bilgileri girer
    #And editor lastName kutusuna "<lastName>" bilgileri girer
    #And editor position kutusuna "<position>" bilgileri girer
    #And editor office kutusuna "<office>" bilgileri girer
    #And editor extension kutusuna "<extension>" bilgileri girer
    #And editor startDate kutusuna "<startDate>" bilgileri girer
    #And editor salary kutusuna "<salary>" bilgileri girer
    #And Create tusuna basar

    And editor ilgili kutulara "<firstName>" "<lastName>" "<position>" "<office>" "<extension>" "<startDate>" "<salary>" bilgilerini girer
    # ustteki cucumber icin cok daha  kullanisli cok daha mantikli

    Examples:
    |firstName| lastName|position|office|extension|startDate |salary|
    |Hakan    |Tetik    |TestLead|Paris |124      |12-01-2021|60000 |
    |Murat    |Ercoban  |QA      |Kenya |126      |12/01/2021|40000 |
    |Furkan   |Yilmaz   |QA      |Adana |130      |12.01.2021|80000 |