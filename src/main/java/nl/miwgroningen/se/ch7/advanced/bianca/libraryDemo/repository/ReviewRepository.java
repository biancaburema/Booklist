package nl.miwgroningen.se.ch7.advanced.bianca.libraryDemo.repository;

import nl.miwgroningen.se.ch7.advanced.bianca.libraryDemo.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
