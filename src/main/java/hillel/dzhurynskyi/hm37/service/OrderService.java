package hillel.dzhurynskyi.hm37.service;

import hillel.dzhurynskyi.hm37.entity.Order;
import hillel.dzhurynskyi.hm37.entity.Product;
import hillel.dzhurynskyi.hm37.repository.OrderCrudRepository;
import hillel.dzhurynskyi.hm37.repository.ProductCrudRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {
    private OrderCrudRepository orderCrudRepository;
    private ProductCrudRepository productCrudRepository;

    public Order findOrderById(int id) {
        return orderCrudRepository.findOrderById(id);
    }

    public List<Order> findAllOrders() {
        return orderCrudRepository.findAll();
    }

    public void insertNewOrder(List<Integer> idProducts) {
        List<Product> products = findProductsById(idProducts);
        Order order = new Order();

        order.setDate(Instant.now());
        order.setProducts(products);
        order.setCost(products.stream().mapToDouble(Product::getCost).sum());

        orderCrudRepository.save(order);
    }

    public List<Product> findProductsById(List<Integer> idProducts) {
        List<Product> products = new ArrayList<>();

        idProducts.forEach(id -> products.add(productCrudRepository.findProductById(id)));

        return products;
    }

    public void deleteAllOrders() {
        orderCrudRepository.deleteAll();
    }

    public void deleteOrderById(int id) {
        orderCrudRepository.deleteById(id);
    }
}
