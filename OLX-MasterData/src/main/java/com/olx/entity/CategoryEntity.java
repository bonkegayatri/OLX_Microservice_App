package com.olx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORIES")
public class CategoryEntity {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "category")
	private String category;
	
	public CategoryEntity(int id, String category) {
		super();
		this.id = id;
		this.category = category;
	}
	
	public CategoryEntity(String category) {
		super();
		this.category = category;
	}

	public CategoryEntity() {}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", category=" + category + "]";
	}
	
	
}
