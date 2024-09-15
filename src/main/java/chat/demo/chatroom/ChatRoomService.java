package chat.demo.chatroom;

import chat.demo.user.User;
import chat.demo.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatRoomService {

    private final ChatRoomRepository repository;
    private final ChatRoomRepository chatRoomRepository;
    private final UserService userService;

    public Optional<String> getChatRoomId(String senderId,String recipientId,Boolean createNewRoomIfNotExist){

        Optional<ChatRoom> bySenderNickNameAndRecipientNickName = repository.findBySender_NickNameAndRecipient_NickName(senderId, recipientId);
        return bySenderNickNameAndRecipientNickName
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
        User sender = userService.findById(senderId);
        User recipient = userService.findById(recipientId);

        String chatId = String.format("%s_%s", senderId,recipientId); // ahmet_ali
        ChatRoom senderRecipient = ChatRoom.builder()
                .chatId(chatId)
                .sender(sender)
                .recipient(recipient)
                .build();
        ChatRoom recipientSender = ChatRoom.builder()
                .chatId(chatId)
                .sender(recipient)
                .recipient(sender)
                .build();
        chatRoomRepository.save(senderRecipient);
        chatRoomRepository.save(recipientSender);
        return chatId;
    }
}
