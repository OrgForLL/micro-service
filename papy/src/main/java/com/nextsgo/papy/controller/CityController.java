package com.nextsgo.papy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import com.nextsgo.papy.entity.Result;
import com.nextsgo.papy.entity.T_s_City;
import com.nextsgo.papy.repository.cityRepository;
import com.nextsgo.papy.utils.ResultUtil;

@RestController
public class CityController {
	
	@Autowired
	private cityRepository cityRepository;

	@PostMapping(value = "/city")
	private Result<?> cityList(HttpServletRequest request) {
		try {
			String code = request.getParameter("code");
			return ResultUtil.success(cityRepository.findByid("110000"));
		} catch (Exception e) {
			return ResultUtil.error(100, e.getMessage());
		}

	}
	
	@PostMapping(value = "/cityname")
	private Result<?> cityLists(HttpServletRequest request) {
		
		String id = request.getParameter("code");
		if (null == id || id.length() == 0) {
			return ResultUtil.error(500, "require code");
		}
		//return ResultUtil.success(cityRepository.findByid(id));
	
		List<T_s_City> listcity = cityRepository.findByid(id);
		if (listcity.size() > 1) {
			return ResultUtil.error(300, "no unique user");
		} else if (listcity.size() == 0) {
			return ResultUtil.error(400, "no user");
		} else {
			return ResultUtil.success(listcity.get(0));
		}
	}
	
}
