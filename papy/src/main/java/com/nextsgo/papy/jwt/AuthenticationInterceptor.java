package com.nextsgo.papy.jwt;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.nextsgo.common.entity.Result;
import com.nextsgo.papy.utils.JwtProperties;
import com.nextsgo.papy.utils.JwtUtil;
import com.nextsgo.papy.utils.ResultUtilExt;

import io.jsonwebtoken.ExpiredJwtException;

import com.nextsgo.papy.entity.User;
import com.nextsgo.papy.enums.ErrorStatusEnum;
import com.nextsgo.papy.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class AuthenticationInterceptor implements HandlerInterceptor {
	@Autowired
	UserService userService;
	@Autowired
	JwtProperties jwtProperties;
	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Object object) throws Exception {

		// 从 http 请求头中取出 token
		String token = httpServletRequest.getHeader("token");
		// 如果不是映射到方法直接通过
		if (!(object instanceof HandlerMethod)) {
			return true;
		}

		HandlerMethod handlerMethod = (HandlerMethod) object;
		Method method = handlerMethod.getMethod();
		// 检查是否有LoginToken注释，有则跳过认证
		if (method.isAnnotationPresent(LoginToken.class)) {
			LoginToken loginToken = method.getAnnotation(LoginToken.class);
			if (loginToken.required()) {
				return true;
			}
		}

		// 检查有没有需要用户权限的注解
		if (method.isAnnotationPresent(CheckToken.class)) {
			CheckToken checkToken = method.getAnnotation(CheckToken.class);
			if (checkToken.required()) {			
				// 执行认证
				if (token == null) {
					httpServletResponse.addHeader("Content-Type", "application/json; charset=UTF-8");
					httpServletResponse.getWriter()
							.append(JSON.toJSONString(ResultUtilExt.error(ErrorStatusEnum.errorToken))).flush();
					return false;
				}
				// 获取 token 中的 user id
				String userId;
				try {
					userId = JWT.decode(token).getClaim("id").asString();
				} catch (JWTDecodeException j) {
					httpServletResponse.addHeader("Content-Type", "application/json; charset=UTF-8");
					httpServletResponse.getWriter()
							.append(JSON.toJSONString(ResultUtilExt.error(ErrorStatusEnum.errorAccessException)))
							.flush();
					return false;
				}
				Result<?> userWrap = userService.findUserById(Long.parseLong(userId));
				if (!userWrap.getErrcode().equals(0)) {
					httpServletResponse.addHeader("Content-Type", "application/json; charset=UTF-8");
					httpServletResponse.getWriter()
							.append(JSON.toJSONString(ResultUtilExt.error(ErrorStatusEnum.errorInvalidname))).flush();
					return false;
				}
				try {
					Boolean verify = JwtUtil.isVerify(token, jwtProperties.getKey(),(User) userWrap.getData());
					if (!verify) {
						httpServletResponse.addHeader("Content-Type", "application/json; charset=UTF-8");
						httpServletResponse.getWriter()
								.append(JSON.toJSONString(ResultUtilExt.error(ErrorStatusEnum.errorIllegalAccess)))
								.flush();
						return false;
					}
				} catch (ExpiredJwtException e) {
					//超时异常
					httpServletResponse.addHeader("Content-Type", "application/json; charset=UTF-8");
					httpServletResponse.getWriter()
							.append(JSON.toJSONString(ResultUtilExt.error(ErrorStatusEnum.errorExpiredJwt)))
							.flush();
					return false;
				}
				return true;
			}
		}
		return true;

	}

	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Object o, Exception e) throws Exception {

	}
}
