package marinemaks.springframework.spring5dragonfly.bootstrap;

import marinemaks.springframework.spring5dragonfly.domain.Author;
import marinemaks.springframework.spring5dragonfly.domain.Book;
import marinemaks.springframework.spring5dragonfly.repositories.AuthorRepository;
import marinemaks.springframework.spring5dragonfly.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author anna = new Author("Anna", "Smith");
        Book fantasy = new Book("Fantasy Book", "123456");

        anna.getBooks().add(fantasy);
        fantasy.getAuthors().add(anna);

        authorRepository.save(anna);
        bookRepository.save(fantasy);

        Author bob = new Author("Bob", "Smith");
        Book thriller = new Book("Thriller Book", "654321");

        bob.getBooks().add(thriller);
        thriller.getAuthors().add(bob);

        authorRepository.save(bob);
        bookRepository.save(thriller);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
    }
}
