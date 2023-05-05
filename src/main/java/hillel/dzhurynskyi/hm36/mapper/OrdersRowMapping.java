package hillel.dzhurynskyi.hm36.mapper;

import hillel.dzhurynskyi.hm36.entity.Order;
import hillel.dzhurynskyi.hm36.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

@Component
public class OrdersRowMapping implements RowMapper<Order> {
    @Autowired
    ProductRepository productRepository;

    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Order(rs.getInt("id"), rs.getObject("date", LocalDateTime.class), rs.getDouble("cost"), productRepository.findProductsByOrderId(rs.getInt("id")));
    }
}
