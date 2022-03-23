package com.react.portfolio_project.service;

import com.react.portfolio_project.dao.IPortfolioDAO;
import com.react.portfolio_project.model.PortfolioVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PortfolioService implements IPortfolioService{
    @Autowired
    IPortfolioDAO dao;

    @Override
    public ArrayList<PortfolioVO> getAllPortfolio() {
        return dao.getAllPortfolio();
    }

    @Override
    public void insertPortfolio(PortfolioVO portfolioVo) {
        dao.insertPortfolio(portfolioVo);
    }

    @Override
    public PortfolioVO portfolioDetailView(int portNo) {
        return dao.portfolioDetailView(portNo);
    }
}
