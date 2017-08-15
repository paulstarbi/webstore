package webstore.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import webstore.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping
    public String list(Model model) {
        model.addAttribute("products",
                productService.getAllProducts());

        return "products";
    }

    @RequestMapping ("/all")
    public String allProducts(Model model){
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @RequestMapping("/{category}")
    public String getProductByCategory(Model model, @PathVariable("category")String productCatetgory) {
        model.addAttribute("products", productService.getProductsByCategory(productCatetgory));
        return "products";
    }
}
