package com.stock.CompanyData.model;

public class Company {
    private Long id;
    private String companyName;
    private String turnover;
    private String ceo;
    private String stockExchange;
    private String boardDirector;
    private String sector;
    private String writeup;
    private String companyCode;

    public Long getId() {
        return id;
    }
    
    

    public Company() {
		super();
	}



	public Company(Long id, String companyName, String turnover, String ceo, String stockExchange, String boardDirector,
			String sector, String writeup, String companyCode) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.turnover = turnover;
		this.ceo = ceo;
		this.stockExchange = stockExchange;
		this.boardDirector = boardDirector;
		this.sector = sector;
		this.writeup = writeup;
		this.companyCode = companyCode;
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
