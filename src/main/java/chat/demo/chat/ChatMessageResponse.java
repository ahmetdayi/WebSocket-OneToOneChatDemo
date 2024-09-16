package chat.demo.chat;

import chat.demo.user.User;
import chat.demo.user.UserResponse;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Date;

public record ChatMessageResponse(

        String id,
        String chatId,
        UserResponse sender,
        UserResponse recipient,
        String content,
        Date timestamp
) {
}
