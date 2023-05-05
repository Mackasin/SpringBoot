package hillel.dzhurynskyi.hm37.repository;

import hillel.dzhurynskyi.hm37.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductCrudRepository extends CrudRepository<Product,Integer> {
    Product findProductById(Integer id);
}
