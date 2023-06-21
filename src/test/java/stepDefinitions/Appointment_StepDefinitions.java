package stepDefinitions;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.Manage;
import utilities.JDBCReusableMethods;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static utilities.JDBCReusableMethods.getStatement;
import static utilities.JDBCReusableMethods.getStatement;
public class Appointment_StepDefinitions {
    Statement statement;
    ResultSet resultSet;
    String query;
    Manage manage = new Manage();
    @Then("appointment table icin query hazirlanir")
    public void appointment_table_icin_query_hazirlanir() throws SQLException {
        // resultSet = getStatement().executeQuery(manage.getQueryAppointmentStatus());
    }
    @Then("appointment table icin query calistirili ve sonuclari alinir")
    public void appointment_table_icin_query_calistirili_ve_sonuclari_alinir() throws SQLException {
        resultSet = getStatement().executeQuery(manage.getQueryAppointmentStatus());
        resultSet.next();
    }
    @Then("appointment table icin query sonuclari dogrulanir")
    public void appointment_table_icin_query_sonuclari_dogrulanir() throws SQLException {
        String expectedData = "approved";
        String actualData = resultSet.getString(1);
        Assert.assertEquals(expectedData, actualData);
    }
    @Then("baglantisi kapatilir.")
    public void baglantisi_kapatilir() {
        JDBCReusableMethods.closeConnection();
    }
}