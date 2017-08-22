package webstore.service;

import webstore.domain.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ProductService {

    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String category);
    Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);
    List<Product> getProductByManufacturer (String manufacturer);
    Product getProductById(String productId);
    Set<Product> getProductsByPriceFilter(Map<String, String> prices);

    void addProduct(Product product);
}
