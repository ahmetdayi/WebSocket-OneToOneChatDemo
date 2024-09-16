package chat.demo.chatroom;

import chat.demo.chat.ChatMessage;
import chat.demo.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ChatRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String chatId;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn
    private User sender;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn
    private User recipient;

//    @OneToMany(mappedBy = "chatRoom", cascade = CascadeType.ALL)
//    private List<ChatMessage> messages;
}
