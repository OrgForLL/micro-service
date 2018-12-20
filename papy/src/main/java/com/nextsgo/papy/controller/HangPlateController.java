package com.nextsgo.papy.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextsgo.common.entity.Result;
import com.nextsgo.common.tools.ResultUtil;
import com.nextsgo.papy.entity.HangPlate;

import com.nextsgo.papy.repository.HangPlateRepository;

import com.nextsgo.papy.service.HangPlateService;


@RestController
public class HangPlateController {
	@Autowired
	private HangPlateRepository hangPlateRepository;
	@Autowired
	HangPlateService hangPlateService;

	@PostMapping(value = "/hangplates")
	private Result<?> hangPlateAdd(@Valid HangPlate hangplate, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
		}
		try {
			return ResultUtil.success(hangPlateRepository.save(hangplate));

		} catch (Exception e) {
			return ResultUtil.error(100, e.getMessage());
		}

	}

	@GetMapping(value = "/hangplates")
	private Result<?> hangplatesList() {

		try {
			return ResultUtil.success(hangPlateRepository.findAll());

		} catch (Exception e) {
			return ResultUtil.error(100, e.getMessage());
		}

	}
}
