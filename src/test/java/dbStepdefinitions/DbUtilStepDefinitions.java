package dbStepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DBUtils;

import java.sql.SQLException;

public class DbUtilStepDefinitions {



    @Given("kullanici DBUtil ile CHQA database'ine baglanir")
    public void kullaniciDBUtilIleCHQADatabaseIneBaglanir() {
        DBUtils.getConnection();
       // DBUtils.createConnection();
    }


    @And("kullanici DBUtil ile {string} tablosundaki {string} verilerini alir")
    public void kullaniciDBUtilIleTablosundakiVerileriniAlir(String table, String field) {
        String readQuery="SELECT "+field+" FROM "+table;
        DBUtils.executeQuery(readQuery);

    }


    @And("kullanici DBUtil ile {string} sutunundaki {int}. fiyatin {int} oldugunu test eder")
    public void kullaniciDBUtilIleSutunundakiFiyatinOldugunuTestEder(String field, int satirNo, int expectedPrice) throws Exception {


        int satirSayisi=DBUtils.getRowCount();
        int aktifSatirNumarasi=1;

        System.out.println(satirSayisi);

        DBUtils.getResultset().first();
        // tum satirlardaki price'i gorduk
        while (aktifSatirNumarasi<satirSayisi){
            System.out.println(aktifSatirNumarasi+". satirdaki fiyat :"+ DBUtils.getResultset().getDouble(field));
            DBUtils.getResultset().next();
            aktifSatirNumarasi++;
        }

        // istenen satirNo'daki expectedPrice ile actualPrice'i karsilastirdik
        DBUtils.getResultset().absolute(satirNo);
        int actualDeger=DBUtils.getResultset().getInt(field);
        Assert.assertEquals(actualDeger,expectedPrice);

    }


    @Then("DBU IDHotel degeri {int} olan kaydin Email degerini {string} yapar")
    public void dbuIDHotelDegeriOlanKaydinEmailDegeriniYapar(int IDHotelNo, String yeniEmail) throws SQLException {

        //update
        String updateQuery="UPDATE tHOTEL SET Email='"+yeniEmail+"' WHERE IDHotel="+IDHotelNo;
        DBUtils.executeQuery(updateQuery);




        // database'i gordugumuz kisim
        String readQuery= "SELECT Email FROM tHOTEL";

        DBUtils.executeQuery(readQuery);

        int aktifSatirNumarasi=1;
        DBUtils.getResultset().first();

        while (aktifSatirNumarasi<100){

            Object satirdakiObje=DBUtils.getResultset().getObject("Email");
            System.out.println(aktifSatirNumarasi + ".satirdaki Email :" + satirdakiObje.toString());
            DBUtils.getResultset().next();
            aktifSatirNumarasi++;
        }
    }



}
