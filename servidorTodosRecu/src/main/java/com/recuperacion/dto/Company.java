package com.recuperacion.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "company")
@NamedQueries({@NamedQuery(name = "Company.findAll", query = "SELECT c FROM Company c")})
public class Company implements Serializable{

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "catch_phrase")
	private String catch_phrase;
	
	@Column(name = "bs")
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
