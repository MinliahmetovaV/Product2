package ru.netology.manager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Book book1 = new Book(250, "consciousness", 850, "Sarah");
    Book book2 = new Book(250, "conscious", 850, "Abbi");
    Book book3 = new Book(250, "fantasy", 850, "McNaught Judith");
    Book book4 = new Book(250, "phantasy", 850, "Abbi");
    Smartphone phone1 = new Smartphone(33, "apple", 77500, "universal");
    Smartphone phone2 = new Smartphone(33, "lenovo", 45000, "The Walt Disney Company ");
    Smartphone phone3 = new Smartphone(33, "conscience", 45000, "The Walt Disney Company ");


    @Test
    public void shouldFindOneElement() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(phone1);
        manager.add(phone3);

        Product[] actual = manager.searchBy("app");
        Product[] expected = {phone1};
        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldFindTwoElements() {
        manager.add(book1);
        manager.add(book3);
        manager.add(book4);
        manager.add(phone1);
        manager.add(phone3);

        Product[] actual = manager.searchBy("sy");
        Product[] expected = {book3, book4};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllElements() {
        manager.add(book1);
        manager.add(book2);
        manager.add(phone3);

        Product[] actual = manager.searchBy("co");
        Product[] expected = {book1, book2, phone3};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindAnything() {

        Product[] actual = manager.searchBy("app");
        Product[] expected = {};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindElements() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(phone1);
        manager.add(phone3);

        Product[] actual = manager.searchBy("ra");
        Product[] expected = {};
        assertArrayEquals(expected, actual);
    }

}

