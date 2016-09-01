package aa.mine.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 *   ● 通过@EnableWebSecurity注解开启Spring Security的功能
	 *   ● 继承WebSecurityConfigurerAdapter，并重写它的方法来设置一些web安全的细节
	 */
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/**
		 * ○ 通过authorizeRequests()定义哪些URL需要被保护、哪些不需要被保护。
		 * 
		 * ○ 通过formLogin()定义当需要用户登录时候，转到的登录页面。
		 */
		http.authorizeRequests().antMatchers("/", "/home").permitAll().anyRequest()
		    .authenticated().and().formLogin()
			.loginPage("/login").permitAll().and().logout().permitAll();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		//可配置多个角色
		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
		auth.inMemoryAuthentication().withUser("aaa").password("aaa").roles("USER");
	}

}