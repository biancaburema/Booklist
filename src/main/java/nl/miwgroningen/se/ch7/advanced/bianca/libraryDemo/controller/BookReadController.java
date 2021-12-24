package nl.miwgroningen.se.ch7.advanced.bianca.libraryDemo.controller;

import nl.miwgroningen.se.ch7.advanced.bianca.libraryDemo.model.Book;
import nl.miwgroningen.se.ch7.advanced.bianca.libraryDemo.model.BookRead;
import nl.miwgroningen.se.ch7.advanced.bianca.libraryDemo.repository.BookRepository;
import nl.miwgroningen.se.ch7.advanced.bianca.libraryDemo.repository.BookReadRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

/**
 * @author Bianca Burema <b.burema@st.hanze.nl>
 * <p>
 * maak en leen exemplaren van boeken.
 */

@Controller
public class BookReadController {

    private BookRepository bookRepository;
    private BookReadRepository bookReadRepository;

    public BookReadController(BookRepository bookRepository, BookReadRepository copyRepository) {
        this.bookRepository = bookRepository;
        this.bookReadRepository = copyRepository;
    }

    @GetMapping("/booksread/new/{bookId}")
    protected String createNewBookRead(@PathVariable("bookId") Long bookId) {
        Optional<Book> book = bookRepository.findById(bookId);
        if (book.isEmpty()) {
            return "redirect:/";
        }
        BookRead newBookRead = new BookRead();
        newBookRead.setBook(book.get());
        bookReadRepository.save(newBookRead);
        return "redirect:/";
    }


}
