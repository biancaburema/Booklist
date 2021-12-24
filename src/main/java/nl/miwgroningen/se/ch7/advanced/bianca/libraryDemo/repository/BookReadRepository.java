package nl.miwgroningen.se.ch7.advanced.bianca.libraryDemo.repository;

import nl.miwgroningen.se.ch7.advanced.bianca.libraryDemo.model.BookRead;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookReadRepository extends JpaRepository<BookRead, Long> {
}
