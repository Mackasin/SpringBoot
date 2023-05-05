package hillel.dzhurynskyi.hm36.controller;

import hillel.dzhurynskyi.hm36.entity.Order;
import hillel.dzhurynskyi.hm36.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    private static final Logger LOG = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    OrderRepository orderRepository;

    @GetMapping(path = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Order> findAllOrders() {
        LOG.info("Show all Orders");
        return orderRepository.findAllOrders();
    }

    @GetMapping(path = "/order/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public  Order findOrderById(@PathVariable("id") int id){
        LOG.info("Show order with {} id",id);
       return orderRepository.findOrderById(id);
    }

}
