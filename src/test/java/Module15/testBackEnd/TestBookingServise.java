package Module15.testBackEnd;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import Module15.backEndService.service.BookingService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static Module15.variable.Variable.ID;

@Slf4j
public class TestBookingServise {

    BookingService bookingService = new BookingService();

    @Test
    @Step("Создать книгу, достать, обновить, удалить")
    @DisplayName("Создать книгу, достать, обновить, удалить")
    public void testAllMethodsBookingServise() {
        log.info("Старт процесса создания книги!");
        Map<String, String> mapCreateBooking = bookingService.createBooking(bookingService.requestValidCreateBooking());
        String bookingId = mapCreateBooking.get(ID);
        log.info("Книга создана ID: {}", bookingId);

        log.info("Достаем созданную книгу: {}", bookingId);
        Map<String, String> mapGetBooking = bookingService.getBooking(bookingId);
        log.info("Сущность Созданной книги: {}", mapGetBooking.toString());

        log.info("Обновить созданную книгу: {}", bookingId);
        Map<String, String> mapUpdateBooking = bookingService.updateBooking(
                bookingId,
                bookingService.requestValidUpdateBooking());
        log.info("Книга обновлена: {}", mapUpdateBooking.toString());

        log.info("Удалить книгу: {}", bookingId);
        Map<String, String> mapDeleteBooking = bookingService.deleteBooking(bookingId);
        log.info("Книга удалена: {}", mapDeleteBooking.toString());
    }

    @Test
    @Step("Создание книги")
    @DisplayName("Создание книги")
    public void testCreateBooking() {
        Map<String, String> map = bookingService.createBooking(bookingService.requestValidCreateBooking());
        Object bookingId = map.get(ID);
        System.out.println("bookikngId: " + bookingId);
    }

    @Test
    @Step("Обновление книги")
    @DisplayName("Обновление книги")
    public void testUpdateBooking() {
        Map<String, String> mapCreateBooking = bookingService.createBooking(bookingService.requestValidCreateBooking());
        String bookingId = mapCreateBooking.get(ID);
        Map<String, String> map = bookingService.updateBooking(bookingId, bookingService.requestValidUpdateBooking());
    }

    @Test
    @Step("Достать созданную книгу")
    @DisplayName("Достать созданную книгу")
    public void testGetBooking() {
        Map<String, String> mapCreateBooking = bookingService.createBooking(bookingService.requestValidCreateBooking());
        String bookingId = mapCreateBooking.get(ID);
        Map<String, String> map = bookingService.getBooking(bookingId);
    }

    @Test
    @Step("Удалить книгу")
    @DisplayName("Удалить книгу")
    public void testDeleteBooking() {
        Map<String, String> mapCreateBooking = bookingService.createBooking(bookingService.requestValidCreateBooking());
        String bookingId = mapCreateBooking.get(ID);
        Map<String, String> map = bookingService.deleteBooking(bookingId);
    }


}
