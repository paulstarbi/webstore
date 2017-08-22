package webstore.domain.repository.impl;

import org.springframework.stereotype.Repository;
import webstore.domain.Product;
import webstore.domain.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class InMemoryProductRepository implements ProductRepository {

    private List<Product> listOfProducts = new ArrayList<>();

    public InMemoryProductRepository() {
        Product iphone = new Product("P1234", "iPhone 5s", new BigDecimal(500));
        iphone.setDescription("Apple iPhone 5s, smartfon z 4-calowym ekranem " +
                "o rozdzielczości 640x1136i 8 - megapikselowym aparatem");
        iphone.setCategory("Smartfon");
        iphone.setManufacturer("Apple");
        iphone.setUnitsInStock(1000);

        Product laptop_dell = new Product("P1235", "Dell Inspiron", new BigDecimal(700));
        laptop_dell.setDescription("Dell Inspiron, 14-calowy laptop (czarny) " +
                "z procesorem Intel Core 3. generacji ");
        laptop_dell.setCategory("Laptop");
        laptop_dell.setManufacturer("Dell");
        laptop_dell.setUnitsInStock(1000);

        Product tablet_Nexus = new Product("P1236", "Nexus 7", new BigDecimal(300));
        tablet_Nexus.setDescription("Google Nexus 7 jest najlżejszym 7-calowym " +
                "tabletem z 4 - rdzeniowym procesorem Qualcomm SnapdragonTM S4 Pro");
        tablet_Nexus.setCategory("Tablet");
        tablet_Nexus.setManufacturer("Google");
        tablet_Nexus.setUnitsInStock(1000);
        listOfProducts.add(iphone);
        listOfProducts.add(laptop_dell);
        listOfProducts.add(tablet_Nexus);
    }

    @Override
    public List<Product> getAllProducts() {
        return listOfProducts;
    }

    @Override
    public Product getProductById(String productId) {
        Product productById = null;
        for (Product product : listOfProducts) {
            if (product != null && product.getProductId() != null &&
                    product.getProductId().equals(productId)) {
                productById = product;
                break;
            }
        }
        if (productById == null) {
            throw new IllegalArgumentException("Brak produktu o wskazanym id: "
                    + productId);
        }
        return productById;
    }

    @Override
    public Set<Product> getProductsByPriceFilter(Map<String, String> prices) {

        return (listOfProducts.stream()
                    .filter(product ->BigDecimal.valueOf(Integer.valueOf(prices.get("low"))).compareTo(product.getUnitPrice()) < 0)
                    .filter(product ->BigDecimal.valueOf(Integer.valueOf(prices.get("high"))).compareTo(product.getUnitPrice()) > 0)
                    .collect(Collectors.toSet()));
    }

    @Override
    public List<Product> getProductCategory(String category) {

        return listOfProducts.stream()
                .filter(product ->category.equalsIgnoreCase(product.getCategory()))
                .collect(Collectors.toList());
    }

    @Override
    public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
        Set<Product> productsByBrand = new HashSet<>();
        Set<Product> productsByCategory = new HashSet<Product>();
        Set<String> criteria = filterParams.keySet();
        if (criteria.contains("brand")) {
            for (String brandName : filterParams.get("brand")) {
                for (Product product : listOfProducts) {
                    if (brandName.equalsIgnoreCase(product.getManufacturer())) {
                        productsByBrand.add(product);
                    }
                }
            }
        }
        if(criteria.contains("category")) {
            for(String category: filterParams.get("category")) {
                productsByCategory.addAll(this.getProductCategory(category));
            }
        }
        productsByCategory.retainAll(productsByBrand);
        return productsByCategory;
    }

    @Override
    public List<Product> getProductsByManufacturer(String manufacturer) {

        return listOfProducts.stream()
                .filter(product -> manufacturer.equalsIgnoreCase(product.getManufacturer()))
                .collect(Collectors.toList());
    }

    // add data from form and input

    @Override
    public void addProduct(Product product) {
        listOfProducts.add(product);
    }
}
