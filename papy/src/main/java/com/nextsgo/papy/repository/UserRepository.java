package com.nextsgo.papy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nextsgo.papy.entity.User;
 

public interface UserRepository extends  JpaRepository<User,Integer> {
    public List<User> findByNameAndPassword(String n,String p);
}
