package com.sonemma.com.springjpa.Services;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface OrderRepo extends CrudRepository<CustomerOrder, Integer> {
     Product findByProductId(Integer id);
}
