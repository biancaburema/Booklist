package nl.miwgroningen.se.ch7.advanced.bianca.libraryDemo.controller;

import nl.miwgroningen.se.ch7.advanced.bianca.libraryDemo.model.Author;
import nl.miwgroningen.se.ch7.advanced.bianca.libraryDemo.model.Book;
import nl.miwgroningen.se.ch7.advanced.bianca.libraryDemo.model.Review;
import nl.miwgroningen.se.ch7.advanced.bianca.libraryDemo.repository.BookRepository;
import nl.miwgroningen.se.ch7.advanced.bianca.libraryDemo.repository.ReviewRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author Bianca Burema <b.burema@st.hanze.nl>
 * <p>
 * Maak en beheert reviews.
 */

@Controller
public class ReviewController {

    ReviewRepository reviewRepository;

    public ReviewController(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @PostMapping("/book/review/new")
    protected String saveOrUpdateReview(@ModelAttribute("newReview") Review review, BindingResult result){
        if(result.hasErrors()) {
            return "reviewForm";
        }
        reviewRepository.save(review);
        return "redirect:/";
    }

}
