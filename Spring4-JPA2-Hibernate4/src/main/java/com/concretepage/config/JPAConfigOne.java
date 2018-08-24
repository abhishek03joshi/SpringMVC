package com.concretepage.config;  
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@Configuration 
@ComponentScan("com.concretepage")
@EnableTransactionManagement
public class JPAConfigOne {  
	@Bean
	public JpaTransactionManager jpaTransMan(){
		JpaTransactionManager jtManager = new JpaTransactionManager(
				getEntityManagerFactoryBean().getObject()); //entity layer is the layer between the front end and the back end. Manages the access of multiple user.
		return jtManager;
	}
	@Bean
	public LocalEntityManagerFactoryBean getEntityManagerFactoryBean() {
		LocalEntityManagerFactoryBean lemfb = new LocalEntityManagerFactoryBean();
		lemfb.setPersistenceUnitName("localEntity");
		return lemfb;
	}
}