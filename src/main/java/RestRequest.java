import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class RestRequest {
    private static final String baseUri = "https://restful-booker.herokuapp.com";

    public static String auth(String body) {

        return RestAssured.given()
                .baseUri(baseUri)
                .basePath("/auth")
                .body(body)
                .log()
                .body()
                .contentType(ContentType.JSON)
                .post()
                .then()
                .log()
                .body()
                .statusCode(200)
                .extract()
                .response()
                .jsonPath()
                .get("token");
    }

    public static Integer createBooking(String body) {

        return RestAssured.given()
                .baseUri(baseUri)
                .basePath("/booking")
                .body(body)
                .log()
                .body()
                .contentType(ContentType.JSON)
                .post()
                .then()
                .log()
                .body()
                .extract()
                .response()
                .jsonPath()
                .get("bookingid");
    }

    public static void createBookingNegative (String body) {

         RestAssured.given()
                .baseUri(baseUri)
                .basePath("/booking")
                .body(body)
                .log()
                .body()
                .contentType(ContentType.JSON)
                .post()
                .then()
                .log()
                .body()
                .extract()
                .response();
    }

    public static void getBooking(Integer bookingId) {

        RestAssured.given()
                .baseUri(baseUri)
                .basePath("/booking/" + bookingId)
                .contentType(ContentType.JSON)
                .get()
                .then()
                .log()
                .body()
                .extract()
                .response();
    }

    public static void updateBooking(String body, Integer bookingId, String token) {
        RestAssured.given()
                .baseUri(baseUri)
                .basePath("/booking/" + bookingId)
                .body(body)
                .log()
                .body()
                .contentType(ContentType.JSON)
                .header("Cookie", "token=" + token)
                .put()
                .then()
                .log()
                .body()
                .extract()
                .response();
    }

    public static void deleteBooking(Integer bookingId, String token) {

        RestAssured.given()
                .baseUri(baseUri)
                .basePath("/booking/" + bookingId)
                .contentType(ContentType.JSON)
                .header("Cookie", "token=" + token)
                .delete()
                .then()
                .log()
                .body()
                .extract()
                .response();
    }
}

