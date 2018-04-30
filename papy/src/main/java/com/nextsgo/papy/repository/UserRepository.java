package com.nextsgo.papy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nextsgo.papy.entity.T_S_USER;
 

public interface UserRepository extends  JpaRepository<T_S_USER,Integer> {
    public List<T_S_USER> findByCodeAndPassword(String code,String p);
    T_S_USER findBycode(String code);
   // T_S_USER findByFullcode(String f);    
    List<T_S_USER> findBycodeLike(String code);
}
