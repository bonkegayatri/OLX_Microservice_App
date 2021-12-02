package com.olx.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name = "advertise")
@EntityListeners(AuditingEntityListener.class)
public class AdvertiseEntity {

	@Id
	@GeneratedValue
	private int categoryId;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "description")
	private String description;

	@Column(name = "createdDate")
	@CreatedDate
	@Temporal(TemporalType.DATE)
	private Date createdDate;

	@Column(name = "modifiedDate")
	@LastModifiedDate
	@Temporal(TemporalType.DATE)
	private Date modifiedDate;

	@Column(name = "status")
	private String status;

	public AdvertiseEntity() {
	}

	public AdvertiseEntity(String title, double price, String description, Date createdDate, Date modifiedDate,
			String status) {
		super();
		this.title = title;
		this.price = price;
		this.description = description;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.status = status;
	}

	public AdvertiseEntity(int categoryId, String title, double price, String description, Date createdDate,
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
		return "AdvertiseEntity [categoryId=" + categoryId + ", title=" + title + ", price=" + price + ", description="
				+ description + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + ", status=" + status
				+ "]";
	}
	
	

}
