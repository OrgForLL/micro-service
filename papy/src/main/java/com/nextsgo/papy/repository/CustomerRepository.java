package com.nextsgo.papy.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.nextsgo.papy.entity.Customer;
import com.nextsgo.papy.entity.User;
 

public interface CustomerRepository extends  JpaRepository<Customer,Long> {
    
    User findByName(String name);
    User findByNumber(String f);    
    
}
