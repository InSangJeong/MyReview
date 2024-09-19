package MyReview.Controller;

import MyReview.Common.stdResult;
import MyReview.DTO.ReviewDTO;
import MyReview.Entity.Review;
import MyReview.Repository.ReviewRepository;
import MyReview.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/review")
public class ReviewController {
    private ReviewService reviewService;
    private ReviewRepository reviewRepository;

    public ReviewController(ReviewService reviewService, ReviewRepository reviewRepository) {
        this.reviewService = reviewService;
        this.reviewRepository = reviewRepository;
    }

    @GetMapping("/getReviews")
    public List<Review> getAllReviews(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "limit", defaultValue = "10") int limit,
            @RequestParam(value = "category", defaultValue = "0") int category) {
        if (limit > 50)
            limit = 50;


        return reviewService.getAllReviews();
    }

    @PostMapping("/createReview")
    public stdResult createReview(@RequestBody ReviewDTO reviewDto){
        String name =  SecurityContextHolder.getContext().getAuthentication().getName();
        if (!Objects.equals(name, "admin"))
            return stdResult.Unauthorized();

        if (!reviewDto.isValidateCreate())
            return new stdResult(-10, "Wrong Params", "");

        var review = Review.builder()
                .categorySeq(reviewDto.getCategorySeq())
                .subject(reviewDto.getSubject())
                .text(reviewDto.getText())
                .writer("admin") //temporary set
                .regDateTime(LocalDateTime.now())
                .openYN(true)
                .build();

        var result = reviewRepository.save(review);
        if(result == null)
            return new stdResult(-1, "Fail", "Unknown Reason.");

        return stdResult.Success();
    }

}
