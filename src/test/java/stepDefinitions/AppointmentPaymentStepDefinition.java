package stepDefinitions;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import utilities.Manage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static utilities.JDBCReusableMethods.getStatement;

public class AppointmentPaymentStepDefinition {

    Statement statement;
    ResultSet resultSet;
    Manage manage=new Manage();


    @Given("Appointment Payment tablosuna query gönderilir ve sonuclar dogrulanir.")
    public void appointment_payment_tablosuna_query_gönderilir_ve_sonuclar_dogrulanir() throws SQLException {

        resultSet=getStatement().executeQuery(manage.getAppointmentPaymentQuery());

        List<Integer> appointmentPaymentList=new ArrayList<>();

        while( resultSet.next()){
            appointmentPaymentList.add(resultSet.getInt("id") );

        }

        System.out.println(appointmentPaymentList);
        List<Integer> expectedList = Arrays.asList(1,2,3,13,14,15,17,18,20,21,25);
        Assert.assertEquals(expectedList,appointmentPaymentList);


    }

}
