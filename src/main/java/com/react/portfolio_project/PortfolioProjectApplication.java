package com.react.portfolio_project;

import com.react.portfolio_project.controller.MainController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = MainController.class)
@ComponentScan(basePackageClasses = ReactController.class)
public class PortfolioProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioProjectApplication.class, args);
	}

}
