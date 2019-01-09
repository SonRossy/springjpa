package com.sonemma.com.springjpa.Services;

import org.springframework.data.repository.CrudRepository;

/**
 * CrudRepository comes with functionality of adding , deleting and updating your Entity
 */
public interface ProductRepo extends CrudRepository<Product, Integer> {//Integer is the type of our primary key
}
