package com.nextsgo.papy.controller;

import org.springframework.web.bind.annotation.RestController;



@RestController
public class LoginController {
//	@Autowired
//	private UserRepository userRepository;
//	
//	@PostMapping(value = "/login")
//	private Result<?> login(HttpServletRequest request) {
//		String code = request.getParameter("code");
//		String password = request.getParameter("password");
//		if (null == code || code.length() == 0) {
//			return ResultUtil.error(500, "require  code");
//		}
//		if (null == password || password.length() == 0) {
//			return ResultUtil.error(501, "require  password");
//		}
//		List<User> listUser = userRepository.findByNameAndPassword(code, MD5Utils.getPwd(password));
//		if (listUser.size() > 1) {
//			return ResultUtil.error(300, "no unique user");
//		} else if (listUser.size() == 0) {
//			return ResultUtil.error(400, "no user");
//		} else {
//			return ResultUtil.success(listUser.get(0));
//		}
//	}
//    /**
//     * 新增用户
//     * @return
//     */
//    @PostMapping(value = "/adduser")
//    public Result<?> girlUser(@Valid User USER, BindingResult bindingResult){
//        if(bindingResult.hasErrors()){
//            return  ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
//        }
//        return ResultUtil.success(userRepository.save(USER));
//    }
	
}
