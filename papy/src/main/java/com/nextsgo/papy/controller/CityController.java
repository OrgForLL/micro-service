package com.nextsgo.papy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextsgo.papy.entity.Result;
import com.nextsgo.papy.repository.cityRepository;
import com.nextsgo.papy.utils.ResultUtil;

@RestController
public class CityController {
	
	@Autowired
	private cityRepository cityRepository;

	@GetMapping(value = "/city")
	private Result<?> cityList() {
		try {
			return ResultUtil.success(cityRepository.findByName(""));

		} catch (Exception e) {
			return ResultUtil.error(100, e.getMessage());
		}

	}
	
}
