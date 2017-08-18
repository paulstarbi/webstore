package webstore.domain.repository;

import webstore.domain.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ProductRepository {

    List <Product> getAllProducts();
    Product getProductById(String productId);
    List<Product> getProductCategory(String category);
    Set<Product> getProductsByFilter(Map<String, List<String>> filterParms);
    List <Product> getProductsByManufacturer(String manufacturer);

    Set<Product> getProductsByPriceFilter(Map<String, String> prices);
//    List<Product> getProductByMultipleCriteria(String productCategory, String price, String manufacturer);
}
