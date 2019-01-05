package com.nextsgo.papy.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextsgo.papy.entity.User;
 

@Service
public class UserService {	
	@Autowired
    private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
    public List<User> findAllByViaQuery(String name) {
        List<User> contacts = this.entityManager
                .createNativeQuery("select id,name,pass_word,create_date,createor_id, full_name from user where name like :name", "userMapping")
                .setParameter("name", name)
                .setMaxResults(5)
                .getResultList();
        
        return contacts;
    }
}
