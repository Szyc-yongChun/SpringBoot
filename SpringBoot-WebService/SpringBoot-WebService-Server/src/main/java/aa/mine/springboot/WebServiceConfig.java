package aa.mine.springboot;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import aa.mine.springboot.service.RemoteService;

@Configuration
public class WebServiceConfig {

	@Bean
	public ServletRegistrationBean dispatcherServlet() {
		ServletRegistrationBean servletDef = new ServletRegistrationBean(new CXFServlet(), "/soap/*");
		servletDef.setLoadOnStartup(1);
		return servletDef;
	}

	@Bean(name = Bus.DEFAULT_BUS_ID)
	public SpringBus springBus() {
		return new SpringBus();
	}

	@Bean
	public RemoteService remoteService() {
		return new RemoteService();
	}

	@Bean
	public Endpoint endpoint() {
		EndpointImpl endpoint = new EndpointImpl(springBus(), remoteService());
		endpoint.publish("/remoteService");
		return endpoint;
	}
}