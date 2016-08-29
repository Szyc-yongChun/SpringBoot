                .   ____          _            __ _ _
               /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
              ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
               \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
                '  |____| .__|_| |_|_| |_\__, | / / / /
               =========|_|==============|___/=/_/_/_/
               :: Spring Boot ::        (v1.3.2.RELEASE)
			   
                       Spring Boot Learning
					   
第一个项目：SpringBoot-Hello spring boot的入门程序
            
			快速入门                    快速开发一个WEB项目
			属性配置文件详解            spring boot在开发、测试、生产环境的配置切换，自定义属性的配置
			构建RESTful API与单元测试   spring boot对RESTful API的支持
			开发Web应用                 spring boot对Velocity、Thymeleaf、FreeMarker模板引擎的支持
			
第二个项目：SpringBoot-Swagger2 
            
			Swagger2可以轻松的整合到Spring Boot中，并与Spring MVC程序配合组织出强大RESTful API文档
			既可以减少我们创建文档的工作量，同时说明内容又整合入实现代码中，让维护文档和修改代码整合为一体，
			可以让我们在修改代码逻辑的同时方便的修改文档说明。另外Swagger2也提供了强大的页面测试功能来调试每个RESTful API。
            		
					
第三个项目：SpringBoot-GlobalException  

            做Web应用的时候，请求处理过程中发生错误是非常常见的情况。Spring Boot提供了一个默认的映射：/error，
			当处理中抛出异常之后，会转到该请求中处理，并且该请求有一个全局的错误页面用来展示异常内容。
			
            虽然Spring Boot中实现了默认的error映射，但是在实际应用中，上面你的错误页面对用户来说并不够友好，
			我们通常需要去实现我们自己的异常提示。  

			
第四个项目：SpringBoot-JdbcTemplate  spring boot整合JDBC以及相应的多数据源的配置
            
			在Spring Boot下访问数据库的配置依然秉承了框架的初衷：简单。我们只需要在pom.xml中加入数据库依赖，
			再到application.properties中配置连接信息，不需要像Spring应用中创建JdbcTemplate的Bean，
			就可以直接在自己的对象中注入使用。
			
			对于单个数据源，Spring Boot能够自动在application.properties获取数据库连接信息，生成数据源并注入到
			JdbcTemplate模板中，只需把JdbcTemplate注入DAO/service 层即可实现对数据库的操作
			
			对于多个数据源，需要自己配置多个数据库信息并生成对应的数据源DataSource，
			再将DataSource注入到相应的JdbcTemplate模板中，使用时根据需要注入JdbcTemplate模板
			
			
第五个项目：SpringBoot-SpringData  Spring-data-jpa的整合以及多数据源的配置
            
			Spring Boot中使用Spring-data-jpa让数据访问更简单、更优雅 
			             通过解析方法名创建查询
						 @Query
			Spring-data-jpa实现了面向接口的编写方式，只需要通过编写一个继承自JpaRepository的接口就能完成数据访问
			spring.jpa.properties.hibernate.hbm2ddl.auto=XXX 是hibernate的配置属性，其主要作用是：自动创建、更新、验证数据库表结构


			
第六个项目：SpringBoot-Swagger2  Swagger2可以轻松的整合到Spring Boot中，并与Spring MVC程序配合组织出强大RESTful API文档
            
			构建RESTful API与单元测试
			开发Web应用  



			
第七个项目：SpringBoot-Swagger2  Swagger2可以轻松的整合到Spring Boot中，并与Spring MVC程序配合组织出强大RESTful API文档
            
			构建RESTful API与单元测试
			开发Web应用  



			
第八个项目：SpringBoot-Swagger2  Swagger2可以轻松的整合到Spring Boot中，并与Spring MVC程序配合组织出强大RESTful API文档
            
			构建RESTful API与单元测试
			开发Web应用  			
			

              