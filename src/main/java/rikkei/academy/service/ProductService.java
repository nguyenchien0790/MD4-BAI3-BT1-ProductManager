package rikkei.academy.service;

import rikkei.academy.model.Product;

import java.util.*;

public class ProductService implements IProductService {
    private static final List<Product> products = new ArrayList<>();

    static {

        products.add(new Product(1, "Nokia 1102", 5, "Red", "Nokia"));
        products.add(new Product(2, "Blackberry A6 ", 220, "Black", "Blackberry"));
        products.add(new Product(3, "Iphone 13 Mini", 2150, "Rose Pink", "Apple"));
        products.add(new Product(4, "Samsung Galaxy Note 9", 1500, "Grey", "Samsung"));
        products.add(new Product(5, "OPPO X3", 140, "Silver", "OPPO"));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(int id) {
        for (Product product :
                products) {
            if (id == product.getId()) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void update(int id, Product product) {
        int indexOf = findIndexById(id);
        products.set(indexOf, product);
    }

    @Override
    public void delete(int id) {
        int indexOf = findIndexById(id);
        products.remove(indexOf);
    }

    @Override
    public int findIndexById(int id) {
        int index = -1;
        for (int i = 0; i < products.size(); i++) {
            if (id == products.get(i).getId()) {
                index = i;
            }
        }
        return index;
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> rs = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().toUpperCase().contains(name.toUpperCase())){
                rs.add(products.get(i));
            }
        }
        return rs;
    }
}
