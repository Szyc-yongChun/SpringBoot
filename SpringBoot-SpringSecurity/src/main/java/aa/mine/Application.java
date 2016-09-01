package aa.mine;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import aa.mine.Security.LoginIterceptor;


@SpringBootApplication
public class Application extends WebMvcConfigurerAdapter  {

	/**
	 * 继承WebMvcConfigurerAdapter配置MVC
	 * 此处配置了拦截器
	 */
	
	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);

	}

	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		// TODO Auto-generated method stub
		super.addFormatters(registry);
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		// TODO Auto-generated method stub
		super.configureMessageConverters(converters);
	}

	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		// TODO Auto-generated method stub
		super.extendMessageConverters(converters);
	}

	@Override
	public Validator getValidator() {
		// TODO Auto-generated method stub
		return super.getValidator();
	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		// TODO Auto-generated method stub
		super.configureContentNegotiation(configurer);
	}

	@Override
	public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
		// TODO Auto-generated method stub
		super.configureAsyncSupport(configurer);
	}

	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		// TODO Auto-generated method stub
		super.configurePathMatch(configurer);
	}

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		// TODO Auto-generated method stub
		super.addArgumentResolvers(argumentResolvers);
	}

	@Override
	public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {
		// TODO Auto-generated method stub
		super.addReturnValueHandlers(returnValueHandlers);
	}

	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
		// TODO Auto-generated method stub
		super.configureHandlerExceptionResolvers(exceptionResolvers);
	}

	@Override
	public MessageCodesResolver getMessageCodesResolver() {
		// TODO Auto-generated method stub
		return super.getMessageCodesResolver();
	}

	//加入拦截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(new LoginIterceptor()).addPathPatterns("/**").excludePathPatterns("/login");
		super.addInterceptors(registry);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// TODO Auto-generated method stub
		super.addViewControllers(registry);
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// TODO Auto-generated method stub
		super.configureViewResolvers(registry);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		super.addResourceHandlers(registry);
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// TODO Auto-generated method stub
		super.configureDefaultServletHandling(configurer);
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// TODO Auto-generated method stub
		super.addCorsMappings(registry);
	}

}
