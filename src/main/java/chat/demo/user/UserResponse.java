package chat.demo.user;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public record UserResponse(
        String nickName,
        String fullName,
        Status status
) {
}
