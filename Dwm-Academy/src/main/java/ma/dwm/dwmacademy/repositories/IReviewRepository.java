package ma.dwm.dwmacademy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.dwm.dwmacademy.entities.Review;

@Repository
public interface IReviewRepository extends JpaRepository<Review, Long> {

}
