package com.io.rest.bulkupload.api.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DBConfig {
    private final Logger logger = LoggerFactory.getLogger(DBConfig.class);

    @Bean(name = "mysqlDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource getDataSource()
    {
        logger.info("DataSource initialized : ");
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "mysqlTemplate")
    @Autowired
    public JdbcTemplate getTemplate(@Qualifier("mysqlDataSource") DataSource ds)
    {
        logger.info("JDBC Template initialized : ");
        return new JdbcTemplate(ds);
    }
}
