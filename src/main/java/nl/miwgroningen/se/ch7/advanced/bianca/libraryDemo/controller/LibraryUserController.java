package nl.miwgroningen.se.ch7.advanced.bianca.libraryDemo.controller;

import nl.miwgroningen.se.ch7.advanced.bianca.libraryDemo.model.LibraryUser;
import nl.miwgroningen.se.ch7.advanced.bianca.libraryDemo.repository.LibraryUserRepository;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Bianca Burema <b.burema@st.hanze.nl>
 * Administreer gebruikersgegevens.
 */

@Controller
@RequestMapping("/users")
public class LibraryUserController {

    LibraryUserRepository libraryUserRepository;
    PasswordEncoder passwordEncoder;

    public LibraryUserController(LibraryUserRepository libraryUserRepository, PasswordEncoder passwordEncoder) {
        this.libraryUserRepository = libraryUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/new")
    @Secured("ROLE_ADMIN")
    protected String showUserForm(Model model) {
        model.addAttribute("newUser", new LibraryUser());
        return "userForm";
    }

    @PostMapping("/new")
    @Secured("ROLE_ADMIN")
    protected String saveOrUpdateUser(@ModelAttribute("newUser") LibraryUser user, BindingResult result) {
        if (result.hasErrors()) {
            return "userForm";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        libraryUserRepository.save(user);
        return "redirect:/";
    }
}
