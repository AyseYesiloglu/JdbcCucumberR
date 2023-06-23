package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.JDBCReusableMethods;
import utilities.Manage;

import javax.swing.plaf.basic.BasicListUI;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static utilities.JDBCReusableMethods.getStatement;

public class BedTableStepDefinition {

    Statement statement;
    ResultSet resultSet;
    Manage manage = new Manage();
    String query = "";

    @Given("Bed tablosuna query gönderilir ve sonuclar dogrulanir.")
    public void bed_tablosuna_query_gönderilir_ve_sonuclar_dogrulanir() throws SQLException {
        resultSet = getStatement().executeQuery(manage.getBedTableIsActiveQuery());
        resultSet.next();
        String expectedData = "yes";
        Assert.assertEquals("yes", resultSet.getString(1));
    }
    //@Given("Bed tablosunda name bilgisinin {int}  ve {string} oldugunun sorgusu gonderilir.Gerekli bilgi {string} olarak sonuc dogrulanir")
    //public void bed_tablosunda_name_bilgisinin_ve_oldugunun_sorgusu_gonderilir_gerekli_bilgi_olarak_sonuc_dogrulanir(Integer bed_group_id, String is_active, String name) throws SQLException {
    // query = "SELECT " + name + ", " + bed_group_id + ", " + is_active + " FROM heallife_hospitaltraining.bed WHERE bed_group_id = " + bed_group_id + " AND is_active = '" + is_active + "';";
    //    query = "SELECT " + name + ", " + bed_group_id + ", " + is_active + " FROM heallife_hospitaltraining.bed WHERE bed_group_id = " + bed_group_id + " AND is_active = '" + is_active + "';";
    //    resultSet=getStatement().executeQuery(query);
    //    List<Object>resultList=new ArrayList<>();
    //   while ( resultSet.next()){
    //       resultList.add(resultSet.getInt(2)+" "+resultSet.getString(4)+" "+resultSet.getString(5));
    //   }
    //    System.out.println(resultList.add(resultSet.getInt(2)+" "+resultSet.getString(4)+" "+resultSet.getString(5)));
    // }
    @Given("Bed tablosunda name bilgisine gore {string}, {int} ve {string} bilgisi sorgulanir ve sonuclar dogrulanir.")
    public void bed_tablosunda_name_bilgisine_gore_ve_bilgisi_sorgulanir_ve_sonuclar_dogrulanir(String name, Integer bed_group_id, String is_active) throws SQLException {
        //  String query = "SELECT name, bed_group_id,is_active FROM heallife_hospitaltraining.bed WHERE bed_group_id = " + bed_group_id + " AND is_active = '" + is_active + "'";
      query = "SELECT name, bed_group_id,is_active FROM heallife_hospitaltraining.bed WHERE name=' " +name+ "'; ";
        resultSet = JDBCReusableMethods.getStatement().executeQuery(query);
        List<Object> resultList = new ArrayList<>();
        while (resultSet.next()) {
            resultList.add(resultSet.getString(name)+resultSet.getInt(bed_group_id)+resultSet.getString(is_active));
            String expectedName="105";
        }
        System.out.println(resultList);
    }

    @Given("Bed tablosunda  {int}  bilgisine ve {string} bilgisine göre {string} bilgisi sorgulanir ve sonuclar dogrulanir.")
    public void bed_tablosunda_bilgisine_ve_bilgisine_göre_bilgisi_sorgulanir_ve_sonuclar_dogrulanir(Integer bed_group_id, String name, String string2) {

        query="SELECT "+name+" FROM heallife_hospitaltraining.bed WHERE bed_group_id = '"+4+"' AND is_active = 'no';";
    }

}
