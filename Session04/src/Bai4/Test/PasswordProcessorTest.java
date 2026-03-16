package Bai4.Test;

import Bai4.Main.PasswordProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordProcessorTest {

    PasswordProcessor processor;

    @BeforeEach
    void setUp(){
        processor = new PasswordProcessor();
    }

    @Test
    void testStrongPassword(){
        String result = processor.evaluatePasswordStrength("Abc123!@");

        assertEquals("Mạnh", result);
    }

    @Test
    void testMediumPasswords(){

        assertAll("Medium password cases",

                () -> assertEquals("Trung bình",
                        processor.evaluatePasswordStrength("abc123!@")),

                () -> assertEquals("Trung bình",
                        processor.evaluatePasswordStrength("ABC123!@")),

                () -> assertEquals("Trung bình",
                        processor.evaluatePasswordStrength("Abcdef!@")),

                () -> assertEquals("Trung bình",
                        processor.evaluatePasswordStrength("Abc12345"))
        );
    }

    @Test
    void testWeakPasswords(){

        assertAll("Weak password cases",

                () -> assertEquals("Yếu",
                        processor.evaluatePasswordStrength("Ab1!")),

                () -> assertEquals("Yếu",
                        processor.evaluatePasswordStrength("password")),

                () -> assertEquals("Yếu",
                        processor.evaluatePasswordStrength("ABC12345"))
        );
    }
}
