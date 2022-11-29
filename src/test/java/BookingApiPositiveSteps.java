import io.restassured.response.Response;
import org.junit.Assert;

public class BookingApiPositiveSteps {

    public static String auth(String authBody) {
        Response response = RestRequest.auth(authBody);
        String token = response.jsonPath().get("token");
        Assert.assertEquals(200, response.statusCode());
        Assert.assertNotNull(token);
        System.out.println("Токен авторизации: " + token);
        return token;
    }

    public static Integer createBooking(String createBookingBody) {
        Response response = RestRequest.createBooking(createBookingBody);
        Integer bookingId = response.jsonPath().get("bookingid");
        Assert.assertEquals(200, response.statusCode());
        Assert.assertNotNull(bookingId);
        System.out.println("ID бронирования: " + bookingId);
        return bookingId;
    }

    public static void getBooking(Integer bookingId) {
        Response response = RestRequest.getBooking(bookingId);
        Assert.assertEquals(200, response.statusCode());
        System.out.println("Получено бронирование: " + bookingId);
    }

    public static void updateBooking(String body, Integer bookingId, String token) {
        Response response = RestRequest.updateBooking(body, bookingId, token);
        Assert.assertEquals(200, response.statusCode());
        System.out.println("Обновлено бронирование: " + bookingId);
    }

    public static void deleteBooking(Integer bookingId, String token) {
        Response response = RestRequest.deleteBooking(bookingId, token);
        Assert.assertEquals(201, response.statusCode());
        System.out.println("Удалено бронирование: " + bookingId);

    }
}
