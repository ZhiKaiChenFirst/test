package cn.test.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class UserInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("UserInterceptor过滤器已执行�?");
		return invocation.invoke();
	}

}
