package ma.dwm.dwmacademy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ma.dwm.dwmacademy.entities.Review;

@RepositoryRestResource
public interface IReviewRepository extends JpaRepository<Review, Long> {

}
