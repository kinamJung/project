package Boundary;

import java.util.Vector;

import Beans.Lecture;
import Beans.Student;
import List.LectureList;

public class LectureManagementView {

	ioHandler ioh;
	
	public LectureManagementView() {
		super();
		// TODO Auto-generated constructor stub
		ioh = new ioHandler();
	}

	public Lecture getLecture()
	{
	
		ioh = new ioHandler();
		ioh.putString("--------Insert Lecture Page--------\r\n");
		
		ioh.putString("Lecture Name:");
		String lectureName = ioh.getString();
		
		ioh.putString("\r\nLecture Code:");
		String lectureCode = ioh.getString();
		
		ioh.putString("\r\nMAX Person:");
		int maxPerson = ioh.getInteger();
		
		ioh.putString("\r\nTeacher Name:");
		String teacherName = ioh.getString();
		
		ioh.putString("\r\nLecture Summary: ");
		String summary = ioh.getString();
		
		ioh.putString("\r\n");
		Lecture lecture = new Lecture(lectureName, lectureCode, maxPerson, summary);
		lecture.setTeacherName(teacherName);
		
		return lecture;
	}
	
	public String getLectureCode()
	{
		String retVal = null;
		System.out.println("----���� �ڵ� �Է� ----\r\n");
		System.out.print("�Է�:");
		retVal = ioh.getString();
		
		return retVal;
	}
	
	
	
	public Lecture updateLectureData( Lecture lecture )
	{
		
		ioHandler ioh = new ioHandler();
		
		ioh.putString("----���� ���� ������----\r\n");
		ioh.putString("--MAX�ο� ����--");
		ioh.putString("���� MAX�ο� : ");
		ioh.putString(lecture.getMaxPerson()+"\n" );
		ioh.putString("���� �ο�:");
		int personCount = ioh.getInteger();
		
		lecture.setMaxPerson(personCount);
		
		
		return lecture;
	}
	
	// ���� ��� ��� - flag == true than ����, false than �̽���
	public void displayLectureList( Vector<Lecture> lecturelist, boolean flag )
	{
		ioh = new ioHandler();
		
		ioh.putString("----------Lecture List------------\r\n");
		ioh.putString("�����̸�\t");
		ioh.putString("�����ڵ�\t");
		ioh.putString("�ִ��ο�\t");
		ioh.putString("�����ο�\t");
		ioh.putString("���¼Ұ�\t\t");
		ioh.putString("����\r\n");
		
		for( int i = 0 ; i < lecturelist.size(); i++ )
		{
			Lecture l = lecturelist.get(i);
			if( l.isApprove() == flag )
			{
				ioh.putLecture( l );
			}
			
		}
		
	
		
	}
	
	
}
