package Bai6;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class ProfileServiceTest {

    ProfileService service = new ProfileService();

    @Test
    void testValidUpdate() {

        UserProfile user = new UserProfile("a@gmail.com", LocalDate.of(2000,1,1));
        UserProfile newData = new UserProfile("b@gmail.com", LocalDate.of(2000,1,1));

        List<UserProfile> users = new ArrayList<>();
        users.add(user);

        UserProfile result = service.updateProfile(user, newData, users);

        assertNotNull(result);
    }

    @Test
    void testFutureBirthDate() {

        UserProfile user = new UserProfile("a@gmail.com", LocalDate.of(2000,1,1));
        UserProfile newData = new UserProfile("b@gmail.com", LocalDate.now().plusDays(1));

        List<UserProfile> users = new ArrayList<>();
        users.add(user);

        UserProfile result = service.updateProfile(user, newData, users);

        assertNull(result);
    }
}
