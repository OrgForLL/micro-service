package com.nextsgo.papy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.nextsgo.common.entity.Result;
import com.nextsgo.common.tools.ResultUtil;
import com.nextsgo.papy.entity.T_s_City;
import com.nextsgo.papy.repository.cityRepository;

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
	
	@PostMapping(value = "/citypid")
	private Result<?> citypidList(HttpServletRequest request) {
		
		String parentid = request.getParameter("code");
		if (null == parentid || parentid.length() == 0) {
			return ResultUtil.error(500, "require code");
		}
		//return ResultUtil.success(cityRepository.findByid(id));
	
		List<T_s_City> listcity = cityRepository.findByparentid(parentid);
		if (listcity.size() > 1) {
			return ResultUtil.error(300, "no unique user");
		} else if (listcity.size() == 0) {
			return ResultUtil.error(400, "no Parentid");
		} else {
			return ResultUtil.success(listcity.get(0));
		}
	}
	
	@PostMapping(value = "/cityid")
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
			return ResultUtil.error(400, "no City");
		} else {
			return ResultUtil.success(listcity.get(0));
		}
	}
	
}
