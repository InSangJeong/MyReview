package MyReview.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@Getter
@Setter
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;
    private Long categorySeq;
    private String subject;
    private String text;
    private String imgLink; // TODO : 여러 이미지 처리할수있게 따로 처리해야함.
    private String writer;
    private LocalDateTime regDateTime;
    private String modifier;
    private LocalDateTime chgDateTime;
    private boolean openYN;

    public Review(){}

}

