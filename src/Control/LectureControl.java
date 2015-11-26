package Control;

import java.util.Vector;

import Beans.Lecture;
import Beans.Teacher;
import Boundary.LectureManagementView;
import Boundary.ioHandler;
import List.LectureList;
import List.TeacherList;

public class LectureControl {

	private LectureManagementView lMV;
	private final static int NOT_FOUND = -1;
	
	public LectureControl() {
		super();
		// TODO Auto-generated constructor stub
		lMV = new LectureManagementView();
	}
	// 강의 목록 추가
	public void insertLecture( LectureList lectureList, TeacherList teacherList )
	{
		
		Lecture lt = null;
		
		while( true )
		{
			lt = lMV.getLecture();
			int index = -1;
			index = lectureList.findLecture(lt.getLectureCode());
			if( index == -1 )
			{
				break;
			}
			System.out.println("--강의 코드 중복--");
			
		}
		
		
		
		if( lectureList.checkTeacherFromLecture(lt.getLectureName()) == true )
		{
			ioHandler ioh = new ioHandler();
			ioh.putString("현재 교사는 수강중..\r\n");			
			return;
		}
		
		int teacherIndex = teacherList.findTeacherByName(lt.getTeacherName());
		if( teacherIndex != -1 )
		{
			Teacher teacher = teacherList.getTeacher(teacherIndex);
			teacher.setNowProcessLecture(lt.getLectureName());
			teacherList.updateTeacher(teacher);
		}else
		{
			ioHandler ioh = new ioHandler();
			ioh.putString("해당 교사는 없음...");
			return;
		}
		
		lectureList.insertLecture(lt);
		
	}
	//강의 출력
	public void displayLecture( LectureList lectureList, boolean flag)
	{
		
		if( lectureList.getSize() != 0 )
		{
			lMV.displayLectureList(lectureList.getLectureList(),flag);
		}
		
	}

	
	//강좌 삭제
	//승인된 강좌중에 삭제
	public void deleteLecture( LectureList lectureList )
	{
		lMV.displayLectureList(lectureList.getLectureList(), true);
		String lecture = lMV.getLectureCode();
		
		int index = lectureList.findLecture(lecture);
		if( index != NOT_FOUND )
		{
			lectureList.deleteLecture(lecture);
		}
		
	}
	
	//강좌 승인
	public void approveLecture(LectureList lectureList)
	{
		
		if( lectureList.getSize() != 0 )
		{
			lMV.displayLectureList(lectureList.getLectureList(),false);
			
			String lCode = lMV.getLectureCode();
			
			int index = lectureList.findLecture(lCode);
			if( index != NOT_FOUND )
			{
				Lecture lecture = lectureList.getLecture(index);
				lecture.setApprove(true);
				
				lectureList.updateLecture(lecture);
			}
		
		}else
		{
			return;
		}
		
	}
	// 강의 수정
	public void updateLecture( LectureList lectureList )
	{
		//출력
		displayLecture(lectureList, true);
		
		//수정하고자 하는 Lecture 얻어옴
		String code = lMV.getLectureCode();
		int index = lectureList.findLecture(code);
		if( index == -1 )
		{
			System.out.println("해당 강좌 없음..");
			return;
		}
		
		Lecture lecture = lMV.updateLectureData( lectureList.getLecture(index) );
		
		lectureList.updateLecture(lecture);
		
		
		
	}
	
	
}
