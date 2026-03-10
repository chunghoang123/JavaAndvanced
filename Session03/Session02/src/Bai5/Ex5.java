package Bai5;

interface UserActions {
    default void logActivity(String activity) {
        System.out.println("User action: " + activity);
    }
}

interface AdminActions {
    default void logActivity(String activity) {
        System.out.println("Admin action: " + activity);
    }
}

class SuperAdmin implements UserActions, AdminActions {

    // bắt buộc override để giải quyết Diamond Problem
    @Override
    public void logActivity(String activity) {
        System.out.println("SuperAdmin action: " + activity);
    }
}

public class Ex5 {
    public static void main(String[] args) {

        SuperAdmin superadmin = new SuperAdmin();

        superadmin.logActivity("Delete user");
    }
}
