package com.nsd.payment_app.logging;

import java.time.LocalDateTime;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;

@Component
@Aspect
public class ApplicationLogs {

	static boolean requestEntry = false;

	@Pointcut(value = "execution(* com.nsd.payment_app.*.*.*(..) )")
	public void myPointcut() {

	}

	@Around("myPointcut()")
	public Object logsData(ProceedingJoinPoint point) throws Throwable {

		ObjectMapper mapper = new ObjectMapper();
		Object object = point.proceed();

		if (requestEntry) {
			String method = point.getSignature().getName();
			Object[] args = point.getArgs();
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
					.getRequest();
			System.out.println("Method :: " + method + " \nArgs :: " + mapper.writeValueAsString(args)
					+ " \nEnd Point :: " + request.getRequestURI() + " \nMethod Type :: " + request.getMethod()
					+ " \nTime :: " + LocalDateTime.now());
			return object;
		} else {
			ApplicationLogs.requestEntry = true;
			return object;
		}

	}
}
