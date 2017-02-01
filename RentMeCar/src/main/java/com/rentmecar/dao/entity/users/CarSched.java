package com.rentmecar.dao.entity.users;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Car_Sched")
public class CarSched {

	@Id
	@Column(name="Sched_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int schedId;
	@Column(name="Start_Time")
	private Timestamp startTime;
	@Column(name="End_Time")
	private Timestamp endTime;
	@ManyToOne
	@JoinColumn(name="Car_Id")
	private Car car;
	@OneToOne(mappedBy = "carSched")
	private UserBooking userBooking;
	
	public CarSched(){
		
	}
	public CarSched(int schedId, Timestamp startTime, Timestamp endTime, Car car) {
		super();
		this.schedId = schedId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.car = car;
	}
	public int getSchedId() {
		return schedId;
	}
	public void setSchedId(int schedId) {
		this.schedId = schedId;
	}
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	
	public UserBooking getUserBooking() {
		return userBooking;
	}
	public void setUserBooking(UserBooking userBooking) {
		this.userBooking = userBooking;
	}
	@Override
	public String toString() {
		return "CarSched [schedId=" + schedId + ", startTime=" + startTime + ", endTime=" + endTime + ", car=" + car
				+ "]";
	}
	
}
