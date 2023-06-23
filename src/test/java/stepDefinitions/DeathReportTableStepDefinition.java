package stepDefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.JDBCReusableMethods;
import utilities.Manage;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeathReportTableStepDefinition {

    ResultSet resultSet;
    Manage manage=new Manage();
    @Then("query is done according to the date of death")
    public void query_is_done_according_to_the_date_of_death() throws SQLException {
     resultSet= JDBCReusableMethods.getStatement().executeQuery(manage.getDeathReportFromLastDateQuery());


    }
    @Then("the query result should match the following {string}")
    public void the_query_result_should_match_the_following(String guardian_name) throws SQLException {
        resultSet.next();
        System.out.println();
        String actualName=resultSet.getString("guardian_name");
        Assert.assertEquals(guardian_name,actualName);


    }
}
