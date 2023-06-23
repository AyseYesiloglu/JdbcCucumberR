package utilities;

public class Manage {

  private String querySabah = "SELECT count(*) FROM heallife_hospitaltraining.appointment WHERE HOUR(time) < 12";
  private String queryAksam = "SELECT count(*) FROM heallife_hospitaltraining.appointment WHERE HOUR(time) > 12";

  private String languagesQuery= "Select language From heallife_hospitaltraining.languages Where short_code = 'yi'";

  private String appointmentPaymentQuery="select id from heallife_hospitaltraining.appointment_payment where payment_type='Offline';";

    private  String queryAppointmentStatus = "SELECT appointment_status FROM heallife_hospitaltraining.appointment WHERE patient_id = 20";

    private String bedTableIsActiveQuery="select is_active from heallife_hospitaltraining.bed where created_at='2021-10-25 03:34:25';";

    private String bedTableNameQuery= "SELECT name FROM heallife_hospitaltraining.bed WHERE bed_group_id = 4 AND is_active = 'no';";
    public String getQuerySabah() {

        return querySabah;
    }

    public String getQueryAksam() {

        return queryAksam;
    }

    public String getLanguagesQuery() {

        return languagesQuery;
    }

    public String getAppointmentPaymentQuery() {
        return appointmentPaymentQuery;
    }

    public String getQueryAppointmentStatus() {
        return queryAppointmentStatus;
    }

    public String getBedTableIsActiveQuery() {
        return bedTableIsActiveQuery;
    }

    public String getBedTableNameQuery() {
        return bedTableNameQuery;
    }
}
