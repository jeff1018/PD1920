package com.recuperacion.dto;

import java.io.Serializable;

public class Todo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String name;
	
	private String username;

	private String email;

	private String phone;

	private String website;
	
	private Company id_company;

	private Direccion id_direccion;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public Company getId_company() {
		return id_company;
	}
	public void setId_company(Company id_company) {
		this.id_company = id_company;
	}
	public Direccion getId_direccion() {
		return id_direccion;
	}
	public void setId_direccion(Direccion id_direccion) {
		this.id_direccion = id_direccion;
	}
	@Override
	public String toString() {
		return "Todo [id=" + id + ", name=" + name + ", username=" + username + ", email=" + email + ", phone=" + phone
				+ ", website=" + website + ", id_company=" + id_company + ", id_direccion=" + id_direccion + "]";
	}	
	
}
