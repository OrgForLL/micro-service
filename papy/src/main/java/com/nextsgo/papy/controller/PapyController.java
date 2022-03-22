package com.nextsgo.papy.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PapyController {
	@GetMapping("/myinfo")
	private String Myinfo() {
		return "2020-10-13-2";
	}
}
