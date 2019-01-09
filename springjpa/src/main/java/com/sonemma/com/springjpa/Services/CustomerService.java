package com.sonemma.com.springjpa.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired //inject this class for me
    private CustomerRepo customerRepo;


    public List<Customers> getAllCustomers() {
        List<Customers> customerListList = new ArrayList<>();
        customerRepo.findAll().forEach(customerListList::add);
        return customerListList;
    }

    public Optional<Customers> getCustomer(Integer id) {
        return customerRepo.findById(id);
    }

    public void addCustomer(Customers customer) {
        customerRepo.save(customer);
    }

    public void updateCustomer(Integer id, Customers customer) {
        /*for(Customers aProduct : products){ old code
            if(aProduct.getId()==id){
                products.set(id,product);
                return;
            }*/
        //spring is smart enough to know when a product already exit to update it
        customerRepo.save(customer);
    }

    public Customers getCustomerId(String email){
        return customerRepo.findCustomersByEmail(email);
    }

    public void deleteCustomer(Integer id) {
        Optional<Customers> customer=(customerRepo.findById(id));
        customerRepo.delete(customer.get());
    }
}
