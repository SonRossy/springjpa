package com.sonemma.com.springjpa.Services;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepo extends CrudRepository<Customers, Integer> {

    Customers findCustomersByEmail(String email);
}
