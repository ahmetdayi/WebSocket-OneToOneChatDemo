package chat.demo.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    public void saveUser(User user){
        user.setStatus(Status.ONLINE);
        userRepository.save(user);
    }
    public void disconnectUser(User user){
        Optional<User> storedUser = userRepository.findById(user.getId());
        if (storedUser.isPresent()){
            storedUser.get().setStatus(Status.OFFLINE);
            userRepository.save(storedUser.get());
        }
    }

    public List<UserResponse> findConnectedUser(){
        return userConverter.convert(userRepository.findAllByStatus(Status.ONLINE));
    }

    public User findById(String id){
        System.out.println(userRepository.findById(id));
        return userRepository.findById(id).orElseThrow();//TODO hata don
    }
    public UserResponse getById(String id){
        System.out.println(userRepository.findById(id));
        return userConverter.convert(userRepository.findById(id).orElseThrow());//TODO hata don
    }


}
