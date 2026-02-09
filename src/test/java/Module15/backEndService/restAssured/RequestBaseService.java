package Module15.backEndService.restAssured;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static java.util.Objects.isNull;

@Slf4j
public class RequestBaseService {

    public Response post(String methods, String request) {
        log.info("МЕТОД POST: {}", methods);
        System.out.println("REQUEST: " + request);
        Response rs = given()
                .contentType(ContentType.JSON)
                .body(request)
                .when()
                .post(methods)
                .then()
                .assertThat().statusCode(200)
                .extract()
                .response();
        System.out.println("RESPONSE: " + rs.asString());
        return rs;
    }

    public Response update(String methods, String request, String token) {
        log.info("МЕТОД PUT: {}", methods);
        System.out.println("REQUEST: " + request);
        Response rs = given()
                .header("Cookie", "token=" + token)
                .contentType(ContentType.JSON)
                .body(request)
                .when()
                .put(methods)
                .then()
                .assertThat().statusCode(200)
                .extract()
                .response();
        System.out.println("RESPONSE: " + rs.asString());
        return rs;
    }

    public Response get(String methods) {
        log.info("МЕТОД GET: {}", methods);
        Response rs = given()
                .contentType(ContentType.JSON)
                .get(methods)
                .then()
                .statusCode(200)
                .extract()
                .response();
        System.out.println("RESPONSE: " + rs.asString());
        return rs;
    }

    public Response delete(String methods, String token) {
        log.info("МЕТОД DELETE: {}", methods);
        Response rs = given()
                .header("Cookie", "token=" + token)
                .contentType(ContentType.JSON)
                .when()
                .delete(methods)
                .then()
                .assertThat().statusCode(201)
                .extract()
                .response();
        System.out.println("RESPONSE: " + rs.asString());
        return rs;
    }

    public <T> void validateResponseMap(Map<String, T> responseMap) {
        if (responseMap.isEmpty()) {
            throw new RuntimeException("Не заполнен ожидаемый ответ запроса");
        }
        for (var entry : responseMap.entrySet()) {
            if (isNull(entry.getValue())) {
                throw new RuntimeException(String.format("Для key=%s не получено значение", entry.getKey()));
            }

            log.info("Установлен параметр key = {}: value = {}", entry.getKey(), entry.getValue());
        }
    }
}