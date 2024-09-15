package chat.demo.user;

import chat.demo.chat.ChatMessage;
import chat.demo.chatroom.ChatRoom;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class User {

    @Id
    private String nickName;

    private String fullName;

    @Enumerated(EnumType.STRING)
    private Status status;

//    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL)
//    private List<ChatRoom> sentChatRooms;
//
//    @OneToMany(mappedBy = "recipient", cascade = CascadeType.ALL)
//    private List<ChatRoom> receivedChatRooms;
//
//    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL)
//    private List<ChatMessage> sentMessages;
//
//    @OneToMany(mappedBy = "recipient", cascade = CascadeType.ALL)
//    private List<ChatMessage> receivedMessages;
}
