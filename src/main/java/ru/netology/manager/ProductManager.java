package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    public ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product good) {
        repository.save(good);
    }

    public boolean matches(Product good, String search) {
        return good.getName().contains(search);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product good : repository.findAll()) {
            if (matches(good, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = good;
                result = tmp;
            }
        }
        return result;
    }
}
