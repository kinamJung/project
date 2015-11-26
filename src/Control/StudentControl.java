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
	// ���� ���
	public void displayStudent( StudentList studentList ){
		
		if( studentList.getSize() == 0 )
		{
			
		}else
		{
			sMshow.displayStudentList(studentList.getStudentList());
		}
		
	}
	
	// �п��� ���� ��û
	public void requestLectureToStudent(StudentList studentList, LectureControl lectureControl, LectureList lList)
	{
		// ��� ���
		displayStudent(studentList);
				
		String StudentCode = sMshow.getStudentCode();
		// �п��� �����ϴ��� �˻�
		int index = studentList.findStudent(StudentCode);
		if( index == NOT_FOUND )
		{
			return;
		}
		// get
		Student s = studentList.getStudent(index);
		
		//�ƹ��͵� �����ϰ� ���� ������ ���� �߰�
		if( s.getLesson().equals("") == true )
		{
			//���� ���
			lectureControl.displayLecture(lList, true);
			LectureManagementView l = new LectureManagementView();
			
			//���� �ڵ� �Է�
			String lectureCode = l.getLectureCode();
			if( lList.findLecture(lectureCode) == NOT_FOUND )
			{
				return;
			}else
			{				
				int lIndex = lList.findLecture(lectureCode);			
				Lecture lec = lList.getLecture(lIndex);
				// ���� �ο��� ���� �ִ°� Ȯ��
				if ( lec.getNowPerson() < lec.getMaxPerson() )
				{
					// ���� ������ ���� ���¿� ��� �߰�.
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
	
	//�п��� ���
	public void registStudent(StudentList studentList)
	{	
		displayStudent(studentList);
		Student s = null;
		while( true )
		{
			s = sMshow.getStudent();
			//ID �ߺ� üũ
			int index = studentList.findStudent(s.getStudentCode());
			if( index == -1 )
			{	
				break;
			}
			System.out.println("--�л� ID �ߺ�--");
			
		}
		
		
		boolean retValue =  studentList.insertStudent(s);
		
		if( !retValue)
		{
			System.out.println("error");
		}
	}
	
	// �п��� ����
	public void deleteStudent(StudentList studentList)
	{
		
		ioHandler ioh = new ioHandler();
		
		ioh.putString("----�л�����----\r\n");
		ioh.putString("������ �л��ڵ带 �Է��ϼ���\r\n");
		ioh.putString("�л��ڵ�:");
		String code = ioh.getString();
		
		boolean retVal = studentList.deleteStudent(code);
		if( !retVal )
		{
			ioh.putString("Not delete Student");
		}
		
	}
	

	
}
