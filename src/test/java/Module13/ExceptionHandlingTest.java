package Module13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

public class ExceptionHandlingTest {

    @Test
    void exception() {
        try {
            System.out.println((String) null);
            Assertions.assertTrue(false);
        } catch (AssertionFailedError e) {
            e.printStackTrace();
        }
    }
}