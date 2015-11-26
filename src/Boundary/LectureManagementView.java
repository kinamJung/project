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
		System.out.println("----강의 코드 입력 ----\r\n");
		System.out.print("입력:");
		retVal = ioh.getString();
		
		return retVal;
	}
	
	
	
	public Lecture updateLectureData( Lecture lecture )
	{
		
		ioHandler ioh = new ioHandler();
		
		ioh.putString("----강좌 수정 페이지----\r\n");
		ioh.putString("--MAX인원 수정--");
		ioh.putString("현재 MAX인원 : ");
		ioh.putString(lecture.getMaxPerson()+"\n" );
		ioh.putString("수정 인원:");
		int personCount = ioh.getInteger();
		
		lecture.setMaxPerson(personCount);
		
		
		return lecture;
	}
	
	// 강좌 목록 출력 - flag == true than 승인, false than 미승인
	public void displayLectureList( Vector<Lecture> lecturelist, boolean flag )
	{
		ioh = new ioHandler();
		
		ioh.putString("----------Lecture List------------\r\n");
		ioh.putString("강좌이름\t");
		ioh.putString("강좌코드\t");
		ioh.putString("최대인원\t");
		ioh.putString("현재인원\t");
		ioh.putString("강좌소개\t\t");
		ioh.putString("강사\r\n");
		
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
