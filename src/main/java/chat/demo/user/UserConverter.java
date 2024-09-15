package chat.demo.user;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserConverter {

    public UserResponse convert(User from) {
        return new UserResponse(from.getNickName(), from.getFullName(), from.getStatus());
    }

    public List<UserResponse> convert(List<User> fromList) {
        return fromList.stream().map(from -> new UserResponse(
                        from.getNickName(),
                        from.getFullName(),
                        from.getStatus()))
                .toList();
    }
}
