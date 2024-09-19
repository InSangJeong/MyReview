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

        return stdResult.NotSupport();
    }

}
