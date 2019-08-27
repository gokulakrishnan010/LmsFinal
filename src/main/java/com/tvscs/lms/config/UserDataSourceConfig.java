package com.tvscs.lms.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory", basePackages = {"com.tvscs.lms.repo"})
public class UserDataSourceConfig {

	@Primary
	@Bean(name = "empDataSource")
	@ConfigurationProperties(prefix = "spring.employee.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean containerEntityManagerFactoryBean(EntityManagerFactoryBuilder
			builder,@Qualifier("empDataSource") DataSource dataSource) {
		Map<String,Object> properties = new HashMap<>();
		properties.put("org.hibernate.hbm2ddl.auto", "update");  
		properties.put("org.hibernate.dialect", "org.hibernate.dialect.Oracle12cDialect");
		return builder.dataSource(dataSource)
				.properties(properties).packages("com.tvscs.lms.model").build();

	}
	@Primary
	@Bean(name = "transactionManager")
	public PlatformTransactionManager platformTransactionManager(@Qualifier("entityManagerFactory")EntityManagerFactory 
			entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

}
