package com.stock.CompanyData.model;

import java.util.List;

public class CompareVarious {

    private String company1;
    private String company2;
    private String fromPeroid;
    private String toPeroid;
    
    private List<String> company1Data;
    private List<String> company2Data;
    
    public List<String> getCompany1Data() {
		return company1Data;
	}

	public void setCompany1Data(List<String> company1Data) {
		this.company1Data = company1Data;
	}

	public List<String> getCompany2Data() {
		return company2Data;
	}

	public void setCompany2Data(List<String> company2Data) {
		this.company2Data = company2Data;
	}

	

    public String getCompany1() {
        return company1;
    }

    public void setCompany1(String company1) {
        this.company1 = company1;
    }

    public String getCompany2() {
        return company2;
    }

    public void setCompany2(String company2) {
        this.company2 = company2;
    }

    public String getFromPeroid() {
        return fromPeroid;
    }

    public void setFromPeroid(String fromPeroid) {
        this.fromPeroid = fromPeroid;
    }

    public String getToPeroid() {
        return toPeroid;
    }

    public void setToPeroid(String toPeroid) {
        this.toPeroid = toPeroid;
    }
}
