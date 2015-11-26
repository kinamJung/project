package Beans;

public class Teacher {

	private String teacherCode;
	private String name;
	private String major;
	private String phone;
	private String summary;
	private String nowProcessLecture;
	
	
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Teacher(String teacherCode, String name, String major,
			String phone, String summary) {
		super();
		this.teacherCode = teacherCode;
		this.name = name;
		this.major = major;
		this.phone = phone;
		this.summary = summary;
		this.nowProcessLecture="";
		
	}
	
	public String getTeacherCode() {
		return teacherCode;
	}
	public void setTeacherCode(String teacherCode) {
		this.teacherCode = teacherCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String birthday) {
		this.name = birthday;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getNowProcessLecture() {
		return nowProcessLecture;
	}
	public void setNowProcessLecture(String nowProcessLecture) {
		this.nowProcessLecture = nowProcessLecture;
	}
	
	
}
