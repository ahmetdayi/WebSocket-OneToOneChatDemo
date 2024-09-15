package chat.demo.chat;

import chat.demo.chatroom.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatMessageService {

    private final ChatMessageRepository repository;
    private final ChatRoomService chatRoomService;
    private final ChatMessageConverter chatMessageConverter;

    public ChatMessageResponse save(ChatMessage chatMessage) {
        String chatId = chatRoomService.getChatRoomId(
                        chatMessage.getSender().getNickName(),
                        chatMessage.getRecipient().getNickName(),
                        true)
                .orElseThrow();//TODO hata don
        chatMessage.setChatId(chatId);
        repository.save(chatMessage);
        return chatMessageConverter.convert(chatMessage);
    }
    public List<ChatMessageResponse> findChatMessage(String senderId,String recipientId){

        Optional<String> chatId = chatRoomService.getChatRoomId(senderId,recipientId,false);
        Optional<List<ChatMessage>> chatMessages = chatId.map(repository::findByChatId);
        return chatMessageConverter.convert(chatMessages.orElse(new ArrayList<>()));
    }
}
