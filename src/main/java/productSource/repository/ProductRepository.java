package productSource.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import productSource.model.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
    Iterable<Product> findAllByName(String name);
}

