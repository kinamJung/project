package Control;

/*
 * 									학원 관리 시스템
 * 															2015-11-25
 * 															          정기남
 * 
 * 
 * 
 * 크게 강좌관리, 학생관리, 출결관리, 강사관리로 구성되어 있다.
 * 단 위의 기능은 원장만 가능하며 강사는 강좌관리-강좌조회,강좌등록
 * 							 | 학원생관리-학원생조회,학원생강좌신청 
 * 							 | 출결관리-출결조회, 출결등재 등의 기능만 가능하다.
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
