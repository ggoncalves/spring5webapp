package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class DevBootstrap implements CommandLineRunner {

  @Resource
  private AuthorRepository authorRepository;

  @Resource
  private BookRepository bookRepository;

  @Resource
  private PublisherRepository publisherRepository;

  @Override
  public void run(String... args) throws Exception {

    Publisher publisher = new Publisher();
    publisher.setName("Editora Março");
    publisher.setAddress("Tongadaminhonga");

    System.out.println("Publishers count: " + publisherRepository.count());
    publisherRepository.save(publisher);
    System.out.println("Publishers count: " + publisherRepository.count());

    Author eric = new Author("Eric", "Evans");
    Book ddd = new Book("Domain Driven Design", "123123");
    eric.getBooks().add(ddd);
    ddd.getAuthors().add(eric);

    authorRepository.save(eric);
    bookRepository.save(ddd);

    Author rod = new Author("Rod", "Johnson");
    Book noEJB = new Book("J2EE Development without EJB", "3939459459");
    rod.getBooks().add(noEJB);
    noEJB.getAuthors().add(rod);

    authorRepository.save(rod);
    bookRepository.save(noEJB);

    System.out.println("Number of Books: " + bookRepository.count());
  }
}
