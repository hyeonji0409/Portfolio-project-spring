package com.react.portfolio_project.model;

public class PortfolioVO {
    // Portfolio Data
    private String memId;
    private int portStackNo;
    private int portNo;
    private String portTitle;
    private String portSubTitle;
    private String gitLink;
    private String portDetails;

    // stack Data
    private int stackNo;
    private String stackName;

    public PortfolioVO(String memId, int portStackNo, int portNo, String portTitle, String portSubTitle, String gitLink, String portDetails, int stackNo, String stackName) {
        super();
        this.memId = memId;
        this.portStackNo = portStackNo;
        this.portNo = portNo;
        this.portTitle = portTitle;
        this.portSubTitle = portSubTitle;
        this.gitLink = gitLink;
        this.portDetails = portDetails;
        this.stackNo = stackNo;
        this.stackName = stackName;
    }

    public String getMemNo() {
        return memId;
    }

    public void setMemNo(String memId) {
        this.memId = memId;
    }

    public int getPortStackNo() {
        return portStackNo;
    }

    public void setPortStackNo(int portStackNo) {
        this.portStackNo = portStackNo;
    }

    public int getPortNo() {
        return portNo;
    }

    public void setPortNo(int portNo) {
        this.portNo = portNo;
    }

    public String getPortTitle() {
        return portTitle;
    }

    public void setPortTitle(String portTitle) {
        this.portTitle = portTitle;
    }

    public String getPortSubTitle() {
        return portSubTitle;
    }

    public void setPortSubTitle(String portSubTitle) {
        this.portSubTitle = portSubTitle;
    }

    public String getGitLink() {
        return gitLink;
    }

    public void setGitLink(String gitLink) {
        this.gitLink = gitLink;
    }

    public String getPortDetails() {
        return portDetails;
    }

    public void setPortDetails(String portDetails) {
        this.portDetails = portDetails;
    }

    public int getStackNo() {
        return stackNo;
    }

    public void setStackNo(int stackNo) {
        this.stackNo = stackNo;
    }

    public String getStackName() {
        return stackName;
    }

    public void setStackName(String stackName) {
        this.stackName = stackName;
    }

    @Override
    public String toString() {
        return "PortfolioVO{" +
                "memId=" + memId +
                ", portStackNo=" + portStackNo +
                ", portNo=" + portNo +
                ", portTitle='" + portTitle + '\'' +
                ", portSubTitle='" + portSubTitle + '\'' +
                ", gitLink='" + gitLink + '\'' +
                ", portDetails='" + portDetails + '\'' +
                ", stackNo=" + stackNo +
                ", stackName='" + stackName + '\'' +
                '}';
    }
}
