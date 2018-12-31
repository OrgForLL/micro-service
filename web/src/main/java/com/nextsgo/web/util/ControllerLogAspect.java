package com.nextsgo.web.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;

@Order(5)
@Component
@Aspect
public class ControllerLogAspect {
	private Logger logger = LogManager.getLogger(ControllerLogAspect.class);

	ThreadLocal<Long> startTime = new ThreadLocal<>();
	
    @Pointcut("execution(public * com.nextsgo.web.controller.*.*(..))")
    public void controllerLog(){
    	System.out.println("AOP切面");
    }

    @Before("controllerLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
    	startTime.set(System.currentTimeMillis());
    	
    	// 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        
        // 通过这获取到方法的所有参数名称的字符串数组
        String url = request.getRequestURL().toString();
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        String[] parameterNames = methodSignature.getParameterNames();
        Object[] args = joinPoint.getArgs();
        
        // 打印至控制台
        System.out.println("Time : " + time);
        System.out.println("URL : " + url);
        System.out.println("ParamName : " + JSON.toJSONString(parameterNames));
        System.out.println("ParamValue : " + JSON.toJSONString(args));
        
        // 记录下请求内容
        logger.info("Time : " + time);
        logger.info("URL : " + url);
        logger.info("ParamName : " + JSON.toJSONString(parameterNames));
        logger.info("ParamValue : " + JSON.toJSONString(args));
    }

    @AfterReturning(returning = "ret", pointcut = "controllerLog()")
    public void doAfterReturning(Object ret) throws Throwable {
    	System.out.println("Response : " + JSON.toJSONString(ret));
    	System.out.println("Spend Time : " + ((System.currentTimeMillis() - startTime.get()) 
    			* 1.0 / 1000) + "秒");
    	
        // 处理完请求，返回内容
        logger.info("Response : " + JSON.toJSONString(ret));
        logger.info("Spend Time : " + ((System.currentTimeMillis() - startTime.get()) 
        		* 1.0 / 1000) + "秒");
    }
}
