package productSource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import productSource.model.Product;
import productSource.model.ProductCategory;
import productSource.service.CategoryService;
import productSource.service.ProductService;

import java.time.LocalDate;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<ProductCategory> categories(){
        return categoryService.findAll();
    }

    @GetMapping("/products")
    public ModelAndView listProduct(@RequestParam("s") Optional<String> s){
        Iterable<Product> products;
        if(s.isPresent()){
            products = productService.findAllByName(s.get());
        } else {
            products = productService.findAll();
        }
        ModelAndView modelAndView = new ModelAndView("/product/listProduct");
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping("/create-product")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/product/createProduct");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/create-product")
    public ModelAndView saveProduct(@Validated @ModelAttribute("product") Product product, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView("/product/createProduct");
        modelAndView.addObject("product", new Product());
        if(bindingResult.hasErrors()){
            modelAndView.addObject("message", "New product is fail to created");
        } else {
            product.setDateCreate(LocalDate.now().toString());
            productService.save(product);
            modelAndView.addObject("message", "New product created successfully");
        }
        return modelAndView;
    }

    @GetMapping("/edit-product/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Product product = productService.findById(id);
        if(product != null) {
            ModelAndView modelAndView = new ModelAndView("/product/editProduct");
            modelAndView.addObject("product", product);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-product")
    public ModelAndView updateProduct(@Validated @ModelAttribute("product") Product product, BindingResult bindingResult){

        ModelAndView modelAndView = new ModelAndView("/product/editProduct");
        modelAndView.addObject("product", product);

        if(bindingResult.hasErrors()){
            modelAndView.addObject("message", "Product is fail to updated ");
        } else {
            productService.save(product);
            modelAndView.addObject("message", "Product updated successfully");
        }
        return modelAndView;
    }

    @GetMapping("/delete-product/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Product product = productService.findById(id);
        if(product != null) {
            ModelAndView modelAndView = new ModelAndView("/product/deleteProduct");
            modelAndView.addObject("product", product);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-product")
    public String deleteProduct(@ModelAttribute("product") Product product){
        productService.remove(product.getId());
        return "redirect:products";
    }
}
