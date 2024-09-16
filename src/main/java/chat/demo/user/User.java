package chat.demo.user;

import chat.demo.chat.ChatMessage;
import chat.demo.chatroom.ChatRoom;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String firstname;

    private String lastname;

    private String universityEmail;

    private String description;

    private Status status;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Role role = Role.USER;
    @Builder.Default
    private Boolean verified = Boolean.FALSE;

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
