package com.nextsgo.papy.controller;


import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nextsgo.common.entity.Result;
import com.nextsgo.papy.service.PapyService;

@RestController
public class PapyController {
	@Autowired
	PapyService papyService;

	@GetMapping("/myinfo")
	private String Myinfo() {
		return "2023-4-9";
		//return "2020-10-13-2";
	}

	@GetMapping(value = "/time/{name}")
	private Result<?> time(@PathVariable("name") String name) {	 
	
			return papyService.time(name);
	}
}
