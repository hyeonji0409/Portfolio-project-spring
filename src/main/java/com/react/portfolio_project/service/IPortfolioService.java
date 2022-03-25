package com.react.portfolio_project.service;

import com.react.portfolio_project.model.PortfolioVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface IPortfolioService {
    public ArrayList<PortfolioVO> getAllPortfolio(String memId); // 전체 포트폴리오 조회
    void insertPortfolio(PortfolioVO portfolioVo); // 포트폴리오 등록
    public PortfolioVO portfolioDetailView(int portNo); // 포트폴리오 상세 정보 조회
    void deletePortfolio(int portNo); // 삭제
}
