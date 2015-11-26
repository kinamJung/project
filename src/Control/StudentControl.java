package Control;

import java.util.Vector;

import Beans.Lecture;
import Beans.Student;
import Boundary.LectureManagementView;
import Boundary.StudentManagementView;
import Boundary.ioHandler;
import Interface.StudentManagement;
import List.LectureList;
import List.StudentList;

public class StudentControl {

	private StudentManagement sMshow;
	private final static int NOT_FOUND = -1;
	
	public StudentControl() {
		super();
		// TODO Auto-generated constructor stub
		sMshow = new StudentManagementView();
	
	}
	// 강사 출력
	public void displayStudent( StudentList studentList ){
		
		if( studentList.getSize() == 0 )
		{
			
		}else
		{
			sMshow.displayStudentList(studentList.getStudentList());
		}
		
	}
	
	// 학원생 강좌 신청
	public void requestLectureToStudent(StudentList studentList, LectureControl lectureControl, LectureList lList)
	{
		// 목록 출력
		displayStudent(studentList);
				
		String StudentCode = sMshow.getStudentCode();
		// 학원생 존재하는지 검사
		int index = studentList.findStudent(StudentCode);
		if( index == NOT_FOUND )
		{
			return;
		}
		// get
		Student s = studentList.getStudent(index);
		
		//아무것도 수강하고 있지 않으면 과목 추가
		if( s.getLesson().equals("") == true )
		{
			//과목 출력
			lectureControl.displayLecture(lList, true);
			LectureManagementView l = new LectureManagementView();
			
			//과목 코드 입력
			String lectureCode = l.getLectureCode();
			if( lList.findLecture(lectureCode) == NOT_FOUND )
			{
				return;
			}else
			{				
				int lIndex = lList.findLecture(lectureCode);			
				Lecture lec = lList.getLecture(lIndex);
				// 현재 인원이 여유 있는가 확인
				if ( lec.getNowPerson() < lec.getMaxPerson() )
				{
					// 여유 있으면 현재 강좌에 사람 추가.
					lec.insertStudent(s);
					int temp = lec.getNowPerson();
					temp = temp + 1;
					lec.setNowPerson(temp);
					
					//update
					lList.updateLecture(lec);
					s.setLesson(lec.getLectureName());
					studentList.updateStudent(s);
				}
			}
			
		}
		
		
	}
	
	//학원생 등록
	public void registStudent(StudentList studentList)
	{	
		displayStudent(studentList);
		Student s = null;
		while( true )
		{
			s = sMshow.getStudent();
			//ID 중복 체크
			int index = studentList.findStudent(s.getStudentCode());
			if( index == -1 )
			{	
				break;
			}
			System.out.println("--학생 ID 중복--");
			
		}
		
		
		boolean retValue =  studentList.insertStudent(s);
		
		if( !retValue)
		{
			System.out.println("error");
		}
	}
	
	// 학원생 삭제
	public void deleteStudent(StudentList studentList)
	{
		
		ioHandler ioh = new ioHandler();
		
		ioh.putString("----학생삭제----\r\n");
		ioh.putString("삭제할 학생코드를 입력하세요\r\n");
		ioh.putString("학생코드:");
		String code = ioh.getString();
		
		boolean retVal = studentList.deleteStudent(code);
		if( !retVal )
		{
			ioh.putString("Not delete Student");
		}
		
	}
	

	
}
