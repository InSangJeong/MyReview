package MyReview.Repository;
import MyReview.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    // 추후 개발하면서 필요시 메서드 추가
}
