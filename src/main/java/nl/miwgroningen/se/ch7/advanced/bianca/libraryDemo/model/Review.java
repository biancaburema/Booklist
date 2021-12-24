package nl.miwgroningen.se.ch7.advanced.bianca.libraryDemo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Bianca Burema <b.burema@st.hanze.nl>
 * Dit is een exemplaar van een review.
 */

@Entity
@Getter @Setter
public class Review {

    @Id
    @GeneratedValue
    private Long reviewId;

    private int rating;

    private String review;

    @ManyToOne
    private Book book;
}
