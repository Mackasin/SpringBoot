package hillel.dzhurynskyi.hm37.controller;

import hillel.dzhurynskyi.hm37.entity.Order;
import hillel.dzhurynskyi.hm37.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class OrderController {
    private static final Logger LOG = LoggerFactory.getLogger(OrderController.class);
    private OrderService orderService;

    @PostMapping(path = "/insertNewOrder")
    public void insertNewOrder(@RequestBody List<Integer> idsProducts) {
        LOG.info("Insert new Order start with products {}", idsProducts);
        orderService.insertNewOrder(idsProducts);
        LOG.info("Insert new Order ended");
    }

    @GetMapping(path = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Order> findAllOrders() {
        LOG.info("findAll orders start");
        List<Order> orders = orderService.findAllOrders();
        LOG.info("findAll orders ended");
        return orders;
    }

    @GetMapping(path = "/order/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Order findOrderById(@PathVariable("id") int id) {
        LOG.info("find order {} start", id);
        Order order = orderService.findOrderById(id);
        LOG.info("find order {} ended", id);
        return order;
    }

    @GetMapping(path = "/deleteAllOrders")
    public void deleteAllOrders() {
        LOG.info("deleteAll starting");
        orderService.deleteAllOrders();
        LOG.info("deleteAll ended");
    }

    @GetMapping(path = "/deleteOrder/{id}")
    public void deleteAllOrders(@PathVariable("id") int id) {
        LOG.info("delete Order {} starting", id);
        orderService.deleteOrderById(id);
        LOG.info("delete Order {} starting", id);
    }
}
