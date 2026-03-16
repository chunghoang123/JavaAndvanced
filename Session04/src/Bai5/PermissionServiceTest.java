package Bai5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PermissionServiceTest {

    PermissionService service = new PermissionService();

    @Test
    void adminDeleteUser() {
        assertTrue(service.canPerformAction(new User(Role.ADMIN), Action.DELETE_USER));
    }

    @Test
    void moderatorDeleteUser() {
        assertFalse(service.canPerformAction(new User(Role.MODERATOR), Action.DELETE_USER));
    }

    @Test
    void userViewProfile() {
        assertTrue(service.canPerformAction(new User(Role.USER), Action.VIEW_PROFILE));
    }

    @Test
    void userDeleteUser() {
        assertFalse(service.canPerformAction(new User(Role.USER), Action.DELETE_USER));
    }
}