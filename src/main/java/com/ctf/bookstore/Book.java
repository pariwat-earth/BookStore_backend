package com.ctf.bookstore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codebook;
	private String bookname;
	private Float price;
	private String writer;
	private Integer stork;
	private byte[] image;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(Integer codebook, String bookname, Float price, String writer, Integer stork, byte[] image) {
		super();
		this.codebook = codebook;
		this.bookname = bookname;
		this.price = price;
		this.writer = writer;
		this.stork = stork;
		this.image = image;
	}

	public Integer getCodebook() {
		return codebook;
	}

	public void setCodebook(Integer codebook) {
		this.codebook = codebook;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Integer getStork() {
		return stork;
	}

	public void setStork(Integer stork) {
		this.stork = stork;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

}
