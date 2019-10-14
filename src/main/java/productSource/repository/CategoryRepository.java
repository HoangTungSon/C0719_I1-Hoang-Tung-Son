package productSource.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import productSource.model.ProductCategory;

public interface CategoryRepository extends PagingAndSortingRepository<ProductCategory, Long> {
}
