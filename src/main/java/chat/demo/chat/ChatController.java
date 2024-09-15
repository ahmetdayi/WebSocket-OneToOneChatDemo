package chat.demo.chat;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;
    private final ChatMessageService chatMessageService;

    @MessageMapping("/chat")
     public void processMessage(
             @Payload ChatMessage chatMessage
     ){
         ChatMessage savedMessage = chatMessageService.save(chatMessage);
         // /jhon/queue/messages
         messagingTemplate.convertAndSendToUser(
                 chatMessage.getRecipient().getNickName(),
                 "/queue/messages",
                 ChatNotification.builder()
                         .id(savedMessage.getId())
                         .senderId(savedMessage.getSender().getNickName())
                         .recipientId(savedMessage.getRecipient().getNickName())
                         .content(savedMessage.getContent())
                         .build()
         );
     }

    @GetMapping("/messages/{senderId}/{recipientId}")
    public ResponseEntity<List<ChatMessage>> findChatMessages(
            @PathVariable("senderId") String senderId,
            @PathVariable("recipientId") String recipientId
    ){
        System.out.println(chatMessageService.findChatMessage(senderId, recipientId));
        return ResponseEntity.ok(chatMessageService.findChatMessage(senderId, recipientId));
    }
}
