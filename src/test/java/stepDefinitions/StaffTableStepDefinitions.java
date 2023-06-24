package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.JDBCReusableMethods;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class StaffTableStepDefinitions {

    ResultSet resultSet;

    List<Object> actualList = new ArrayList<>();
    List<Object> expectedList;

    @Then("Create a query that alphabetically sorts the {string} of those whose qualification is {string} and specialization is {string}")
    public void create_a_query_that_alphabetically_sorts_the_of_those_whose_qualification_is_and_specialization_is(String string, String MS, String Neurology) throws SQLException {
        String query = "  Select account_title from staff where qualification='" + MS + "' and specialization= '" + Neurology + "' order by " + string + ";";
        resultSet = JDBCReusableMethods.getStatement().executeQuery(query);

        while (resultSet.next()) {
        actualList.add(resultSet.getString("account_title"));

        }
    }

    @And("the query result should be match based on {string} staff table query")
    public void theQueryResultShouldBeMatchBasedOnStaffTableQuery(String account_title) {
        Assert.assertTrue(actualList.contains(account_title));
    }
}
