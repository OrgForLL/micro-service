package com.nextsgo.papy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nextsgo.papy.entity.User;;
 

public interface UserRepository extends  JpaRepository<User,Long> {
    User findTop1ByNameAndPassword(String name,String password);
    User findByName(String name);
    User findByFullName(String name);
    User findById(Long id);
    List<User> findByNameLike(String name);    
}