package com.hp.idescat.cerda.metadata;

import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.validation.constraints.NotNull;

import oracle.jdbc.pool.OracleDataSource;

import org.apache.catalina.Context;
import org.apache.catalina.deploy.ContextResource;
import org.apache.catalina.startup.Tomcat;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.jndi.JndiObjectFactoryBean;

@Import(RepositoryRestMvcConfiguration.class)
@ConfigurationProperties("oracle")
@SpringBootApplication
public class SampleDataJpaApplication extends SpringBootServletInitializer {

	private final Log log = LogFactory.getLog(getClass());

	@NotNull
	private String username;

	@NotNull
	private String password;

	@NotNull
	private String url;

	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder application) {
		return application.sources(SampleDataJpaApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SampleDataJpaApplication.class, args);
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	//
//	 @Bean
//	 DataSource dataSource() throws SQLException {
//	 OracleDataSource dataSource = new OracleDataSource();
//	 log.debug("username :"+ username);
//	 dataSource.setUser(username);
//	 dataSource.setPassword(password);
//	 dataSource.setURL(url);
//	 dataSource.setImplicitCachingEnabled(true);
//	 dataSource.setFastConnectionFailoverEnabled(true);
//	 return dataSource;
//	 }

	// JNDI

	@Bean (destroyMethod="")
	DataSource jndiDataSource() throws IllegalArgumentException, NamingException {
		JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
		bean.setJndiName("java:comp/env/jdbc/myDataSource");
		bean.setProxyInterface(DataSource.class);
		bean.setLookupOnStartup(false);
		bean.afterPropertiesSet();
		return (DataSource) bean.getObject();
	}

	@Bean
	public TomcatEmbeddedServletContainerFactory tomcatFactory() {
		return new TomcatEmbeddedServletContainerFactory() {

			@Override
			protected TomcatEmbeddedServletContainer getTomcatEmbeddedServletContainer(
					Tomcat tomcat) {
				tomcat.enableNaming();
				return super.getTomcatEmbeddedServletContainer(tomcat);
			}

			@Override
			protected void postProcessContext(Context context) {
				ContextResource resource = new ContextResource();
				resource.setName("jdbc/myDataSource");
				resource.setType(OracleDataSource.class.getName());
				resource.setAuth("Container");
				resource.setType(DataSource.class.getName());
				resource.setProperty("driverClassName",
						"oracle.jdbc.OracleDriver");
				resource.setProperty("username", "andreshp");
				resource.setProperty("password", "andreshp");
				resource.setProperty("url",
						"jdbc:oracle:thin:@192.168.1.104:1521:xe");
				context.getNamingResources().addResource(resource);
			}
		};
	}

}
