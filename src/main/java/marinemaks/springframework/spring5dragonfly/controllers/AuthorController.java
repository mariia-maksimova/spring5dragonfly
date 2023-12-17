package marinemaks.springframework.spring5dragonfly.controllers;

import marinemaks.springframework.spring5dragonfly.repositories.AuthorRepository;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class AuthorController {
    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model) {
        model.addAttribute("authors", this.authorRepository.findAll());
        return "authors/list";
    }

}
