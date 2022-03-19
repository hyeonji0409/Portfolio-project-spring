package com.react.portfolio_project; 

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.react.portfolio_project.controller.MainController;
import com.react.portfolio_project.controller.MemberController;
import com.react.portfolio_project.dao.IMemberDAO;

@SpringBootApplication
@ComponentScan(basePackageClasses = MainController.class)
@ComponentScan(basePackageClasses = ReactController.class)
@ComponentScan(basePackageClasses = MemberController.class)

@MapperScan(basePackageClasses = IMemberDAO.class)
public class PortfolioProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioProjectApplication.class, args);
	}

}
