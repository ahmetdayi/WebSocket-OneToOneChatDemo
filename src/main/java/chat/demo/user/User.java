package chat.demo.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

}
