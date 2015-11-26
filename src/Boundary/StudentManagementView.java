package Boundary;

import java.util.Vector;

import Beans.HighschoolStudent;
import Beans.MidschoolStudent;
import Beans.Student;
import Interface.StudentManagement;

public class StudentManagementView implements StudentManagement {

	
	public void displayStudentList(Vector<Student> studentList){
		
		
		ioHandler ioh = new ioHandler();
		
		ioh.putString("------------------학원생 목록------------------\r\n");
		ioh.putString("이름\t");
		ioh.putString("학원생 코드\t\t");
		ioh.putString("구분\t");
		ioh.putString("전화번호\t");
		ioh.putString("현재 수강과목\t");
		ioh.putString("비고\r\n");
		for( int i = 0 ; i < studentList.size(); i++ )
		{
			ioh.putStudent(studentList.get(i));
		}
		
		
	}
	
	public String getStudentCode()
	{
		ioHandler ioh = new ioHandler();
		System.out.print("----학생 코드 입력 ----\n 입력 : ");
		return ioh.getString();
		
	}
	
	public Student getStudent()
	{
		
		
		ioHandler ioh = new ioHandler();
		
		
		ioh.putString("----------학생 등록 페이지----------\r\n");
		ioh.putString("구분(1-중학생,2-고등학생): ");
		int divCode = ioh.getInteger() ;
		
		ioh.putString("\r\n학생코드: ");
		String studentCode = ioh.getString();
		
		ioh.putString("\r\n학생이름: ");
		String name= ioh.getString();
		
		ioh.putString("\r\n성별: ");
		String sex= ioh.getString();
		
		ioh.putString("\r\n보호자 전화번호 :");
		String parentPhoen= ioh.getString();
		
		ioh.putString("\r\n생일 : ");
		String birthDay= ioh.getString();
		
		Student s = null;
		if( divCode == 2 ) // 2 is highschool student
		{
			String aff;
			ioh.putString("\r\n계열: ");
			aff = ioh.getString();
			s = new HighschoolStudent(divCode, studentCode, name, sex, parentPhoen, birthDay, aff); 
			
		}else
		{
			s = new MidschoolStudent(divCode, studentCode, name, sex, parentPhoen, birthDay);
		}
		
		return s;
		
	}
	
}
