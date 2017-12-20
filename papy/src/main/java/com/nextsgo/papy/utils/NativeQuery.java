package com.nextsgo.papy.utils;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.nextsgo.papy.entity.User;
/***
 * SQL语句查询
 * @author min
 *
 */
@Component
public class NativeQuery {
	@Autowired
	private ManInfoProperties manInfoProperties;
	public List<?> getResultList(String s) {
		Map<String, String> properties = new HashMap<String, String>();
		properties.put("javax.persistence.jdbc.driver", manInfoProperties.getDriverClassName());
		properties.put("javax.persistence.jdbc.url", manInfoProperties.getUrl());
		properties.put("javax.persistence.jdbc.user", manInfoProperties.getUsername());
		properties.put("javax.persistence.jdbc.password", manInfoProperties.getPassword());
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqlPersistenceUnit",properties);
		EntityManager em = emf.createEntityManager();
		//创建原生SQL查询QUERY实例,指定了返回的实体类型
        Query query =  em.createNativeQuery(s,User.class);
		//Query query = em.createNativeQuery(s);
		List<User> list = query.getResultList();
		if (null != emf) {
			emf.close();
		}
		return list;

	}

}
