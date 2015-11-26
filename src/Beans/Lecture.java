package Beans;

import java.util.Vector;

public class Lecture {

	private String lectureName;
	private String lectureCode;
	private Vector<Student> studentList;
	private int maxPerson;
	private int nowPerson;
	private String summary;
	private boolean approve;
	private String teacherName;
	
	
	public Lecture(String lectureName, String lectureCode, int maxPerson, String summary) {
		super();
		this.lectureName = lectureName;
		this.lectureCode = lectureCode;
		this.maxPerson = maxPerson;
		this.summary = summary;
		
		studentList = new Vector<Student>();
		nowPerson = 0;
		approve = false;
		teacherName = "";
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public Lecture(String lectureName, String lectureCode, int maxPerson, String summary, boolean approve) {
		super();
		this.lectureName = lectureName;
		this.lectureCode = lectureCode;
		this.maxPerson = maxPerson;
		this.summary = summary;
		this.approve = true;
		studentList = new Vector<Student>();
		nowPerson = 0;
		
		
	}
	
	public void insertStudent( Student s )
	{
		studentList.add(s);
	}
	
	public boolean isApprove() {
		return approve;
	}

	public void setApprove(boolean approve) {
		this.approve = approve;
	}

	public boolean checkStudent( String name )
	{
		boolean retVal = false;
		
		for( int i = 0 ; i < studentList.size(); i++ )
		{
			Student s = studentList.get(i);
			if( s.getStudentName().equals(name) == true )
			{
				retVal = true;
			}
			
		}
		
		return retVal;
	}
	
	public boolean deleteStudent( Student s )
	{
		boolean retVal = false;
		
		try
		{
			retVal = studentList.remove(s);
			
		}catch(Exception e)
		{
			
		}
		
		
		return retVal;
	}

	public String getLectureName() {
		return lectureName;
	}

	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}

	public String getLectureCode() {
		return lectureCode;
	}
	public void setLectureCode(String lectureCode) {
		this.lectureCode = lectureCode;
	}
	public Vector<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(Vector<Student> studentList) {
		this.studentList = studentList;
	}
	public int getMaxPerson() {
		return maxPerson;
	}
	public void setMaxPerson(int maxPerson) {
		this.maxPerson = maxPerson;
	}
	public int getNowPerson() {
		return nowPerson;
	}
	public void setNowPerson(int nowPerson) {
		this.nowPerson = nowPerson;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	
	
	
}
