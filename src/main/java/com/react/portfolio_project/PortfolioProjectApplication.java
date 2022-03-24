package com.react.portfolio_project; 

import com.react.portfolio_project.controller.PortfolioController;
import com.react.portfolio_project.controller.ScheduleController;
import com.react.portfolio_project.dao.IPortfolioDAO;
import com.react.portfolio_project.dao.IScheduleDAO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.react.portfolio_project.controller.MainController;
import com.react.portfolio_project.controller.MemberController;
import com.react.portfolio_project.dao.IMemberDAO;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan(basePackageClasses = MainController.class)
@ComponentScan(basePackageClasses = ReactController.class)
@ComponentScan(basePackageClasses = MemberController.class)
@ComponentScan(basePackageClasses = PortfolioController.class)
@ComponentScan(basePackageClasses = ScheduleController.class)

@MapperScan(basePackageClasses = IMemberDAO.class)
@MapperScan(basePackageClasses = IPortfolioDAO.class)
@MapperScan(basePackageClasses = IScheduleDAO.class)
public class PortfolioProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioProjectApplication.class, args);
	}

}
