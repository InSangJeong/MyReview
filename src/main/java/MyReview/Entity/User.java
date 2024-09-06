package MyReview.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;
    private String ID;
    private String PW;
    private String nickName;
    private String Auth;

    //TODO : Insert Add
    private LocalDateTime regDateTime;
    private String regID;
    private LocalDateTime chgDateTime;
    private String chgID;


    public User(){}

}
