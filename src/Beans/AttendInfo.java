package Beans;

import java.util.Calendar;
import java.util.Date;

public class AttendInfo {

	private String lectureCode;
	private String lectureName;
	private String stringName;
	private boolean attendCheck; // true 출석, false 결석 
	private Calendar date;
	
	
	public AttendInfo(String lectureCode, String stringName,
			boolean attendCheck, Calendar date) {
		super();
		this.lectureCode = lectureCode;
		this.lectureName = "";
		this.stringName = stringName;
		this.attendCheck = attendCheck;
		this.date = date;
	}
	
	public AttendInfo() {
		super();
		// TODO Auto-generated constructor stub
		lectureCode = "";
		stringName = "";
		lectureName = "";
		attendCheck = false;
		date = Calendar.getInstance();
		
	}
	
	public String getLectureName() {
		return lectureName;
	}

	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}

	public String getStringName() {
		return stringName;
	}

	public void setStringName(String stringName) {
		this.stringName = stringName;
	}

	public String getLectureCode() {
		return lectureCode;
	}
	public void setLectureCode(String lectureCode) {
		this.lectureCode = lectureCode;
	}
	public String getStringCode() {
		return stringName;
	}
	public void setStringCode(String stringCode) {
		stringName = stringCode;
	}
	public boolean isAttendCheck() {
		return attendCheck;
	}
	public void setAttendCheck(boolean attendCheck) {
		this.attendCheck = attendCheck;
	}
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	
	
}
