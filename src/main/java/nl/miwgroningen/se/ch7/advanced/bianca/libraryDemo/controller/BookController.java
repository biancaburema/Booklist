package nl.miwgroningen.se.ch7.advanced.bianca.libraryDemo.controller;

import nl.miwgroningen.se.ch7.advanced.bianca.libraryDemo.model.Book;
import nl.miwgroningen.se.ch7.advanced.bianca.libraryDemo.model.Review;
import nl.miwgroningen.se.ch7.advanced.bianca.libraryDemo.repository.AuthorRepository;
import nl.miwgroningen.se.ch7.advanced.bianca.libraryDemo.repository.BookRepository;
import nl.miwgroningen.se.ch7.advanced.bianca.libraryDemo.repository.ReviewRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

/**
 * @author Bianca Burema <b.burema@st.hanze.nl>
 * Alle interacties van de gebruiker met de bibliotheek.
 */

@Controller
public class BookController {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private ReviewRepository reviewRepository;

    public BookController(BookRepository bookRepository, AuthorRepository authorRepository, ReviewRepository reviewRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.reviewRepository = reviewRepository;
    }

    @GetMapping({"/", "/books"})
    protected String showBookOverview(Model model) {
        model.addAttribute("allBooks", bookRepository.findAll());
        return "bookOverview";
    }

    @GetMapping("book/new")
    protected String showBookForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("allAuthors", authorRepository.findAll());
        return "bookForm";
    }

    @PostMapping("/book/new")
    protected String saveOrUpdateBook(@ModelAttribute("book") Book book, BindingResult result){
        if(!result.hasErrors()) {
            bookRepository.save(book);
        }
        return "redirect:/books";
    }

    @GetMapping("/books/update/{bookTitle}")
    protected String showBookForm(@PathVariable("bookTitle") String bookTitle, Model model) {
        Optional<Book> book = bookRepository.findByTitle(bookTitle);
        if (book.isEmpty()) {
            return "redirect:/books";
        }
        model.addAttribute("book", book.get());
        model.addAttribute("allAuthors", authorRepository.findAll());
        return "bookForm";
    }

    @GetMapping("/book/details/{bookTitle}")
    protected String showBookDetails(@PathVariable("bookTitle") String bookTitle, Model model) {
        Optional<Book> book = bookRepository.findByTitle(bookTitle);
        if (book.isEmpty()) {
            return "redirect:/books";
        }
        model.addAttribute("book", book.get());
        return "bookDetails";
    }

    @GetMapping("/book/review/new")
    protected String showReviewForm(Model model) {
        model.addAttribute("newReview", new Review());
        return "reviewForm";
    }

    @GetMapping("/book/review/{bookTitle}")
    protected String showReviewForm(@PathVariable("bookTitle") String bookTitle, Model model) {
        Optional<Book> book = bookRepository.findByTitle(bookTitle);
        if (book.isEmpty()) {
            return "redirect:/books";
        }
        model.addAttribute("book", book.get());
        model.addAttribute("allReviews", reviewRepository.findAll());
        return "reviewForm";
    }

}

