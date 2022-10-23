package ru.netology.repository;

import lombok.Data;

import ru.netology.domain.Product;

public class ProductRepository {
    private Product[] goods = new Product[0];

    public void save(Product good) {
        Product[] tmp = new Product[goods.length + 1];
        for (int i = 0; i < goods.length; i++) {
            tmp[i] = goods[i];
        }
        tmp[tmp.length - 1] = good;
        goods = tmp;
    }

    public Product[] findAll() {
        return goods;
    }

    public void remoteById(int id) {
        int length = goods.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product good : goods) {
            if (good.getId() != id) {
                tmp[index] = good;
                index++;
            }
        }
        goods = tmp;
    }
}