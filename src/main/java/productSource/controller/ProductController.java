package productSource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import productSource.model.Product;
import productSource.service.ProductService;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ModelAndView listProduct(){
        Iterable<Product> products = productService.findAll();
        ModelAndView modelAndView = new ModelAndView("/listProduct");
        modelAndView.addObject("products", products);
        return modelAndView;
    }

}
