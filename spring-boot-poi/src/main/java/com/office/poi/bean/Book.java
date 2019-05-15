package com.office.poi.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
	private int bookId;
	private String name;
	private String author;
	private float price;
	private String isbn;
	private String pubName;
	private byte[] preface;
}