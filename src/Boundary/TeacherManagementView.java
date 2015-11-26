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
		ioh.putString("�����������\r\n");
		for( int i = 0 ; i < teacherList.size() ;i++ )
		{
			ioh.putTeacher(teacherList.get(i));
			
		}
		
	}
	
	public String getTeacherCode()
	{
		ioHandler ioh = new ioHandler();
		ioh.putString("--���� �ڵ� �Է�--\n");
		return ioh.getString();
	}
	
	public Teacher getTeacher()
	{
		ioHandler ioh = new ioHandler();
		
		ioh.putString("----------���� ��� ������----------\r\n");
		ioh.putString("���� ID : ");
		String id = ioh.getString();
		
		ioh.putString("\r\n�̸� : ");
		String name = ioh.getString();
		
		ioh.putString("\r\n��ȭ��ȣ : ");
		String phone = ioh.getString();
		
		ioh.putString("\r\n�����о� : ");
		String major = ioh.getString();
		
		ioh.putString("\r\n�Ұ�: ");
		String text = ioh.getString();
		
		Teacher t = new Teacher(id, name, major, phone, text);
		
		return t;
	}
	
	
	
}
