package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idClient;
	@Column(name = "first_name")
	private String firstNameClient;
	@Column(name = "last_name")
	private String lastNameClient;
	@Column(name = "email_client")
	private String emailClient;

	public Client() {
		super();
	}

	public Client(Long idClient, String firstNameClient, String lastNameClient, String emailClient) {
		super();
		this.idClient = idClient;
		this.firstNameClient = firstNameClient;
		this.lastNameClient = lastNameClient;
		this.emailClient = emailClient;
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public String getFirstNameClient() {
		return firstNameClient;
	}

	public void setFirstNameClient(String firstNameClient) {
		this.firstNameClient = firstNameClient;
	}

	public String getLastNameClient() {
		return lastNameClient;
	}

	public void setLastNameClient(String lastNameClient) {
		this.lastNameClient = lastNameClient;
	}

	public String getEmailClient() {
		return emailClient;
	}

	public void setEmailClient(String emailClient) {
		this.emailClient = emailClient;
	}

}
