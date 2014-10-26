package de.hhn.labswps.ouh.codesnippet.web.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
 


@Configuration
@ComponentScan(basePackages = "de.hhn.labswps.ouh.codesnippet.web")
@EnableJpaRepositories( basePackages = {"de.hhn.labswps.ouh.codesnippet.web.repository" })
@EnableTransactionManagement
@PropertySource("classpath:environment.properties")
public class AppConfig {

	@Value("${HBM2DDL_AUTO}")
	private String HBM2DDL_AUTO;

	@Value("${SHOW_SQL}")
	private String SHOW_SQL;

	@Value("${DB_DIALECT}")
	private String DB_DIALECT;

	@Value("${DB_PASSWORD}")
	private String DB_PASSWORD;

	@Value("${DB_USER}")
	private String DB_USER;

	@Value("${DATABASE_URL}")
	private String DATABASE_URL;

	@Value("${JDBC_DRIVER}")
	private String JDBC_DRIVER;

	@Autowired
    private DataSource dataSource;
 
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(JDBC_DRIVER);
        dataSource.setUrl(DATABASE_URL);
        dataSource.setUsername(DB_USER);
        dataSource.setPassword(DB_PASSWORD);
 
        return dataSource;
    }
 
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
 
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(Database.MYSQL);
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setShowSql(true);
 
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("de.hhn.labswps.ouh.codesnippet.web");
        factory.setDataSource(dataSource());
        factory.setJpaProperties(jpaProperties());
 
        return factory;
    }
 
    private Properties jpaProperties() {  
            Properties properties = new Properties();  
 
            properties.put("hibernate.dialect", DB_DIALECT);
            properties.put("hibernate.show_sql", SHOW_SQL);  
            properties.put("hibernate.hbm2ddl.auto", HBM2DDL_AUTO);
            return properties;  
    }  
    @Bean
    public PlatformTransactionManager transactionManager() {
 
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return txManager;
    }
    
    @Bean
	public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
 
 
}
 