package Bai1.Test;

import Bai1.Main.UserValidator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserValidatorTest {

    @Test
    void testValidUsername_TC01() {
        // Arrange
        String username = "user123";

        // Act
        boolean result = UserValidator.isValidUsername(username);

        // Assert
        assertTrue(result);
    }

    @Test
    void testTooShortUsername_TC02() {
        // Arrange
        String username = "abc";

        // Act
        boolean result = UserValidator.isValidUsername(username);

        // Assert
        assertFalse(result);
    }

    @Test
    void testUsernameWithSpace_TC03() {
        // Arrange
        String username = "user name";

        // Act
        boolean result = UserValidator.isValidUsername(username);

        // Assert
        assertFalse(result);
    }
}