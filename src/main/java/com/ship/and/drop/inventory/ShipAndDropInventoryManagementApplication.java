package com.ship.and.drop.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;

@SpringBootApplication
@EnableJpaRepositories // ("com.ship.and.drop.inventory.repository")
@ComponentScan(basePackages = "com.ship.and.drop.inventory")
@EnableAutoConfiguration//(exclude = { DataSourceAutoConfiguration.class })
public class ShipAndDropInventoryManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShipAndDropInventoryManagementApplication.class, args);
	}

	@Bean(name = "entityManagerFactory")
	public LocalEntityManagerFactoryBean entityManagerFactory() {
		LocalEntityManagerFactoryBean bean = new LocalEntityManagerFactoryBean();
		bean.setJpaDialect(new HibernateJpaDialect());
		bean.setPersistenceUnitName("entityManagerFactory");
		return bean;
	}

}
