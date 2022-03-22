package com.nextsgo.papy.service.impl;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.nextsgo.common.entity.Result;
import com.nextsgo.papy.entity.Menu;

import com.nextsgo.papy.enums.ErrorStatusEnum;
import com.nextsgo.papy.repository.MenuRepository;

import com.nextsgo.papy.service.MenuService;
import com.nextsgo.papy.utils.JpaUpdateTool;

import com.nextsgo.papy.utils.ResultUtilExt;


@Service
public class MenuServiceImpl implements  MenuService{
	@Autowired
	private MenuRepository menuRepository;


	public Result<?> findAll() {
		try {
			return ResultUtilExt.success(menuRepository.findAll());
		} catch (Exception e) {
			return ResultUtilExt.error(ErrorStatusEnum.menuError, e.getMessage());
		}
	}

	public Result<?> menuAdd(Menu menu) {		
		try {
			if (null != menu.getId()) {
				Menu menuSrc=menuRepository.findById(menu.getId());
				if (null != menuSrc) {					
					JpaUpdateTool.copyNullProperties(menuSrc, menu);
					return ResultUtilExt.success(menuRepository.save(menu));
				}else {
					return ResultUtilExt.error(ErrorStatusEnum.menuId);
				}
			} else {
				if (null != menuRepository.findByName(menu.getName())) {
					return ResultUtilExt.error(ErrorStatusEnum.menuNameIsExit);		
				} else {
					return ResultUtilExt.success(menuRepository.save(menu));
				}
			}
		} catch (Exception e) {
			return ResultUtilExt.error(ErrorStatusEnum.userError, e.getMessage());
		}
	}

	public Result<?> findMenuById(Long id) {
		try {
			Menu menu = menuRepository.findById(id);
			if (null == menu) {
				return ResultUtilExt.error(ErrorStatusEnum.menuId);
			} else {
				return ResultUtilExt.success(menu);
			}
		} catch (Exception e) {
			return ResultUtilExt.error(ErrorStatusEnum.menuError, e.getMessage());
		}

	}

 
}
