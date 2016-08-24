package aa.mine.ErrorController;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import aa.mine.Entity.ErrorInfo;
import javassist.NotFoundException;

/**
 * 当我们要实现RESTful API时，返回的错误是JSON格式的数据
 * 本质上，只需在@ExceptionHandler之后加入@ResponseBody，
 * 就能让处理函数return的内容转换为JSON格式.
 */
@ControllerAdvice
public class JsonExceptionController {

	@ExceptionHandler(value = NotFoundException.class)
    @ResponseBody
    public ErrorInfo<Object,String> jsonErrorHandler(HttpServletRequest req, NotFoundException e) throws Exception {
        ErrorInfo<Object,String> r = new ErrorInfo<>();
        r.setMessage(e);
        r.setCode(ErrorInfo.ERROR);
        r.setData("Some Data");
        r.setUrl(req.getRequestURL().toString());
        return r;
    }
}
