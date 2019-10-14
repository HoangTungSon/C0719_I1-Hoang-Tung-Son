package productSource.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import productSource.model.Product;
import productSource.repository.ProductRepository;
import productSource.service.ProductService;

public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findOne(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void remove(Long id) {
        productRepository.delete(id);
    }

    @Override
    public Iterable<Product> findAllByName(String name) {
        return productRepository.findAllByName(name);
    }
}
