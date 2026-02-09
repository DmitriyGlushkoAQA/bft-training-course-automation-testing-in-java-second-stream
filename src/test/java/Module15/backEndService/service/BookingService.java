package Module15.backEndService.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import Module15.backEndService.restAssured.RequestBaseService;
import Module15.variable.EnumQueryBooking;
import Module15.variable.QueryBooking;

import java.util.Map;

import static Module15.variable.Variable.ALL_RESPONSE;
import static Module15.variable.Variable.ID;

@Slf4j
public class BookingService extends RequestBaseService {

    ObjectMapper mapper = new ObjectMapper();
    QueryBooking queryBooking = new QueryBooking();
    QueryBooking.BookingDates bookingDates = new QueryBooking.BookingDates();

    String baseUrl = "https://restful-booker.herokuapp.com";
    String methodsBooking = "/booking";
    String auth = "/auth";

    @Step("Авторизация, получения токена")
    private String getTokenAuthBookingService() {
        log.info("Авторизация, получения токена");
        String methods = baseUrl + auth;
        String request = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        Response rs = post(methods, request);

        String tokenId = null;
        try {
            tokenId = rs.jsonPath().getString("token");
        } catch (NullPointerException e) {
            log.error("Ошибка получения токена: tokenId пустой");
            e.printStackTrace();
        }

        log.info("Токен получен: {}", tokenId);
        Allure.addAttachment("Токен получен: ", tokenId);
        return tokenId;
    }

    @Step("Создать Книгу")
    public Map<String, String> createBooking(String request) {

        String methods = baseUrl + methodsBooking;

        Response rs = post(methods, request);

        Map<String, String> mapCreateBooking = Map.of(
                ID, rs.jsonPath().getString("bookingid")
        );
        validateResponseMap(mapCreateBooking);
        Allure.addAttachment("Книга создана: ", mapCreateBooking.get(ID));
        return mapCreateBooking;
    }

    @Step("Обновить книгу")
    public Map<String, String> updateBooking(String id, String request) {

        String token = getTokenAuthBookingService();

        String methods = baseUrl + methodsBooking + "/" + id;

        Response rs = update(methods, request, token);

        Map<String, String> mapUpdateBooking = Map.of(
                ALL_RESPONSE, rs.asString()
        );
        validateResponseMap(mapUpdateBooking);
        Allure.addAttachment("Книга " + id + " обновлена ", mapUpdateBooking.get(ALL_RESPONSE));
        return mapUpdateBooking;
    }

    @Step("Достать Книгу")
    public Map<String, String> getBooking(Object id) {

        String methods = baseUrl + methodsBooking + "/" + id;

        Response rs = get(methods);

        Map<String, String> mapGetBooking = Map.of(
                ALL_RESPONSE, rs.asString()
        );
        validateResponseMap(mapGetBooking);
        Allure.addAttachment("Книга " + id + " возвращена ", mapGetBooking.get(ALL_RESPONSE));
        return mapGetBooking;
    }

    @Step("Удалить Книгу")
    public Map<String, String> deleteBooking(String id) {

        String token = getTokenAuthBookingService();

        String methods = baseUrl + methodsBooking + "/" + id;

        Response rs = delete(methods, token);

        Map<String, String> mapDeleteBooking = Map.of(
                ALL_RESPONSE, rs.asString()
        );
        validateResponseMap(mapDeleteBooking);
        Allure.addAttachment("Книга " + id + " удалена ", mapDeleteBooking.get(ALL_RESPONSE));
        return mapDeleteBooking;
    }


    @Step("Вернуть валидный json для создания книги")
    public String requestValidCreateBooking() {
        try {
            queryBooking.setFirstname(EnumQueryBooking.VALID_DATA.getFirstname());
            queryBooking.setLastname(EnumQueryBooking.VALID_DATA.getLastname());
            queryBooking.setTotalprice(EnumQueryBooking.VALID_DATA.getTotalprice());
            queryBooking.setDepositpaid(EnumQueryBooking.VALID_DATA.isDepositpaid());
            queryBooking.setDepositpaid(EnumQueryBooking.VALID_DATA.isDepositpaid());
            bookingDates.setCheckin(EnumQueryBooking.VALID_DATA.getCheckin());
            bookingDates.setCheckout(EnumQueryBooking.VALID_DATA.getCheckout());
            queryBooking.setBookingdates(bookingDates);
            queryBooking.setAdditionalneeds(EnumQueryBooking.VALID_DATA.getAdditionalneeds());
            return mapper.writeValueAsString(queryBooking);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Step("Вернуть валидный json для Обновления книги")
    public String requestValidUpdateBooking() {
        try {
            queryBooking.setFirstname(EnumQueryBooking.VALID_DATA_2.getFirstname());
            queryBooking.setLastname(EnumQueryBooking.VALID_DATA_2.getLastname());
            queryBooking.setTotalprice(EnumQueryBooking.VALID_DATA_2.getTotalprice());
            queryBooking.setDepositpaid(EnumQueryBooking.VALID_DATA_2.isDepositpaid());
            queryBooking.setDepositpaid(EnumQueryBooking.VALID_DATA_2.isDepositpaid());
            bookingDates.setCheckin(EnumQueryBooking.VALID_DATA_2.getCheckin());
            bookingDates.setCheckout(EnumQueryBooking.VALID_DATA_2.getCheckout());
            queryBooking.setBookingdates(bookingDates);
            queryBooking.setAdditionalneeds(EnumQueryBooking.VALID_DATA_2.getAdditionalneeds());
            return mapper.writeValueAsString(queryBooking);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}