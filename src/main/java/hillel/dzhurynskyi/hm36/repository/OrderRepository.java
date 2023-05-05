package hillel.dzhurynskyi.hm36.repository;

import hillel.dzhurynskyi.hm36.entity.Order;
import hillel.dzhurynskyi.hm36.entity.Product;
import hillel.dzhurynskyi.hm36.mapper.OrdersRowMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private OrdersRowMapping ordersRowMapping;

//    @Autowired
//    ProductRepository productRepository;


    public List<Order> findAllOrders() {
        return jdbcTemplate.query("SELECT * FROM hm36.order", ordersRowMapping);
    }

    public Order findOrderById(int id) {
        return jdbcTemplate.queryForObject("select * from hm36.`order` where id=?", ordersRowMapping, id);
    }

    public void insertNewOrder(Order order) {
        jdbcTemplate.update("INSERT INTO hm36.order(date, cost) VALUES (?,?)", order.getDate(), order.getCost());
        Integer orderId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        for (Product product : order.getProducts()) {
            jdbcTemplate.update("INSERT INTO order_products (id_order, id_product) VALUES (?, ?)", orderId, product.getId());
        }
    }
//    @PostConstruct
//    private void insertOrders(){
//
//       Order order1 = new Order(LocalDateTime.now(),150.00, List.of(productRepository.findProduct(1),productRepository.findProduct(3),productRepository.findProduct(5)));
//       Order order2 = new Order(LocalDateTime.now().minusDays(5),700.00, List.of(productRepository.findProduct(2),productRepository.findProduct(4),productRepository.findProduct(5)));
//        insertNewOrder(order1);
//        insertNewOrder(order2);
//    }
}
