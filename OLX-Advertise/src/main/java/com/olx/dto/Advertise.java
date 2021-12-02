package com.olx.dto;

import java.time.LocalDate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Advertise Model")
public class Advertise {

	@ApiModelProperty("Unique Idetifier of the Advertise")
	private int categoryId;
	
	@ApiModelProperty("Name of the Advertise")
	private String title;
	
	@ApiModelProperty("Price of the Advertise")
	private double price;
	
	@ApiModelProperty("Details of the Advertise")
	private String description;

	@ApiModelProperty("Date of the Advertise")
	private LocalDate createdDate;

	@ApiModelProperty("Date of the Advertise")
	private LocalDate modifiedDate;

	@ApiModelProperty("status of the Advertise")
	private String status;

	public Advertise() {}

	public Advertise(int categoryId, String title, double price, String description, LocalDate createdDate,
			LocalDate modifiedDate, String status) {
		super();
		this.categoryId = categoryId;
		this.title = title;
		this.price = price;
		this.description = description;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.status = status;
	}

	public Advertise(String title, double price, String description, LocalDate createdDate, LocalDate modifiedDate,
			String status) {
		super();
		this.title = title;
		this.price = price;
		this.description = description;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.status = status;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDate modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Advertise [categoryId=" + categoryId + ", title=" + title + ", price=" + price + ", description="
				+ description + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + ", status=" + status
				+ "]";
	}
	
	

	
}
