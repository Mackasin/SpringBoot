package hillel.dzhurynskyi.hm36.repository;

import hillel.dzhurynskyi.hm36.entity.Product;
import hillel.dzhurynskyi.hm36.mapper.ProductsRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    private final JdbcTemplate jdbcTemplate;
    private final ProductsRowMapper productsRowMapper;

    public ProductRepository(JdbcTemplate jdbcTemplate, ProductsRowMapper productsRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.productsRowMapper = productsRowMapper;
    }

    public List<Product> findProductsByOrderId(int id) {
        return jdbcTemplate.query("SELECT * FROM order_products INNER JOIN product ON order_products.id_product = product.id WHERE order_products.id_order = ?", productsRowMapper, id);
    }
    public boolean insertProduct(Product product) {
        return jdbcTemplate.update("insert into hm36.product(id,name, cost) values (?,?,?)",product.getId(),product.getName(),product.getCost()) > 0;
    }

    public Product findProduct(int id) {
        return jdbcTemplate.queryForObject("select * from hm36.product p where p.id=?", productsRowMapper, id);
    }


}
