package aa.mine.Security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginIterceptor extends HandlerInterceptorAdapter {

	/**
	 * 实现拦截器可以继承类，也可以实现类
	 * HandlerInterceptorAdapter、HandlerInterceptor 等
	 */
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("\nHandlerInterceptorAdapter:   "+"preHandle");
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("\nHandlerInterceptorAdapter:   "+"postHandle");
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("\nHandlerInterceptorAdapter:   "+"afterCompletion");
		super.afterCompletion(request, response, handler, ex);
	}

	//拦截器内未执行
	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("\nHandlerInterceptorAdapter:   "+"afterConcurrentHandlingStarted");
		super.afterConcurrentHandlingStarted(request, response, handler);
	}

}
