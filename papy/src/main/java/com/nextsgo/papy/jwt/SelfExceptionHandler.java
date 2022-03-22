package com.nextsgo.papy.jwt;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 异常处理类，暂时没有用。
 * @author min
 *
 */
public class SelfExceptionHandler implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
        //String msg = GlobalExceptionHandler.getThrowableStackInfo(ex);
        String msg=ex.getMessage();
        try {
            response.addHeader("Content-Type", "text/html; charset=UTF-8");
            response.getWriter().append("自定义异常处理!!! \n").append(msg).flush();
        } catch (Exception e) {
            e.printStackTrace();
        }        
		return null;
	}
}
