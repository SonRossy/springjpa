package com.sonemma.com.springjpa.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired //inject this class for me
    private OrderRepo orderRepo;


    public List<CustomerOrder> getAllOder() {
        List<CustomerOrder> customerOrderList = new ArrayList<>();
        orderRepo.findAll().forEach(customerOrderList::add);
        return customerOrderList;
    }

    public Optional<CustomerOrder> getOrder(Integer id) {
        return orderRepo.findById(id);
    }

    public void addOrder(CustomerOrder customerOrder) {
        orderRepo.save(customerOrder);
    }

    public void updateOrder(Integer id, CustomerOrder customerOrder) {
        orderRepo.save(customerOrder);
    }

    public void deleteOrder(Integer id) {
        Optional<CustomerOrder> order=(orderRepo.findById(id));
        orderRepo.delete(order.get());
    }

    public Product findByProductId(Integer id){
        //List<CustomerOrder> oderList = new ArrayList<>();
        Optional<CustomerOrder> customerOrder=orderRepo.findById(id);
        return customerOrder.get().getProduct();
        //return oderList.getProduct();
    }
}
