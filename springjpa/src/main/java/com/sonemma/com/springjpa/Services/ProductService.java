package com.sonemma.com.springjpa.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired //inject this class for me
    private ProductRepo productRepo;


    ProductService() {

    }

    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();
        //find all products from jpa database
        productRepo.findAll().forEach(productList::add);
        return productList;
    }

    public Optional<Product> getProduct(Integer id) {
        //return a specific product
        return productRepo.findById(id);
    }

    public void addProduct(Product product) {
        // update or add a product
        productRepo.save(product);
    }

    public void updateProduct(Integer id, Product product) {
        /*for(Product aProduct : products){ old code
            if(aProduct.getId()==id){
                products.set(id,product);
                return;
            }*/
        //spring is smart enough to know when a product already exit to update it
        productRepo.save(product);
    }

    public void deleteProduct(Integer id) {
        Optional<Product> product=(productRepo.findById(id));
        productRepo.delete(product.get());
    }

}
