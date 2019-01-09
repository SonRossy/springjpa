package com.sonemma.com.springjpa.Controllers;

import com.sonemma.com.springjpa.Services.CustomerOrder;
import com.sonemma.com.springjpa.Services.OrderService;
import com.sonemma.com.springjpa.Services.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

    //dependency injection
    @Autowired
    OrderService orderService;

    @RequestMapping("/orders")
    public List<CustomerOrder> getOrders(){
        return orderService.getAllOder();
    }

    @RequestMapping("/productsByOrder/{id}")
    public Product getProducByOrder(@PathVariable Integer id){
        return orderService.findByProductId(id);
    }

    @RequestMapping("/order/{id}")
    public Optional<CustomerOrder> getOrder(@PathVariable int id){
        return orderService.getOrder(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/order")
    public void addOrder(@RequestBody CustomerOrder customerOrder){//meaning the post request will contatin a body that i need to turn into an customerOrder
        orderService.addOrder(customerOrder);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/order/{id}")
    public void updateOrder(@RequestBody CustomerOrder customerOrder, @PathVariable int id){//meaning the post request will contatin a body that i need to turn into a product
        orderService.updateOrder(id-1, customerOrder);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/order/{id}")
    public void deleteOrder(@PathVariable Integer id){//meaning the post request will contatin a body that i need to turn into a product
        orderService.deleteOrder(id);
    }
}
