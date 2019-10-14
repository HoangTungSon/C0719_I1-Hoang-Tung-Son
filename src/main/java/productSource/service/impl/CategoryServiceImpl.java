package productSource.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import productSource.model.ProductCategory;
import productSource.repository.CategoryRepository;
import productSource.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Iterable<ProductCategory> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public ProductCategory findById(Long id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public void save(ProductCategory category) {
        categoryRepository.save(category);
    }

    @Override
    public void remove(Long id) {
        categoryRepository.delete(id);
    }
}
