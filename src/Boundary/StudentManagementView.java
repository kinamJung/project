package Boundary;

import java.util.Vector;

import Beans.HighschoolStudent;
import Beans.MidschoolStudent;
import Beans.Student;
import Interface.StudentManagement;

public class StudentManagementView implements StudentManagement {

	
	public void displayStudentList(Vector<Student> studentList){
		
		
		ioHandler ioh = new ioHandler();
		
		ioh.putString("------------------�п��� ���------------------\r\n");
		ioh.putString("�̸�\t");
		ioh.putString("�п��� �ڵ�\t\t");
		ioh.putString("����\t");
		ioh.putString("��ȭ��ȣ\t");
		ioh.putString("���� ��������\t");
		ioh.putString("���\r\n");
		for( int i = 0 ; i < studentList.size(); i++ )
		{
			ioh.putStudent(studentList.get(i));   
		}
		
		
	}
	
	public String getStudentCode()
	{
		ioHandler ioh = new ioHandler();
		System.out.print("----�л� �ڵ� �Է� ----\n �Է� : ");
		return ioh.getString();
		
	}
	
	public Student getStudent()
	{
		
		
		ioHandler ioh = new ioHandler();
		
		
		ioh.putString("----------�л� ��� ������----------\r\n");
		ioh.putString("����(1-���л�,2-����л�): ");
		int divCode = ioh.getInteger() ;
		
		ioh.putString("\r\n�л��ڵ�: ");
		String studentCode = ioh.getString();
		
		ioh.putString("\r\n�л��̸�: ");
		String name= ioh.getString();
		
		ioh.putString("\r\n����: ");
		String sex= ioh.getString();
		
		ioh.putString("\r\n��ȣ�� ��ȭ��ȣ :");
		String parentPhoen= ioh.getString();
		
		ioh.putString("\r\n���� : ");
		String birthDay= ioh.getString();
		
		Student s = null;
		if( divCode == 2 ) // 2 is highschool student
		{
			String aff;
			ioh.putString("\r\n�迭: ");
			aff = ioh.getString();
			s = new HighschoolStudent(divCode, studentCode, name, sex, parentPhoen, birthDay, aff); 
			
		}else
		{
			s = new MidschoolStudent(divCode, studentCode, name, sex, parentPhoen, birthDay);
		}
		
		return s;
		
	}
	
}
