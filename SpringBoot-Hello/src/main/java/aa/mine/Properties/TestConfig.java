package aa.mine.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:Test/dubbo.properties")
public class TestConfig {

	@Value("${dubbo.resAddress}")
	private String resAddress;

	@Value("${dubbo.appName}")
	private String appName;

	@Value("${dubbo.resUsername}")
	private String resUsername;

	@Value("${dubbo.resPassowrd}")
	private String resPassowrd;

	@Value("${dubbo.protocol}")
	private String protocol;

	@Value("${dubbo.port}")
	private int port;

	@Value("${dubbo.accepts}")
	private int accepts;

	@Value("${dubbo.connections}")
	private int connections;

	public String getResAddress() {
		return resAddress;
	}

	public void setResAddress(String resAddress) {
		this.resAddress = resAddress;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getResUsername() {
		return resUsername;
	}

	public void setResUsername(String resUsername) {
		this.resUsername = resUsername;
	}

	public String getResPassowrd() {
		return resPassowrd;
	}

	public void setResPassowrd(String resPassowrd) {
		this.resPassowrd = resPassowrd;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getAccepts() {
		return accepts;
	}

	public void setAccepts(int accepts) {
		this.accepts = accepts;
	}

	public int getConnections() {
		return connections;
	}

	public void setConnections(int connections) {
		this.connections = connections;
	}
}
