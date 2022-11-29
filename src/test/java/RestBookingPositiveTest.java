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
    public void auth() {
        BookingApiPositiveSteps.auth(authBody);
    }

    @Test
    public void createAndGetBooking() {
        Integer bookingId = BookingApiPositiveSteps.createBooking(createBookingBody);
        BookingApiPositiveSteps.getBooking(bookingId);
    }

    @Test
    public void createAndUpdateAndGetBooking() {
        Integer bookingId = BookingApiPositiveSteps.createBooking(createBookingBody);
        String token = BookingApiPositiveSteps.auth(authBody);
        BookingApiPositiveSteps.updateBooking(updateBookingBody, bookingId, token);
        BookingApiPositiveSteps.getBooking(bookingId);
    }

    @Test
    public void createAndDeleteAndGetBooking() {
        Integer bookingId = BookingApiPositiveSteps.createBooking(createBookingBody);
        String token = BookingApiPositiveSteps.auth(authBody);
        BookingApiPositiveSteps.deleteBooking(bookingId, token);
    }
}
