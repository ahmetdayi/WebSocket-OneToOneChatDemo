package chat.demo.chat;

import chat.demo.user.UserConverter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChatMessageConverter {

    private final UserConverter userConverter;

    public ChatMessageConverter(UserConverter userConverter) {
        this.userConverter = userConverter;
    }

    public ChatMessageResponse convert(ChatMessage from) {
        return new ChatMessageResponse(
                from.getId(),
                from.getChatId(),
                userConverter.convert(from.getSender()),
                userConverter.convert(from.getRecipient()),
                from.getContent(),
                from.getTimestamp());
    }

    public List<ChatMessageResponse> convert(List<ChatMessage> fromList) {
        return fromList.stream().map(from -> new ChatMessageResponse(
                from.getId(),
                from.getChatId(),
                userConverter.convert(from.getSender()),
                userConverter.convert(from.getRecipient()),
                from.getContent(),
                from.getTimestamp())).toList();
    }
}
