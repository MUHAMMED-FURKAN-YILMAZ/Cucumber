package dbStepdefinitions;

import io.cucumber.java.en.Given;
import org.junit.Assert;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
// import java.sql.*; -> java.sql'de hepsini import etmis oluruz

public class DbStepDefinition {

    String url="jdbc:sqlserver://184.168.194.58:1433;databaseName=qaconcorthotel; user=Ahmet_User;password=Ahmet123!";
    String username="Ahmet_User";
    String password="Ahmet123!";

    Connection connection;
    Statement statement;
    ResultSet resultSet;


    @Given("kullanici CHQA database'ine baglanir")
    public void kullanici_chqa_database_ine_baglanir() throws SQLException {
        connection= DriverManager.getConnection(url,username,password);
        statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }


    @Given("kullanici {string} tablosundaki {string} verilerini alir")
    public void kullanici_tablosundaki_verilerini_alir(String table, String field) throws SQLException {
        //SELECT Price FROM tHOTELROOM... query bu olabilirdi ama kodu dinamik yaptik
        String readQuery="SELECT " + field +" FROM " + table;
        resultSet= statement.executeQuery(readQuery);
    }


    @Given("kullanici {string} sutunundaki verileri okur ve istedigi islemleri yapar")
    public void kullanici_sutunundaki_verileri_okur_ve_istedigi_islemleri_yapar(String field) throws SQLException {

        // resultSet, iterator gibi calisir
        resultSet.first(); //Moves the cursor to the first row in this ResultSet object.
                            // yani İmleci bu resultSet nesnesindeki ilk satıra tasir.
        System.out.println(resultSet.getObject(field).toString());

//        resultSet.getRow() 	=> Hangi rowdasin
//        resultSet.first() 		=> Ilk rowa git
//        resultSet.last 			=> son row a git
//        resultSet.absolute(5)	=> 5inci row a git
//        resultSet.getObject("BookName") 	=>BookName row daki objeyi ver
//        resultSet.getString("BookName") 	=>BookName row daki degeri ver


        // resultSet.next() methodu iterator'daki hasnext() gibi, cursoru bir sonraki objeye goturur,
        // sonraki eleman varsa true, yoksa false doner
        System.out.println(resultSet.next()); //true
        System.out.println(resultSet.getObject(field).toString());

        //son obje'ye gider ve sonra resultSet.next() methodunu calistirirsak
        // bir sonraki eleman olmayacagi icin false doner ve cursor oldugu yerde kalir
        resultSet.last();
        System.out.println(resultSet.next());// false


        // tum listeyi yazdirmak istersek while loop ile birlikte resultSet.next() kullanabiliriz
        // cunku bu method bir sonraki obje var oldugu muddetce bize true dondurecek ve while loop
        // calismaya devam edecek. Son objeye ulastigimizda resultSet.next() false donecek ve while loop bitecek
        // Ancak 40. ve son satirda son objeye gittigimiz icin while loop'u calistirirsak hic bir sey yazdirmaz
        // while loop calistirmadan once ilk objeye gitmemiz gerekir


        /*
        resultSet.first(); // birinci objeye gittim
        while(resultSet.next()){//ustteki satir birinci objeye goturdu ama resultSet.next() sonraki objeye gecirdi
                                // dolayisi ile liste ikinci fiyattan basladi..
                                // bikac cozum var orn do-while veya resultSet.absolute(0);...
            System.out.println(resultSet.getObject(field).toString());
        }
*/
        /*
        resultSet.absolute(0);
        while (resultSet.next()){
            System.out.println(resultSet.getObject(field));
        }
*/


        // varsa ilk 100 fiyati bir listeye alarak kaydedelim

        // 1. way**************
       /*
        List<String > elemanlar = new ArrayList<>();

        resultSet.first();
        for (int i = 0; i < 100; i++) {
            try {
                elemanlar.add((i+1) +"- " + resultSet.getObject(field).toString()) ;
            }catch (Exception e) {

            }
        }

        System.out.println(elemanlar);
        */

        // 2. way ************
        int sayac=1;
        resultSet.absolute(0);
        List<Double> ilkYuzSayi= new ArrayList<>();

        while (sayac<=100 && resultSet.next()){
           // ilkYuzSayi.add(Double.valueOf(resultSet.getObject(field).toString()));
            ilkYuzSayi.add(resultSet.getDouble(field));
            sayac++;
        }
        System.out.println(ilkYuzSayi);
        System.out.println(ilkYuzSayi.size());


        // 7. fiyatin double olarak 620.0 oldugunu test edin
        resultSet.absolute(7);

        Double yedinciSayi=resultSet.getDouble(field);

        Assert.assertTrue(yedinciSayi==620);
    }
}
