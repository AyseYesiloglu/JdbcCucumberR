package stepDefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.JDBCReusableMethods;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MedicineSuplierTableStepDefinition {
    ResultSet resultSet;
    Timestamp timestamp;
    List<Object> actualList = new ArrayList<>();
    List<Object> expectedList;
    List<Object>resultsetList;

    @Then("query is created according to given adress is {string}")
    public void query_is_created_according_to_given_adress_is(String address) throws SQLException {
        String query = "select * from heallife_hospitaltraining.medicine_supplier where address='" + address + "';";
        resultSet = JDBCReusableMethods.getStatement().executeQuery(query);

        while (resultSet.next()) {
            //id /supplier/contact/supplier_person/supplier_person_contact/supplier_drug_licence/address/created_at
            int id = resultSet.getInt("id");
            String supplier = resultSet.getString("supplier");
            String contact = resultSet.getString("contact");
            String supplierPerson = resultSet.getString("supplier_person");
            String supplierPersonContact = resultSet.getString("supplier_person_contact");
            String supplierDrugLicence = resultSet.getString("supplier_drug_licence");
            String address1 = resultSet.getString("address");
            Timestamp timestamp1= resultSet.getTimestamp("created_at");
            resultsetList=new ArrayList<>(Arrays.asList(id,supplier,contact,supplierPerson,supplierPersonContact,supplierDrugLicence,address1,timestamp1));
            actualList.add(resultsetList);
        }
        System.out.println(actualList);
        timestamp = Timestamp.valueOf("2021-10-25 03:09:11");
        //[3,VKS Pharmacy,7546985214,Vinay Shrivastava,9754632587,DFDR555--000,Andheri, Mumbai,2021-10-25 03:09:11.0]
        expectedList = new ArrayList<>(Arrays.asList(3,"VKS Pharmacy","7546985214","Vinay Shrivastava","9754632587","DFDR555--000","Andheri, Mumbai",timestamp));
        System.out.println(expectedList);

    }
    @Then("the query result should be match based on knowledge")
    public void the_query_result_should_be_match_based_on_knowledge() {
        Assert.assertTrue(actualList.contains(expectedList));

    }

}
