package com.rentmecar.controller.pojo;

public class CustomerSignUp {

	private String username;
	private String password;
	private String fName;
	private String lName;
	private String eMail;
	private int age;
	private String gender;
	
	public CustomerSignUp(){
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String getGender(){
		return gender;
	}
	
	public void setGender(String gender){
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "CustomerSignUp [username=" + username + ", password=" + password + ", fName=" + fName + ", lName="
				+ lName + ", eMail=" + eMail + ", age=" + age + ", gender=" + gender + "]";
	}
	
	
}
