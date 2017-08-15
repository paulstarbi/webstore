package webstore.service;

import webstore.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String category);
}
