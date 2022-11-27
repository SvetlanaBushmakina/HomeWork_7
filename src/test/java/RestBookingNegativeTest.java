import org.junit.Test;

public class RestBookingNegativeTest {
    String authBody = "{\n" +
            "    \"username\" : \"admin\",\n" +
            "    \"password\" : \"qwerty123\"\n" +
            "}";
    String authBodyCorrect = "{\n" +
            "    \"username\" : \"admin\",\n" +
            "    \"password\" : \"password123\"\n" +
            "}";
    String createBookingBody = "{\n" +
            "    \"name\" : \"Svetlana\",\n" +
            "    \"lastname\" : \"Bushmakina\",\n" +
            "    \"totalprice\" : 1000,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2022-12-01\",\n" +
            "        \"checkout\" : \"2023-01-01\"\n" +
            "    }\n" +
            "}";

    @Test
    public void authTest() {
        RestRequest.auth(authBody);
    }

    @Test
    public void createBooking() {
        RestRequest.createBookingNegative(createBookingBody);
    }

    @Test
    public void getBooking (){
        RestRequest.getBooking(12);
    }

    @Test
    public void deleteBooking() {
        String token = RestRequest.auth(authBodyCorrect);
        RestRequest.deleteBooking(12,token);
    }
}
