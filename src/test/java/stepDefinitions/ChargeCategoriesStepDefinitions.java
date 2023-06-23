package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static utilities.JDBCReusableMethods.getStatement;

public class ChargeCategoriesStepDefinitions {

    Statement statement;
    ResultSet resultSet;
    List<Integer>idList=new ArrayList<>();
    @Then("query is done without repetition according to the starting name with {string}")
    public void query_is_done_without_repetition_according_to_the_starting_name_with(String letter) throws SQLException {
        String query="select distinct charge_type_id from charge_categories where name like '"+letter+"';";
        resultSet=getStatement().executeQuery(query);
        while (resultSet.next()){
            idList.add(resultSet.getInt("charge_type_id"));
        }
        System.out.println(idList);
    }
    @Then("the query result should match the following {int}")
    public void the_query_result_should_match_the_following(Integer id) {
       Assert.assertTrue(idList.contains(id));
    }

}
