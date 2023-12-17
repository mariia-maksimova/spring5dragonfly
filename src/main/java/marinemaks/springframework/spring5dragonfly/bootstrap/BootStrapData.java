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

import java.util.HashSet;
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
        Address address = createAddress("Flat 1", "1 Olive Street", "Big City", "Small County", "Secret Country", "123456");
        Publisher publisher = createPublisher("Best Publisher", address);
        Publisher publisher2 = createPublisher("Second Best Publisher", address);

        Author anna = createAuthor("Anna", "Smith");
        Book fantasy = createBook("Fantasy Book", "123456", Set.of(anna), publisher);

        Author bob = createAuthor("Bob", "Andrews");
        Book thriller = createBook("Thriller Book", "654321", Set.of(bob), publisher);
        Book thriller2 = createBook("Thriller Book 2", "654321", Set.of(anna, bob), publisher2);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Authors: " + authorRepository.count());
        System.out.println("Number of Addresses: " + addressRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());
        System.out.println("Number of Books for Author Anna: " + anna.getBooks().size());
        System.out.println("Number of Books for Author Bob: " + bob.getBooks().size());
        System.out.println("Number of Authors for Book Fantasy: " + fantasy.getAuthors().size());
        System.out.println("Number of Authors for Book Thriller: " + thriller.getAuthors().size());
        System.out.println("Number of Authors for Book Thriller2: " + thriller2.getAuthors().size());
        System.out.println("Number of Books for Publisher: " + publisher.getBooks().size());
        System.out.println("Number of Books for Publisher2: " + publisher2.getBooks().size());
        System.out.println("Number of Publishers for Address: " + address.getPublishers().size());
    }

    private Address createAddress(String line1, String line2, String city, String county, String country, String postcode) {
        Address address = new Address(
                line1,
                line2,
                city,
                county,
                country,
                postcode
        );
        addressRepository.save(address);

        return address;
    }

    private Publisher createPublisher(String name, Address address) {
        Publisher publisher = new Publisher(
                name,
                address
        );
        publisherRepository.save(publisher);

        address.getPublishers().add(publisher);
        addressRepository.save(address);

        return publisher;
    }

    private Author createAuthor(String firstName, String lastName) {
        Author author = new Author(
                firstName,
                lastName
        );
        authorRepository.save(author);

        return author;
    }

    private Book createBook(String title, String isbn, Set<Author> authors, Publisher publisher) {
        Book book = new Book(
                title,
                isbn
        );

        book.setAuthors(authors);
        book.setPublisher(publisher);

        authors.forEach(author -> {
            author.getBooks().add(book);
            authorRepository.save(author);
        });


        publisher.getBooks().add(book);
        publisherRepository.save(publisher);

        bookRepository.save(book);
        return book;
    }
}
