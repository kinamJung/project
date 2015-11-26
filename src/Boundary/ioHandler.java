package Boundary;

import java.util.Scanner;

import Beans.AttendInfo;
import Beans.HighschoolStudent;
import Beans.Lecture;
import Beans.Student;
import Beans.Teacher;

public class ioHandler {

	public String getString()
	{
		Scanner scan = new Scanner(System.in);
		String temp = scan.nextLine();
		return temp;
	}
	
	public int getInteger()
	{
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
	}
	
	public void putStudent( Student stu )
	{
		
		System.out.print( stu.getStudentName() + "\t" );
		System.out.print(stu.getStudentCode() + "\t");
		if( stu.getDivStudent() == 1 )
		{
			System.out.print("Middle Student" + "\t");
		}else
		{
			System.out.print("High School" + "\t");
		}		
		System.out.print( stu.getParentPhone() + "\t");
		System.out.print(stu.getLesson()+ "\t");
		if(stu.getDivStudent() == 2)
		{
			HighschoolStudent h = (HighschoolStudent)stu;
			System.out.print(h.getAffiliation());
		}
		System.out.println();
	}
	
	public void putTeacher( Teacher t )
	{
		System.out.print(t.getName() + "\t");
		System.out.print(t.getTeacherCode()+"\t");
		System.out.print(t.getMajor() + "\t");
		System.out.println(t.getNowProcessLecture() );
		
	}
	
	public void putLecture( Lecture l )
	{
		System.out.print(l.getLectureName()+"\t");
		System.out.print(l.getLectureCode()+"\t");
		System.out.print(l.getMaxPerson()+"\t");
		System.out.print(l.getNowPerson()+"\t");
		System.out.print(l.getSummary()+"\t");
		System.out.println(l.getTeacherName());
		
	}
	
	public void putAttend( AttendInfo aInfo )
	{
		System.out.print(aInfo.getStringCode()+"\t\t");
		if( aInfo.isAttendCheck() == true )
		{
			System.out.println("O");
		}
	}
	
	public void putString( String str )
	{
		System.out.print(str);
	}
	
	
}
