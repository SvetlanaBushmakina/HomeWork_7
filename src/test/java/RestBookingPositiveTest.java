import org.junit.Test;

public class RestBookingPositiveTest {
    String authBody = "{\n" +
            "    \"username\" : \"admin\",\n" +
            "    \"password\" : \"password123\"\n" +
            "}";
    String createBookingBody = "{\n" +
            "    \"firstname\" : \"Svetlana\",\n" +
            "    \"lastname\" : \"Bushmakina\",\n" +
            "    \"totalprice\" : 1000,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2022-12-01\",\n" +
            "        \"checkout\" : \"2023-01-01\"\n" +
            "    }\n" +
            "}";
    String updateBookingBody = "{\n" +
            "    \"firstname\" : \"Svetlana\",\n" +
            "    \"lastname\" : \"Bushmakina\",\n" +
            "    \"totalprice\" : 1000,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2022-12-01\",\n" +
            "        \"checkout\" : \"2023-01-02\"\n" +
            "    }\n" +
            "}";

    @Test
    public void authTest() {
        RestRequest.auth(authBody);
    }

    @Test
    public void createBooking() {
        Integer bookingId = RestRequest.createBooking(createBookingBody);
        RestRequest.getBooking(bookingId);
    }

    @Test
    public void updateBooking (){
        Integer bookingId = RestRequest.createBooking(createBookingBody);
        String token = RestRequest.auth(authBody);
        RestRequest.updateBooking(updateBookingBody,bookingId, token);
        RestRequest.getBooking(bookingId);
    }

    @Test
    public void deleteBooking() {
        Integer bookingId = RestRequest.createBooking(createBookingBody);
        String token = RestRequest.auth(authBody);
        RestRequest.deleteBooking(bookingId,token);
        RestRequest.getBooking(bookingId);
    }
}
