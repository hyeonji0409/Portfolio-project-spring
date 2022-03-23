package com.react.portfolio_project.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.react.portfolio_project.model.PortfolioVO;
import com.react.portfolio_project.service.PortfolioService;

@CrossOrigin("*") // http://127.0.0.1 또는 localhost 다 사용하도록
@RestController
public class PortfolioController {
    @Autowired
    PortfolioService portfolioService;  

    // 전체 포트폴리오 조회
//    @RequestMapping("/getAllPortfolio")
//    public HashMap<String, Object> getAllPortfolio(){
//        HashMap<String, Object> map = new HashMap<String, Object>();
//        map.put("portList", portfolioService.getAllPortfolio());
//        System.out.println(map);
//        return map; 
// 		ssss
//    }
    
    @RequestMapping("/getAllPortfolio/{memId}")
    public HashMap<String, Object> getAllPortfolio1(@PathVariable String memId){
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("portList", portfolioService.getAllPortfolio(memId));
        System.out.println(map);
        return map;
    }

    @RequestMapping("/insertPortfolio")
    public void insertPortfolio(PortfolioVO portfolioVO){
        portfolioService.insertPortfolio(portfolioVO);
    }
}
