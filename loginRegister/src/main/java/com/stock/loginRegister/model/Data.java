package com.stock.loginRegister.model;

public class Data {

	    private Long id;
	    private String name;
	    private String password;
	    private String mobile;
	    private String email;
	    
	    private String role="user";
	    
	    
	    public Data() {
			super();
		}

		public Data(Long id, String name, String password, String mobile, String email, String role) {
			super();
			this.id = id;
			this.name = name;
			this.password = password;
			this.mobile = mobile;
			this.email = email;
			this.role = role;
		}

		public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public String getRole() {
	        return role;
	    }

	    public void setRole(String role) {
	        this.role = role;
	    }

	    public String getMobile() {
	        return mobile;
	    }

	    public void setMobile(String mobile) {
	        this.mobile = mobile;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	}
