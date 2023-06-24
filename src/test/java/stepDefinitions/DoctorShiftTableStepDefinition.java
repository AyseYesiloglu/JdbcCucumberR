package stepDefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.JDBCReusableMethods;
import utilities.Manage;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DoctorShiftTableStepDefinition {

    ResultSet resultSet;
    Manage manage=new Manage();
    @Then("query is done according to the how much time work hours of doctor on {string}")
    public void query_is_done_according_to_the_how_much_time_work_hours_of_doctor_on(String Tuesday) throws SQLException {
    String query="SELECT sum(TIMESTAMPDIFF(HOUR, start_time, end_time)) AS total_hours FROM doctor_shift WHERE staff_id = 2 AND day='"+Tuesday+"';";
    resultSet= JDBCReusableMethods.getStatement().executeQuery(query);
    resultSet.next();


    }
    @Then("the query result should be match based on total_hours")
    public void the_query_result_should_be_match_based_on_total_hours() throws SQLException {

        int actualHours=resultSet.getInt(1);
        int expectedHours=2;
        Assert.assertEquals(expectedHours,actualHours);

    }



}
