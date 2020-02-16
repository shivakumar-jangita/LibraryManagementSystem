package com.siva.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;
	@Column(name = "role_type")
	private String role;
	@Column(name = "user_name")
	private String name;
	@Column(name = "address")
	private String address;
	@Column(name = "book_issue")
	private String bookissue = "none";
	@Column(name = "book_return")
	private String bookreturn = "none";
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBookissue() {
		return bookissue;
	}

	public void setBookissue(String bookissue) {
		this.bookissue = bookissue;
	}

	public String getBookreturn() {
		return bookreturn;
	}

	public void setBookreturn(String bookreturn) {
		this.bookreturn = bookreturn;
	}

	@Override
	public String toString() {
		return "Admin{" + "name='" + name + '\'' + ", address='" + address + '\'' + '}';
	}

}
