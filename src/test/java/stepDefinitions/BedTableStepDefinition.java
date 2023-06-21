package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.Manage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static utilities.JDBCReusableMethods.getStatement;

public class BedTableStepDefinition {

    Statement statement;
    ResultSet resultSet;
    Manage manage = new Manage();

    @Given("Bed tablosuna query gönderilir ve sonuclar dogrulanir.")
    public void bed_tablosuna_query_gönderilir_ve_sonuclar_dogrulanir() throws SQLException {

        resultSet=getStatement().executeQuery(manage.getBedTableIsActiveQuery());
        resultSet.next();
        String expectedData="yes";

        Assert.assertEquals("yes",resultSet.getString(1));



    }

}
