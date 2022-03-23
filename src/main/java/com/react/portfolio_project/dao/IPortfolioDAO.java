package com.react.portfolio_project.dao;

import com.react.portfolio_project.model.PortfolioVO;

import java.util.ArrayList;

public interface IPortfolioDAO {
    public ArrayList<PortfolioVO> getAllPortfolio(String memId); // 전체 포트폴리오 조회
    void insertPortfolio(PortfolioVO portfolioVo); // 포트폴리오 등록
}
