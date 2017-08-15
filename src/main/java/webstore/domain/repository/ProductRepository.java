package webstore.domain.repository;

import webstore.domain.Product;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ProductRepository {

    List <Product> getAllProducts();
    Product getProductById(String productId);
    List<Product> getProductCategory(String category);
    Set<Product> getProductsByFilter(Map<String, List<String>> filterParms);
}
