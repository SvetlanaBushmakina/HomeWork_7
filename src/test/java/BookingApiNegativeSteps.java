import io.restassured.response.Response;
import org.junit.Assert;

public class BookingApiNegativeSteps {
    public static void auth(String authBody) {
        Response response = RestRequest.auth(authBody);
        String reason = response.jsonPath().get("reason");
        Assert.assertEquals(200, response.statusCode());
        Assert.assertNotNull(reason);
        System.out.println("Не удалось авторизоваться по причине: " + reason);
    }

    public static void createBooking(String createBookingBody) {
        Response response = RestRequest.createBooking(createBookingBody);
        Assert.assertEquals(500, response.statusCode());
        System.out.println("Некорректный запрос");
    }

    public static void getBooking(Integer bookingId) {
        Response response = RestRequest.getBooking(bookingId);
        Assert.assertEquals(404, response.statusCode());
        System.out.println("Бронирование с ID: " + bookingId + " не найдено");
    }

    public static void deleteBooking(Integer bookingId, String token){
        Response response = RestRequest.deleteBooking(1, token);
        Assert.assertEquals(405, response.statusCode());
        System.out.println("Невозможно удалить бронирование с ID: " + 1);
    }
}
