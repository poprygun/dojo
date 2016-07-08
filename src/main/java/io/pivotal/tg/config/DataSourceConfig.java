package io.pivotal.tg.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.cloud.service.PooledServiceConnectorConfig;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

//@Profile("cloud")
//@Configuration
//todo this bean breaks eureka discovery service
public class DataSourceConfig extends AbstractCloudConfig {
    public static final String DEFAULT_DB_MAX_POOL_SIZE = "10";

    public static final String DEFAULT_DB_MAX_WAIT_TIME = "200";

    @Autowired
    Environment env;

    @Bean
    public DataSource dataSource() {

        int maxPoolSize =
                Integer.parseInt(env.getProperty("DB_MAX_POOL_SIZE", DEFAULT_DB_MAX_POOL_SIZE));
        int maxWaitTime =
                Integer.parseInt(env.getProperty("DB_MAX_WAIT_TIME", DEFAULT_DB_MAX_WAIT_TIME));

        PooledServiceConnectorConfig.PoolConfig poolConfig =
                new PooledServiceConnectorConfig.PoolConfig(maxPoolSize, maxWaitTime);

        org.springframework.cloud.service.relational.DataSourceConfig.ConnectionConfig connectionConfig =
                new org.springframework.cloud.service.relational.DataSourceConfig.ConnectionConfig("characterEncoding=UTF-8");

        return connectionFactory().dataSource(new org.springframework.cloud.service.relational.DataSourceConfig(poolConfig, connectionConfig));

    }
}
