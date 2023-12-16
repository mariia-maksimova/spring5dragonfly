package marinemaks.springframework.spring5dragonfly.bootstrap;

import marinemaks.springframework.spring5dragonfly.domain.Author;
import marinemaks.springframework.spring5dragonfly.domain.Book;
import marinemaks.springframework.spring5dragonfly.domain.Address;
import marinemaks.springframework.spring5dragonfly.domain.Publisher;

import marinemaks.springframework.spring5dragonfly.repositories.AddressRepository;
import marinemaks.springframework.spring5dragonfly.repositories.AuthorRepository;
import marinemaks.springframework.spring5dragonfly.repositories.BookRepository;
import marinemaks.springframework.spring5dragonfly.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final AddressRepository addressRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, AddressRepository addressRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.addressRepository = addressRepository;
        this.publisherRepository = publisherRepository;
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

        Address address = new Address("First line", "Second line", "City", "County", "Country", "Postcode");
        Publisher publisher = new Publisher("Best Publisher", address);

        addressRepository.save(address);
        publisherRepository.save(publisher);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Authors: " + authorRepository.count());
        System.out.println("Number of Addresses: " + addressRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());
    }
}
