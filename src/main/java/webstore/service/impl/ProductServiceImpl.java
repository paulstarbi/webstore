package webstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webstore.domain.Product;
import webstore.domain.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class ProductServiceImpl implements webstore.service.ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return productRepository.getProductCategory(category);
    }

    @Override
    public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
        return productRepository.getProductsByFilter(filterParams);
    }

    @Override
    public List<Product> getProductByManufacturer(String manufacturer) {
        return productRepository.getProductsByManufacturer(manufacturer);
    }

    @Override
    public Product getProductById(String productId) {
        return productRepository.getProductById(productId);
    }

    @Override
    public Set<Product> getProductsByPriceFilter(Map<String, String> prices) {
        return productRepository.getProductsByPriceFilter(prices);
    }

//    @Override
//    public List<Product> getProductByMultipleCriteria(String productCategory, String price, String manufacturer) {
//        return productRepository.getProductByMultipleCriteria(productCategory, price, manufacturer);
//    }
}
