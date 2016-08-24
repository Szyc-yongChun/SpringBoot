//package aa.mine.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
//
///**
// * 自己定义注册的数据源
// * @author Administrator
// *
// */
////@Configuration
//public class DataSource {
//
//	@Value("${jdbc.url}")
//	private String url;
//
//	@Value("${jdbc.username}")
//	private String username;
//
//	@Value("${jdbc.password}")
//	private String password;
//
//	@Value("${jdbc.driverclass}")
//	private String driverclass;
//
//	@Bean
//	public MysqlDataSource getMySqlDataSource() {
//		MysqlDataSource datasource = new MysqlDataSource();
//		datasource.setUser(username);
//		datasource.setPassword(password);
//		datasource.setUrl(url);	
//		return datasource;
//	}
//	
//	public String getUrl() {
//		return url;
//	}
//
//	public void setUrl(String url) {
//		this.url = url;
//	}
//
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public String getDriverclass() {
//		return driverclass;
//	}
//
//	public void setDriverclass(String driverclass) {
//		this.driverclass = driverclass;
//	}
//
//}
