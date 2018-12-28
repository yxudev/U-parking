package com.yishan.javaplus.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;


//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@Configuration
@EnableTransactionManagement
public class DSInizler {
//    protected String databaseUrl = "jdbc:postgresql://localhost:5432/jp";
//    protected String databaseUserName = "yishan";
//    protected String databasePassword = "JZM1926";
//    protected String driverClassName = "org.postgresql.ds.PGSimpleDataSource";

    @Autowired
    private Environment environment;
    @Value("#{ applicationProperties['database.servername']}")
    protected String databaseUrl;
    @Value("#{ applicationProperties['database.username']}")
    protected String databaseUserName = "";
    @Value("#{ applicationProperties['database.password']}")
    protected String databasePassword = "";
    @Value("#{ applicationProperties['database.dataSourceClassName']}")
    protected String driverClassName;

    @Bean(name= "dataSource")
    public DataSource getDataSource(){
        DataSource dataSource = createDataSource();
        return dataSource;
    }

    private final Logger logger = LoggerFactory.getLogger(getClass());



    private BasicDataSource createDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(databaseUrl);
        dataSource.setUsername(databaseUserName);
        dataSource.setPassword(databasePassword);
//        dataSource.setValidationQuery(databaseValidationQuery);
        dataSource.setTestOnBorrow(true);
        dataSource.setTestOnReturn(true);
        dataSource.setTestWhileIdle(true);
        dataSource.setTimeBetweenEvictionRunsMillis(1800000);
        dataSource.setNumTestsPerEvictionRun(3);
        dataSource.setMinEvictableIdleTimeMillis(1800000);
        return dataSource;
    }
    @Bean(name="entityManagerFactory")
    @Profile("unit")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

        factoryBean.setDataSource(getDataSource());
        factoryBean.setPackagesToScan(new String[] { "com.yishan.javaplus.domain","com.yishan.javaplus.repository" });
        factoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        Properties props = new Properties();
        props.put("hibernate.dialect", "org.hibernate.spatial.dialect.postgis.PostgisDialect");
        props.put("hibernate.hbm2ddl.auto", "validate");
//        props.put("hibernate.physical_naming_strategy", "com.overture.family.extend.hibernate.ImprovedNamingStrategy")
        props.put("hibernate.connection.charSet","UTF-8");
        props.put("hibernate.show_sql","true");
//        props.put("")


//            <property name="hibernate.ejb.interceptor" value="com.overture.family.repository.jpa.DBNullsFirstLastInteceptor"/>

        factoryBean.setJpaProperties(props);

        return factoryBean;
    }
}