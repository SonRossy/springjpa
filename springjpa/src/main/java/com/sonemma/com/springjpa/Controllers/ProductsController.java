package com.sonemma.com.springjpa.Controllers;

import com.sonemma.com.springjpa.Services.Product;
import com.sonemma.com.springjpa.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController //making this class a rest controller like a controller
public class ProductsController {


    //dependency injection
    @Autowired
    ProductService productService;

    @RequestMapping("/products") //when someone goes to the root folder
    public List<Product> getProducts(){
        return productService.getAllProducts();
    }

    @RequestMapping("/product/{id}")
    public Optional<Product> getProduct(@PathVariable int id){
        return productService.getProduct(new Integer(id));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/product")
    public void addProduct(@RequestBody Product product){//meaning the post request will contatin a body that i need to turn into a product
     productService.addProduct(product);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/product/{id}")
    public void updateProduct(@RequestBody Product product,@PathVariable int id){//meaning the post request will contatin a body that i need to turn into a product
        productService.updateProduct(id-1,product);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/product/{id}")
    public void deleteProduct(@PathVariable Integer id){//meaning the post request will contatin a body that i need to turn into a product
        productService.deleteProduct(id);
    }
}
