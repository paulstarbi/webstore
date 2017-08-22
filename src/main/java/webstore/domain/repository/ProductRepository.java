package webstore.domain.repository;

import webstore.domain.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ProductRepository {

    // Products filtering
    Product getProductById(String productId);
    List <Product> getAllProducts();
    List<Product> getProductCategory(String category);
    List <Product> getProductsByManufacturer(String manufacturer);
    Set<Product> getProductsByFilter(Map<String, List<String>> filterParms);
    Set<Product> getProductsByPriceFilter(Map<String, String> prices);

    // Products add
    void addProduct(Product product);

}
