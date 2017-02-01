package com.rentmecar.dao.entity.users;

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
@Table(name="User_Booking")
public class UserBooking {

	@Id
	@Column(name="Booking_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookingId;
	@Column(name="Total_Cost")
	private float totalCost;
	@OneToOne
	@JoinColumn(name="Sched_Id")
	private CarSched carSched;
	@ManyToOne
	@JoinColumn(name="U_Id")
	private CustomerProfile customerProfile;
	
	public UserBooking(){
		
	}

	public UserBooking(int bookingId, float totalCost, CarSched carSched, CustomerProfile customerProfile) {
		super();
		this.bookingId = bookingId;
		this.totalCost = totalCost;
		this.carSched = carSched;
		this.customerProfile = customerProfile;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public float getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}

	public CarSched getCarSched() {
		return carSched;
	}

	public void setCarSched(CarSched carSched) {
		this.carSched = carSched;
	}

	public CustomerProfile getCustomerProfile() {
		return customerProfile;
	}

	public void setCustomerProfile(CustomerProfile customerProfile) {
		this.customerProfile = customerProfile;
	}

	@Override
	public String toString() {
		return "UserBooking [bookingId=" + bookingId + ", totalCost=" + totalCost + ", carSched=" + carSched
				+ ", customerProfile=" + customerProfile + "]";
	}
}
