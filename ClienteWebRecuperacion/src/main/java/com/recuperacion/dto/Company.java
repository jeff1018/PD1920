package com.recuperacion.dto;

import java.io.Serializable;

public class Company implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;

	private String name;
	
	private String catch_phrase;
	
	private String bs;

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

	public String getCatch_phrase() {
		return catch_phrase;
	}

	public void setCatch_phrase(String catch_phrase) {
		this.catch_phrase = catch_phrase;
	}

	public String getBs() {
		return bs;
	}

	public void setBs(String bs) {
		this.bs = bs;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", catch_phrase=" + catch_phrase + ", bs=" + bs + "]";
	}
		
}
