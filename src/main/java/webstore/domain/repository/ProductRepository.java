package webstore.domain.repository;

import webstore.domain.Product;

import java.util.List;

public interface ProductRepository {

    List <Product> getAllProducts();
    Product getProductById(String productId);
    List<Product> getProductCategory(String category);
}
