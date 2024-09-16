package chat.demo.user;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public record UserResponse(
        String id,
        String firstname,
        String lastname,
        String universityEmail,
        String description,
        Role role,
        Boolean verified,
        Status status
) {
}
