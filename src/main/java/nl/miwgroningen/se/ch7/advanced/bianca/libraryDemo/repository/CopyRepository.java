package nl.miwgroningen.se.ch7.advanced.bianca.libraryDemo.repository;

import nl.miwgroningen.se.ch7.advanced.bianca.libraryDemo.model.Copy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CopyRepository extends JpaRepository<Copy, Long> {
}
