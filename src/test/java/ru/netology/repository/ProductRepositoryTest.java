package ru.netology.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

public class ProductRepositoryTest {
    ProductRepository repository = new ProductRepository();

    Book book1 = new Book(32, "consciousness", 850, "Sarah");
    Book book2 = new Book(251, "conscious", 850, "Abbi");
    Book book3 = new Book(37, "fantasy", 850, "McNaught Judith");
    Book book4 = new Book(25, "phantasy", 850, "Abbi");
    Smartphone phone1 = new Smartphone(36, "apple", 77500, "universal");
    Smartphone phone2 = new Smartphone(40, "lenovo", 45000, "The Walt Disney Company ");
    Smartphone phone3 = new Smartphone(33, "conscience", 45000, "The Walt Disney Company ");

    @Test
    public void shouldFindAll() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(book4);
        repository.save(phone1);
        repository.save(phone2);
        repository.save(phone3);

        Product[] actual = repository.findAll();
        Product[] expected = {book1, book2, book3, book4, phone1, phone2, phone3};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoteById() {
        repository.save(book1);
        repository.save(book2);
        repository.save(phone2);
        repository.save(phone3);

        repository.remoteById(32);
        Product[] actual = repository.findAll();
        Product[] expected = {book2, phone2, phone3};
        assertArrayEquals(expected, actual);
    }

}
