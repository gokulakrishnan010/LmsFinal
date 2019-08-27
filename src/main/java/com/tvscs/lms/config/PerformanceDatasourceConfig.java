package com.tvscs.lms.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
public class PerformanceDatasourceConfig {

	@Bean(name = "perfdatasource")
	@ConfigurationProperties(prefix = "spring.performance.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate(@Qualifier("perfdatasource") DataSource dataSource) {
		return new NamedParameterJdbcTemplate(dataSource);
	}
	
}
