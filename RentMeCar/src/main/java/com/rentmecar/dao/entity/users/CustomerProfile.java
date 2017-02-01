package com.rentmecar.dao.entity.users;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="Customer_profile")
@PrimaryKeyJoinColumn(name="U_Id")
public class CustomerProfile extends Credentials  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="F_Name",length = 35)
	private String fName;
	@Column(name="L_Name",length = 35)
	private String lName;
	@Column(name="E_Mail",length = 50)
	private String eMail;
	@Column(name="License_No",length = 15)
	private String licenseNo;
	@Column(name="Age")
	private int age;
	@Column(name="Gender",length = 10)
	private String gender;
	@Column(name="Phone",length = 15)
	private String phone;
	@OneToMany(mappedBy="customerProfile")
	private List<UserBooking> userBookings;
	
	public CustomerProfile(){
		super();
	}
	
	
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public List<UserBooking> getUserBookings() {
		return userBookings;
	}
	public void setUserBookings(List<UserBooking> userBookings) {
		this.userBookings = userBookings;
	}
	@Override
	public String toString() {
		return "CustomerProfile [fName=" + fName + ", lName=" + lName + ", eMail=" + eMail + ", licenseNo=" + licenseNo
				+ ", age=" + age + ", gender=" + gender + ", phone=" + phone + ", getUsername()=" + getUsername()
				+ ", getPassword()=" + getPassword() + ", getRole()=" + getRole() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
}
