package com.nextsgo.papy.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.nextsgo.papy.entity.T_s_City;

public interface cityRepository extends  JpaRepository<T_s_City,String> {
	T_s_City findByName(String name);
}
