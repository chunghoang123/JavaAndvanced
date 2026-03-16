package Bai6;

import java.time.LocalDate;
import java.util.List;

public class ProfileService {

    public UserProfile updateProfile(UserProfile existingUser,
                                     UserProfile newProfile,
                                     List<UserProfile> allUsers) {

        if (newProfile.getBirthDate().isAfter(LocalDate.now())) {
            return null;
        }

        for (UserProfile u : allUsers) {

            if (!u.equals(existingUser) &&
                    u.getEmail().equals(newProfile.getEmail())) {

                return null;
            }
        }

        existingUser.setEmail(newProfile.getEmail());
        existingUser.setBirthDate(newProfile.getBirthDate());

        return existingUser;
    }
}
