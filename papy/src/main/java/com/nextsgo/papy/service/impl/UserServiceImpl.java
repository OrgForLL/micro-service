package com.nextsgo.papy.service.impl;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextsgo.common.entity.Result;

import com.nextsgo.papy.entity.User;
import com.nextsgo.papy.enums.ErrorStatusEnum;
import com.nextsgo.papy.repository.UserRepository;
import com.nextsgo.papy.service.UserService;
import com.nextsgo.papy.utils.JpaUpdateTool;
import com.nextsgo.papy.utils.JwtProperties;
import com.nextsgo.papy.utils.JwtUtil;
import com.nextsgo.papy.utils.MD5Utils;
import com.nextsgo.papy.utils.ResultUtilExt;
import com.nextsgo.papy.vo.UserVO;

@Service
public class UserServiceImpl implements UserService{
	// @Autowired
	// private EntityManager entityManager;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private JwtProperties jwtProperties;

	public Result<?> findAll() {
		try {
			return ResultUtilExt.success(userRepository.findAll());
		} catch (Exception e) {
			return ResultUtilExt.error(ErrorStatusEnum.userError, e.getMessage());
		}
	}

	public Result<?> userAdd(User user) {
		if(null != user.getPassword()) user.setPassword(MD5Utils.getPwd(user.getPassword()));
		try {
			if (null != user.getId()) {
				User userSrc=userRepository.findById(user.getId());
				if (null != userSrc) {					
					JpaUpdateTool.copyNullProperties(userSrc, user);
					return ResultUtilExt.success(userRepository.save(user));
				}else {
					return ResultUtilExt.error(ErrorStatusEnum.userId);
				}
			} else {
				if (null != userRepository.findByName(user.getName())) {
					return ResultUtilExt.error(ErrorStatusEnum.userNameIsExit);
				} else if (null != userRepository.findByFullName(user.getFullName())) {
					return ResultUtilExt.error(ErrorStatusEnum.userFullNameIsExit);
				} else {
					return ResultUtilExt.success(userRepository.save(user));
				}
			}
		} catch (Exception e) {
			return ResultUtilExt.error(ErrorStatusEnum.userError, e.getMessage());
		}
	}

	public Result<?> findUserById(Long id) {
		try {
			User user = userRepository.findById(id);
			if (null == user) {
				return ResultUtilExt.error(ErrorStatusEnum.userId);
			} else {
				return ResultUtilExt.success(user);
			}
		} catch (Exception e) {
			return ResultUtilExt.error(ErrorStatusEnum.userError, e.getMessage());
		}

	}

	public Result<?> login(String name, String pwd) {
		try {
			User user = userRepository.findByName(name);
			if (null == user) {
				return ResultUtilExt.error(ErrorStatusEnum.userInvalidName);
			} else {
				if (MD5Utils.getPwd(pwd).equals(user.getPassword())) {
					// fastjson序列化会无限循环，使用VO
					UserVO  userVO= new UserVO();
					JpaUpdateTool.copyNullProperties(user, userVO);
					userVO.setToken(JwtUtil.createJWT(1000 * 60 * 60 * 24, jwtProperties.getKey(), user));
					userVO.getAccountList().forEach(iteam->{iteam.setUserList(null);});
					return ResultUtilExt.success(userVO);
				} else {
					return ResultUtilExt.error(ErrorStatusEnum.userInvalidPsw);
				}
			}
		} catch (Exception e) {
			return ResultUtilExt.error(ErrorStatusEnum.userError, e.getMessage());
		}
	}

	public Result<?> userAccount(String name) {
		try {
			return null;
			// User user = findByName(name);
			// if (null == user) {
			// return ResultUtilExt.error(ErrorStatusEnum.userInvalidName);
			// } else {
			// if (MD5Utils.getPwd(pwd).equals(user.getPassword())) {
			// JSONObject jsonObject = (JSONObject) JSONObject.toJSON(user);
			// jsonObject.put("token", JwtUtil.createJWT(1000 * 60 * 60 * 24,
			// jwtProperties.getKey(), user));
			// return ResultUtilExt.success(jsonObject);
			// } else {
			// return ResultUtilExt.error(ErrorStatusEnum.userInvalidPsw);
			// }
			// }
		} catch (Exception e) {
			return ResultUtilExt.error(ErrorStatusEnum.error, e.getMessage());
		}
	}	
	
	// findUserById
	// @SuppressWarnings("unchecked")
	// public List<User> findAllByViaQuery(String name) {
	// List<User> contacts = this.entityManager
	// .createNativeQuery("select id,name,pass_word,create_date,createor_id,
	// full_name from user where name like :name", "userMapping")
	// .setParameter("name", name)
	// .setMaxResults(5)
	// .getResultList();
	//
	// return contacts;
	// }
}
