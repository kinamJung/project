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
	// ���� ��� �߰�
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
			System.out.println("--���� �ڵ� �ߺ�--");
			
		}
		
		
		
		if( lectureList.checkTeacherFromLecture(lt.getLectureName()) == true )
		{
			ioHandler ioh = new ioHandler();
			ioh.putString("���� ����� ������..\r\n");			
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
			ioh.putString("�ش� ����� ����...");
			return;
		}
		
		lectureList.insertLecture(lt);
		
	}
	//���� ���
	public void displayLecture( LectureList lectureList, boolean flag)
	{
		
		if( lectureList.getSize() != 0 )
		{
			lMV.displayLectureList(lectureList.getLectureList(),flag);
		}
		
	}

	
	//���� ����
	//���ε� �����߿� ����
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
	
	//���� ����
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
	// ���� ����
	public void updateLecture( LectureList lectureList )
	{
		//���
		displayLecture(lectureList, true);
		
		//�����ϰ��� �ϴ� Lecture ����
		String code = lMV.getLectureCode();
		int index = lectureList.findLecture(code);
		if( index == -1 )
		{
			System.out.println("�ش� ���� ����..");
			return;
		}
		
		Lecture lecture = lMV.updateLectureData( lectureList.getLecture(index) );
		
		lectureList.updateLecture(lecture);
		
		
		
	}
	
	
}
