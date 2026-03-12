package Bai3.Test;

import Bai3.Main.UserProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserProcessorTest {

    UserProcessor processor;


    @BeforeEach
    void setUp() {
        processor = new UserProcessor();
    }

    @Test
    void testValidEmail_ReturnsSameEmail() {
        String result = processor.processEmail("user@gmail.com");

        assertEquals("user@gmail.com", result);
    }


    @Test
    void testEmailWithoutAtSymbol_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            processor.processEmail("usergmail.com");
        });
    }

    // Email có @ nhưng không có domain
    @Test
    void testEmailWithoutDomain_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            processor.processEmail("user@");
        });
    }


    @Test
    void testEmailNormalization_ToLowerCase() {
        String result = processor.processEmail("Example@Gmail.com");

        assertEquals("example@gmail.com", result);
    }
}