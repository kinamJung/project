package Beans;

public class Student {

	protected int divStudent; // 학생구분 /* 1 중학생 / 2 고등학생 */
	protected String studentCode;
	protected String studentName;
	protected String sex;  /*  남 /  여 */
	protected String parentPhone;
	protected String birthDay;
	protected String lesson;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int divStudent, String studentCode, String studentName,
			String sex, String parentPhone, String birthDay) {
		super();
		this.divStudent = divStudent;
		this.studentCode = studentCode;
		this.studentName = studentName;
		this.sex = sex;
		this.parentPhone = parentPhone;
		this.birthDay = birthDay;
		this.lesson = "";
	}
	
	public String getLesson() {
		return lesson;
	}

	public void setLesson(String lesson) {
		this.lesson = lesson;
	}

	public int getDivStudent() {
		return divStudent;
	}
	public void setDivStudent(int divStudent) {
		this.divStudent = divStudent;
	}
	public String getStudentCode() {
		return studentCode;
	}
	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String isSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getParentPhone() {
		return parentPhone;
	}
	public void setParentPhone(String parentPhone) {
		this.parentPhone = parentPhone;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	
	
	
}
