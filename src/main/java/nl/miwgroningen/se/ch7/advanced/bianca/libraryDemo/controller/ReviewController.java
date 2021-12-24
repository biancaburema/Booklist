package nl.miwgroningen.se.ch7.advanced.bianca.libraryDemo.controller;

import nl.miwgroningen.se.ch7.advanced.bianca.libraryDemo.model.Book;
import nl.miwgroningen.se.ch7.advanced.bianca.libraryDemo.model.Review;
import nl.miwgroningen.se.ch7.advanced.bianca.libraryDemo.repository.BookRepository;
import nl.miwgroningen.se.ch7.advanced.bianca.libraryDemo.repository.ReviewRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

/**
 * @author Bianca Burema <b.burema@st.hanze.nl>
 * <p>
 * Maak en beheert reviews.
 */

@Controller
public class ReviewController {

    BookRepository bookRepository;
    ReviewRepository reviewRepository;

    public ReviewController(BookRepository bookRepository, ReviewRepository reviewRepository) {
        this.bookRepository = bookRepository;
        this.reviewRepository = reviewRepository;
    }

    @GetMapping("/review/new/{bookId}")
    protected String createNewReview(@PathVariable("bookId") Long bookId) {
        Optional<Book> book = bookRepository.findById(bookId);
        if (book.isEmpty()) {
            return "redirect:/";
        }
        Review newReview = new Review();
        newReview.setBook(book.get());
        reviewRepository.save(newReview);
        return "redirect:/";
    }
}
