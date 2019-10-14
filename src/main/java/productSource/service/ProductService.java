package productSource.service;

import productSource.model.Product;

public interface ProductService {
    Iterable<Product> findAll();

    Product findById(Long id);

    void save(Product product);

    void remove(Long id);

    Iterable<Product> findAllByName(String name);
}
