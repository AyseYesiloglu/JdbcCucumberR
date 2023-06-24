package stepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.JDBCReusableMethods;
import utilities.Manage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static utilities.JDBCReusableMethods.getStatement;

public class VehicleTableStepDefinition {
    Statement statement;
    ResultSet resultSet;
    ResultSet resultSet1;
    Manage manage=new Manage();
    List<Object>createdList=new ArrayList<>();
    List<Object>manufacturedList=new ArrayList<>();
    @Then("Create two query one with in ascending order of manufacture_year and one with ascending order of created_at")
    public void create_two_query_one_with_in_ascending_order_of_manufacture_year_and_one_with_ascending_order_of_created_at() throws SQLException {
        resultSet=getStatement().executeQuery(manage.getVehicleTableAccordManufactureAtQuery());
        while (resultSet.next()) {
            createdList.add(resultSet.getString("vehicle_model"));
        }
        resultSet1=getStatement().executeQuery(manage.getVehicleTableAccordCreateAtQuery());
        while (resultSet1.next()) {
            manufacturedList.add(resultSet1.getString("vehicle_model"));
        }
        System.out.println(createdList);
        System.out.println(manufacturedList);
    }
    @Then("Cross check the queries and find the vehicle with common index on both")
    public void cross_check_the_queries_and_find_the_vehicle_with_common_index_on_both() {
        String actualValue="";
        for (int i = 0; i <createdList.size() ; i++) {
            if (createdList.get(i).equals(manufacturedList.get(i))){
                actualValue= createdList.get(i).toString();
            }
            System.out.println(actualValue);
        }
        String expectedValue="tesla";
        Assert.assertEquals(expectedValue,actualValue);

    }
}