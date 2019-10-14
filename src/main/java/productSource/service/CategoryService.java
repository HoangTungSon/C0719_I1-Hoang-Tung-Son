package productSource.service;

import productSource.model.ProductCategory;

public interface CategoryService {
    Iterable<ProductCategory> findAll();

    ProductCategory findById(Long id);

    void save(ProductCategory category);

    void remove(Long id);
}
