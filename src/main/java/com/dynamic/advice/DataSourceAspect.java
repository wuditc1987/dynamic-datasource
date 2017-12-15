package com.dynamic.advice;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;

import com.dynamic.anno.DataSource;
import com.dynamic.anno.DataSourceEnum;
import com.dynamic.datasource.DataSourceHolder;

/**
 * @author Dean
 */
@Aspect
public class DataSourceAspect{
	
	public static final String EDP = "execution(* com.dynamic.dao.*.*(..))";

	@AfterReturning(EDP)
	public void afterReturning() {
		DataSourceHolder.setMaster();
	}

	
	/*public void before(JoinPoint joinPoint) {
		String methodNm = joinPoint.getSignature().getName();
		Method[] methods = joinPoint.getSignature().getDeclaringType().getDeclaredMethods();
		for (Method method : methods) {
			if (method.getName().equals(methodNm)) {
				DataSource ds = method.getAnnotation(DataSource.class);
				if (ds != null) {
					DataSourceEnum value = ds.value();
					if (value.equals(DataSourceEnum.MASTER)) {
						DataSourceSwitcher.setMaster();
					} else {
						DataSourceSwitcher.setSlave();
					}
				}
				break;
			}
		}
	}*/
	
	@Before(EDP)
	public void before(JoinPoint point){
        String method = point.getSignature().getName();
        Class<?>[] classz = point.getTarget().getClass().getInterfaces();
        Class<?>[] parameterTypes = ((MethodSignature) point.getSignature()).getMethod().getParameterTypes();
        try {
            Method m = classz[0].getMethod(method, parameterTypes);
            if (m != null && m.isAnnotationPresent(DataSource.class)) {
                DataSource data = m.getAnnotation(DataSource.class);
                if(data.value().equals(DataSourceEnum.MASTER)){
                	DataSourceHolder.setMaster();
                }else {
                	DataSourceHolder.setSlave();
				}
            }
        } catch (Exception e) {
        	System.out.println(String.format("set datasource error : %s", e.getMessage()));
        	DataSourceHolder.setMaster();
        }
	}
}
