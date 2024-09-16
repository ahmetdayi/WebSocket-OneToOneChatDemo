package chat.demo.chatroom;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChatRoomRepository extends JpaRepository<ChatRoom,String> {
    Optional<ChatRoom> findBySender_IdAndRecipient_Id(String senderId, String recipientId);
}
