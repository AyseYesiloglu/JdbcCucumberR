package stepDefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.JDBCReusableMethods;
import utilities.Manage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DischargeCardTableStepDefinition {
    Timestamp timestamp;
    Timestamp timestamp1;
    Timestamp timestamp2;
    ResultSet resultSet;
    Manage manage = new Manage();
    List<Object> actualCreatedAtList = new ArrayList<>();

    @Then("query is done according to the opd_details_id")
    public void query_is_done_according_to_the_opd_details_id() throws SQLException {
        resultSet = JDBCReusableMethods.getStatement().executeQuery(manage.getDischargeCardCreatedAtQuery());
        while (resultSet.next()) {
            timestamp = resultSet.getTimestamp("created_at");
            actualCreatedAtList.add(timestamp);
        }
        System.out.println(actualCreatedAtList);
    }

    @Then("the query result should be match based on created_at")
    public void the_query_result_should_be_match_based_on_created_at() {
        timestamp1=Timestamp.valueOf("2021-10-28 04:48:56");
        timestamp2=Timestamp.valueOf("2023-05-03 13:34:59");
        List<Object> expectedCreatedAtList = new ArrayList<>(Arrays.asList(timestamp1,timestamp2));
        System.out.println(expectedCreatedAtList);
        Assert.assertEquals(expectedCreatedAtList,actualCreatedAtList);


    }


}
