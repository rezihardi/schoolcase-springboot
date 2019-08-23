package com.schoolChase.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dosen")

public class Dosen{
	private long id;
	private String nama;
	private String nik;
	private String lulusan;
	
	public Dosen() {
		
	}
	
	public Dosen(String nama, String nik, String lulusan) {
		this.nama = nama;
		this.nik = nik;
		this.lulusan = lulusan;
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

	@Column(name = "nik", nullable = false)
	public String getNik() {
		return nik;
	}

	public void setNik(String nik) {
		this.nik = nik;
	}
	
	@Column(name = "lulusan", nullable = false)
	public String getLulusan() {
		return lulusan;
	}

	public void setLulusan(String lulusan) {
		this.lulusan = lulusan;
	}
	
	
}