package nl.miwgroningen.se.ch7.advanced.bianca.libraryDemo.repository;

import nl.miwgroningen.se.ch7.advanced.bianca.libraryDemo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
