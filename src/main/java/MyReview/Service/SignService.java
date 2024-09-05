package MyReview.Service;

import MyReview.DTO.SignOnDTO;
import MyReview.Entity.User;
import MyReview.Repository.ReviewRepository;
import MyReview.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        String id = signOnDTO.getID();
        String pw = signOnDTO.getPW();
        String userName = signOnDTO.getUserName();

        if (userRepository.existsByID(id)) {
            return false;
        }

        User user = new User();
        user.setID(id);
        user.setPW(bCryptPasswordEncoder.encode(pw));
        user.setUserName(userName);
        user.setAuth("ADMIN");

        userRepository.save(user);

        return true;
    }
}
