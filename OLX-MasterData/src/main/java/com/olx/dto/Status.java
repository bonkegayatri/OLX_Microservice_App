package com.olx.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Status Model")
public class Status {

	@ApiModelProperty("Unique Idetifier of the Status")
	private int id;
	
	@ApiModelProperty("Type of the status")
	private String status;
	
	public Status(int id, String status) {
		super();
		this.id = id;
		this.status = status;
	}
	
	public Status() {

	}
	
	public Status( String status) {
		super();
		this.status = status;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Status [id=" + id + ", status=" + status + ", getId()=" + getId() + ", getStatus()=" + getStatus()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
}
