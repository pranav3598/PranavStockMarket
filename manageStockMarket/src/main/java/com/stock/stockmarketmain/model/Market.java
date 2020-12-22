package com.stock.stockmarketmain.model;

public class Market {
    private Long id;
    private String stockExchange;
    private String brief;
    private String address;
    private String remarks;
    
       
    public Market() {
		super();
	}


	public Market(Long id, String stockExchange, String brief, String address, String remarks) {
		super();
		this.id = id;
		this.stockExchange = stockExchange;
		this.brief = brief;
		this.address = address;
		this.remarks = remarks;
	}
    

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStockExchange() {
        return stockExchange;
    }

    public void setStockExchange(String stockExchange) {
        this.stockExchange = stockExchange;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
