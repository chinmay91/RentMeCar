package com.rentmecar.dao.entity.users;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Employee_profile")
@PrimaryKeyJoinColumn(name="u_id")
public class EmployeeProfile extends Credentials  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="f_name",length = 35)
	private String fName;
	@Column(name="l_name",length = 35)
	private String lName;
	@Column(name="phone",length = 15)
	private String phone;
	
	public EmployeeProfile(){
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "EmployeeProfile [fName=" + fName + ", lName=" + lName + ", phone=" + phone + "]";
	}
}
