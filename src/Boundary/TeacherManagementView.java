package Boundary;

import java.util.Vector;

import Beans.Teacher;

public class TeacherManagementView {

	public void displayTeacherList( Vector<Teacher> teacherList )
	{
		
		ioHandler ioh = new ioHandler();
		
		ioh.putString("----------Teacher List------------\r\n");
		ioh.putString("Name\t");
		ioh.putString("Code\t");
		ioh.putString("Major\t");
		ioh.putString("현재진행과목\r\n");
		for( int i = 0 ; i < teacherList.size() ;i++ )
		{
			ioh.putTeacher(teacherList.get(i));
			
		}
		
	}
	
	public String getTeacherCode()
	{
		ioHandler ioh = new ioHandler();
		ioh.putString("--강사 코드 입력--\n");
		return ioh.getString();
	}
	
	public Teacher getTeacher()
	{
		ioHandler ioh = new ioHandler();
		
		ioh.putString("----------강사 등록 페이지----------\r\n");
		ioh.putString("강사 ID : ");
		String id = ioh.getString();
		
		ioh.putString("\r\n이름 : ");
		String name = ioh.getString();
		
		ioh.putString("\r\n전화번호 : ");
		String phone = ioh.getString();
		
		ioh.putString("\r\n전문분야 : ");
		String major = ioh.getString();
		
		ioh.putString("\r\n소개: ");
		String text = ioh.getString();
		
		Teacher t = new Teacher(id, name, major, phone, text);
		
		return t;
	}
	
	
	
}
