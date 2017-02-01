package com.rentmecar.dao.entity.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Car_Price_Sched")
public class CarPriceSched {

	@Id
	@Column(name="Sched_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int schedId;
	@Column(name="Day")
	private String day;
	@Column(name="Rent")
	private float rent;
	@ManyToOne
	@JoinColumn(name="Car_Id")
	private Car car;
	
	public CarPriceSched(){
		
	}

	public CarPriceSched(int schedId, String day, float rent) {
		super();
		this.schedId = schedId;
		this.day = day;
		this.rent = rent;
	}

	public int getSchedId() {
		return schedId;
	}

	public void setSchedId(int schedId) {
		this.schedId = schedId;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public float getRent() {
		return rent;
	}

	public void setRent(float rent) {
		this.rent = rent;
	}
	
	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "CarPriceSched [schedId=" + schedId + ", day=" + day + ", rent=" + rent + "]";
	}
}
