package com.rentmecar.dao.entity.users;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Car")
public class Car implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="Car_Id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cId;
	@Column(name="Manufacturer")
	private String manufacturer;
	@Column(name="Model")
	private String model;
	@Column(name="Zipcode")
	private int zipcode;
	@Column(name="Place")
	private String place;
	
	@OneToMany(mappedBy = "car")
	List<CarPriceSched> carPriceSched;
	@OneToMany(mappedBy = "car")
	List<CarSched> carSched;
	
	public Car(){
		
	}
	
	public Car(int cId, String manufacturer, String model){
		this.cId = cId;
		this.manufacturer = manufacturer;
		this.model = model;
	}
	
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public List<CarPriceSched> getCarPriceSched() {
		return carPriceSched;
	}

	public void setCarPriceSched(List<CarPriceSched> carPriceSched) {
		this.carPriceSched = carPriceSched;
	}

	public List<CarSched> getCarSched() {
		return carSched;
	}

	public void setCarSched(List<CarSched> carSched) {
		this.carSched = carSched;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	@Override
	public String toString() {
		return "Car [cId=" + cId + ", manufacturer=" + manufacturer + ", model=" + model + ", zipcode=" + zipcode
				+ ", place=" + place + ", carPriceSched=" + carPriceSched + "]";
	}
}
