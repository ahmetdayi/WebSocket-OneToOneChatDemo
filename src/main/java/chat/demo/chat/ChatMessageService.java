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

    public ChatMessage save(ChatMessage chatMessage) {
        String chatId = chatRoomService.getChatRoomId(
                        chatMessage.getSenderId(),
                        chatMessage.getRecipientId(),
                        true)
                .orElseThrow();//TODO hata don
        chatMessage.setChatId(chatId);
        repository.save(chatMessage);
        return chatMessage;
    }
    public List<ChatMessage> findChatMessage(String senderId,String recipientId){

        Optional<String> chatId = chatRoomService.getChatRoomId(senderId,recipientId,false);
        return chatId.map(repository::findByChatId).orElse(new ArrayList<>());
    }
}
