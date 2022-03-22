package com.nextsgo.papy.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.nextsgo.papy.entity.Menu;
 
 

public interface MenuRepository extends  JpaRepository<Menu,Long> { 
	Menu findByName(String name);
	Menu findById(Long id);
}