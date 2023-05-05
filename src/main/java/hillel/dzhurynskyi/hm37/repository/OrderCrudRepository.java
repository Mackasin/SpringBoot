package hillel.dzhurynskyi.hm37.repository;

import hillel.dzhurynskyi.hm37.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderCrudRepository extends CrudRepository<Order, Integer> {
    Order findOrderById(int id);
    List<Order> findAll();
}
