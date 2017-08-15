package webstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webstore.domain.Product;
import webstore.domain.repository.ProductRepository;

import java.util.List;

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
}
