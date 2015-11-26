package Interface;

import java.util.Vector;

import Beans.Student;

public interface StudentManagement {

	public void displayStudentList(Vector<Student> studentList);
	public Student getStudent();
	public String getStudentCode();
	
}
