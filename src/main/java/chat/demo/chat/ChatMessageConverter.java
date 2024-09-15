package chat.demo.chat;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChatMessageConverter {

    public ChatMessageResponse convert(ChatMessage from) {
        return new ChatMessageResponse(
                from.getId(),
                from.getChatId(),
                from.getSender(),
                from.getRecipient(),
                from.getContent(),
                from.getTimestamp());
    }

    public List<ChatMessageResponse> convert(List<ChatMessage> fromList) {
        return fromList.stream().map(from -> new ChatMessageResponse(
                from.getId(),
                from.getChatId(),
                from.getSender(),
                from.getRecipient(),
                from.getContent(),
                from.getTimestamp())).toList();
    }
}
