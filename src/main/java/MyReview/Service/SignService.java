package MyReview.Service;

import MyReview.Common.Code;
import MyReview.DTO.SignOnDTO;
import MyReview.Entity.User;
import MyReview.Repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SignService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public SignService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder= bCryptPasswordEncoder;
    }


    public boolean signOn(SignOnDTO signOnDTO) {
        String id = signOnDTO.getUsername();
        String pw = signOnDTO.getPassword();
        String nickName = signOnDTO.getNickname();

        if (userRepository.existsByID(id)) {
            return false;
        }

        User user = new User();
        user.setID(id);
        user.setPW(bCryptPasswordEncoder.encode(pw));
        user.setNickName(nickName);
        user.setAuth("ROLE_ADMIN");

        userRepository.save(user);

        return true;
    }
}
