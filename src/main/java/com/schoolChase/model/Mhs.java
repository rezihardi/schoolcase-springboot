package com.schoolChase.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mahasiswa")

public class Mhs{
	private long id;
	private String nama;
	private String nim;
	private String userName;
	
	public Mhs() {
		
	}
	
	public Mhs(String nama, String nim, String userName) {
		this.nama = nama;
		this.nim = nim;
		this.userName = userName;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "nama", nullable = false)
	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	@Column(name = "nim", nullable = false)
	public String getNim() {
		return nim;
	}

	public void setNim(String nim) {
		this.nim = nim;
	}
	
	@Column(name = "userName", nullable = false)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}