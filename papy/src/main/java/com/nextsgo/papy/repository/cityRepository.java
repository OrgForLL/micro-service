package com.nextsgo.papy.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nextsgo.papy.entity.T_S_USER;
import com.nextsgo.papy.entity.T_s_City;

public interface cityRepository extends  JpaRepository<T_s_City,String> {
	T_s_City findByName(String name);
	//T_s_City findByid(String id);
	List<T_s_City> findByid(String id);
	List<T_s_City> findByparentid(String parentid);
}
