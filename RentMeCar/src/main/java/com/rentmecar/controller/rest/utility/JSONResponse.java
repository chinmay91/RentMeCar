package com.rentmecar.controller.rest.utility;

import java.util.ArrayList;
import java.util.List;


public class JSONResponse extends ApplicationRestExceptions {

	private String status;
	private String messsage;
	private String description;
	private List<Object> data;
	
	public JSONResponse(){
		data = new ArrayList<Object>();
	}

	public JSONResponse(String status, String messsage, String description) {
		this.status = status;
		this.messsage = messsage;
		this.description = description;
		this.data = new ArrayList<>();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMesssage() {
		return messsage;
	}

	public void setMesssage(String messsage) {
		this.messsage = messsage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<Object> getData() {
		return data;
	}

	public void setData(List<Object> data) {
		this.data = data;
	}

	public void addObject(Object newObj){
		data.add(newObj);
	}

	@Override
	public String toString() {
		return "JSONResponse [status=" + status + ", messsage=" + messsage + ", description=" + description + "]";
	}

}