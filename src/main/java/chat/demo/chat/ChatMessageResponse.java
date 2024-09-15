package chat.demo.chat;

import chat.demo.user.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Date;

public record ChatMessageResponse(

        String id,
        String chatId,
        User sender,
        User recipient,
        String content,
        Date timestamp
) {
}
