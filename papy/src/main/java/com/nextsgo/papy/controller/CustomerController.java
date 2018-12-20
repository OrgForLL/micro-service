package com.nextsgo.papy.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextsgo.common.entity.Result;
import com.nextsgo.common.tools.ResultUtil;
import com.nextsgo.papy.entity.Customer;

import com.nextsgo.papy.repository.CustomerRepository;


/***
 * 客户处理
 * 
 * @author min
 *
 */
@RestController
public class CustomerController extends BaseController {
	@Autowired
	private CustomerRepository customerRepository;

	@PostMapping(value = "/customers")
	private Result<?> customerAdd(@Valid Customer customer, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
		}

		try {
			return ResultUtil.success(customerRepository.save(customer));

		} catch (Exception e) {
			return ResultUtil.error(100, e.getMessage());
		}

	}

	@GetMapping(value = "/customers")
	private Result<?> customersList() {

		try {
			return ResultUtil.success(customerRepository.findAll());

		} catch (Exception e) {
			return ResultUtil.error(100, e.getMessage());
		}

	}

}
