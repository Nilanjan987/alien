package com.studentinfo;

public class Member
{
	private String First_Name,Last_Name,User_Name,Password,Email,Confirm_Email,Date_Of_Birth;

	
	public Member() {
		super();
	}

	public Member(String First_Name, String Last_Name, String User_Name, String Password, String Email,
			String Confirm_Email, String Date_Of_Birth) {
		super();
		this.First_Name = First_Name;
		this.Last_Name = Last_Name;
		this.User_Name = User_Name;
		this.Password = Password;
		this.Email = Email;
		this.Confirm_Email = Confirm_Email;
		this.Date_Of_Birth = Date_Of_Birth;
	}

	public String getFirst_Name() {
		return First_Name;
	}

	public void setFirst_Name(String First_Name) {
		this.First_Name = First_Name;
	}

	public String getLast_Name() {
		return Last_Name;
	}

	public void setLast_Name(String Last_Name) {
		this.Last_Name = Last_Name;
	}

	public String getUser_Name() {
		return User_Name;
	}

	public void setUser_Name(String User_Name) {
		this.User_Name = User_Name;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}

	public String getConfirm_Email() {
		return Confirm_Email;
	}

	public void setConfirm_Email(String Confirm_Email) {
		this.Confirm_Email = Confirm_Email;
	}

	public String getDate_Of_Birth() {
		return Date_Of_Birth;
	}

	public void setDate_Of_Birth(String Date_Of_Birth) {
		this.Date_Of_Birth = Date_Of_Birth;
	}

	
}