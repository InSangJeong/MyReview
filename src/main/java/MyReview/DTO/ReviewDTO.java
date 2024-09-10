package MyReview.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReviewDTO {
    private Long categorySeq;
    private String subject;
    private String text;
    private String imgLink;
    private String writer;
    private LocalDateTime regDateTime;
    private String modifier;
    private LocalDateTime chgDateTime;
    private boolean openYN;

    public boolean isValidateCreate(){
        if (categorySeq == null || categorySeq <= 0 || subject.isBlank() || text.isBlank()) {
            return false;
        }

        return true;
    }

}
