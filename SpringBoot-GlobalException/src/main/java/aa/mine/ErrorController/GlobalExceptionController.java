package aa.mine.ErrorController;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 创建全局异常处理类：通过使用@ControllerAdvice定义统一的异常处理类，而不是在每个Controller中逐个定义。
 * @ControllerAdvice统一定义不同Exception映射到不同错误处理页面
 */
@ControllerAdvice
public class GlobalExceptionController {
	
	public static final String DEFAULT_ERROR_VIEW = "Thymeleaf/Default_Error";
	
	/**
	 * @ExceptionHandler用来定义函数针对的异常类型，最后将Exception对象和请求URL映射到error.html中
	 */
	@ExceptionHandler(value = Exception.class)
	 public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) 
			 throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }
	/**
	 * 通过实现上述内容之后，我们只需要在Controller中抛出Exception，
	 * 当然我们可能会有多种不同的Exception。然后在@ControllerAdvice类中，
	 * 根据抛出的具体Exception类型匹配@ExceptionHandler中配置的异常类型来匹配错误映射和处理。
	 */
}
