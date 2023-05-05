package hillel.dzhurynskyi.hm36.entity;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Component
public class Order {

    private Integer id;

    private LocalDateTime date;

    private Double cost;

    private List<Product> products;


    public Order() {
    }

    public Order(Integer id, LocalDateTime date, Double cost, List<Product> products) {
        this.id = id;
        this.date = date;
        this.cost = cost;
        this.products = products;
    }

    public Order(LocalDateTime date, Double cost, List<Product> products) {
        this.date = date;
        this.cost = cost;
        this.products = products;
    }
    public void addProduct(Product product) {
        products.add(product);
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", cost=" + cost +
                ", products=" + products +
                '}';
    }
}