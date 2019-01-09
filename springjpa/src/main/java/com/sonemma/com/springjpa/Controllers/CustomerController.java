package com.sonemma.com.springjpa.Controllers;

import com.sonemma.com.springjpa.Services.CustomerService;
import com.sonemma.com.springjpa.Services.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    //dependency injection
    @Autowired
    CustomerService customerService;

    @RequestMapping("/customers")
    public List<Customers> getCustomers(){
        return customerService.getAllCustomers();
    }

    @RequestMapping("/customers/{email}")
    public Integer getCustomerId(@PathVariable String email)
    {
        return customerService.getCustomerId(email).getCid();
    }

    @RequestMapping("/customer/{id}")
    public Optional<Customers> getCustomers(@PathVariable int id){
        return customerService.getCustomer(new Integer(id));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/customer")
    public void addCustomers(@RequestBody Customers customer){//meaning the post request will contatin a body that i need to turn into a product
        customerService.addCustomer(customer);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/customer/{id}")
    public void updateCustomers(@RequestBody Customers customer,@PathVariable int id){//meaning the post request will contatin a body that i need to turn into a product
        customerService.updateCustomer(id-1,customer);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/customer/{id}")
    public void deleteCustomers(@PathVariable Integer id){//meaning the post request will contatin a body that i need to turn into a product
        customerService.deleteCustomer(id);
    }
}
