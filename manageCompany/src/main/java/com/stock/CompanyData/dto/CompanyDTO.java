package com.stock.CompanyData.dto;

import javax.persistence.*;

@Entity
@Table(name="company")
public class CompanyDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="company_name")
    private String companyName;
    @Column(name="turnover")
    private String turnover;
    @Column(name="ceo")
    private String ceo;
    @Column(name="stock_exchange")
    private String stockExchange;
    @Column(name="board_director")
    private String boardDirector;
    @Column(name="sector")
    private String sector;
    @Column(name="writeup")
    private String writeup;
    @Column(name="company_code")
    private String companyCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTurnover() {
        return turnover;
    }

    public void setTurnover(String turnover) {
        this.turnover = turnover;
    }

    public String getCeo() {
        return ceo;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }

    public String getStockExchange() {
        return stockExchange;
    }

    public void setStockExchange(String stockExchange) {
        this.stockExchange = stockExchange;
    }

    public String getBoardDirector() {
        return boardDirector;
    }

    public void setBoardDirector(String boardDirector) {
        this.boardDirector = boardDirector;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getWriteup() {
        return writeup;
    }

    public void setWriteup(String writeup) {
        this.writeup = writeup;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }
}
