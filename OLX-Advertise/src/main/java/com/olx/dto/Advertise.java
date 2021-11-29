package com.olx.dto;

import java.util.Date;

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
	private Date createdDate;

	@ApiModelProperty("Date of the Advertise")
	private Date modifiedDate;

	@ApiModelProperty("status of the Advertise")
	private String status;

	public Advertise() {}

	public Advertise(int categoryId, String title, double price, String description, Date createdDate,
			Date modifiedDate, String status) {
		super();
		this.categoryId = categoryId;
		this.title = title;
		this.price = price;
		this.description = description;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.status = status;
	}

	public Advertise(String title, double price, String description, Date createdDate, Date modifiedDate,
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
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
