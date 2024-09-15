package chat.demo.chatroom;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatRoomService {

    private final ChatRoomRepository repository;
    private final ChatRoomRepository chatRoomRepository;

    public Optional<String> getChatRoomId(String senderId,String recipientId,Boolean createNewRoomIfNotExist){

        return repository.findBySenderIdAndRecipientId(senderId,recipientId)
                .map(ChatRoom::getChatId)
                .or(() -> {
                    if (createNewRoomIfNotExist){
                        String chatid = createChat(senderId,recipientId);
                        return Optional.of(chatid);
                    }
                    return Optional.empty();
                });
    }

    private String createChat(String senderId, String recipientId) {
        String chatId = String.format("%s_%s", senderId,recipientId); // ahmet_ali
        ChatRoom senderRecipient = ChatRoom.builder()
                .chatId(chatId)
                .senderId(senderId)
                .recipientId(recipientId)
                .build();
        ChatRoom recipientSender = ChatRoom.builder()
                .chatId(chatId)
                .senderId(recipientId)
                .recipientId(senderId)
                .build();
        chatRoomRepository.save(senderRecipient);
        chatRoomRepository.save(recipientSender);
        return chatId;
    }
}
