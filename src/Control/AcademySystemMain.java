package Control;

/*
 * 									�п� ���� �ý���
 * 															2015-11-25
 * 															          ���Ⳳ
 * 
 * 
 * 
 * ũ�� ���°���, �л�����, ������, ��������� �����Ǿ� �ִ�.
 * �� ���� ����� ���常 �����ϸ� ����� ���°���-������ȸ,���µ��
 * 							 | �п�������-�п�����ȸ,�п������½�û 
 * 							 | ������-�����ȸ, ������ ���� ��ɸ� �����ϴ�.
 * 
 * */


import java.util.Scanner;

import Beans.HighschoolStudent;
import Beans.Lecture;
import Beans.Student;
import Beans.Teacher;
import Boundary.ioHandler;
import List.AttendInfoList;
import List.LectureList;
import List.StudentList;
import List.TeacherList;

public class AcademySystemMain {

	// Define Final Constant Number
	
	
	public static void main(String args[]) {

		AcademyManagementSystem system = new AcademyManagementSystem();
		system.processProgram();
		
	}

	

}
