package Control;

import Beans.Teacher;
import Boundary.TeacherManagementView;
import List.LectureList;
import List.TeacherList;

public class TeacherControl {

	private TeacherManagementView tMS;
	private final static int NOT_FOUND = -1;
	public TeacherControl() {
		super();
		// TODO Auto-generated constructor stub
		tMS = new TeacherManagementView();
	}

	public void displayTeacher(TeacherList teacherList) {
		if (teacherList.getSize() == 0) {

		} else {
			tMS.displayTeacherList(teacherList.getTeacherList());
		}

	}
	
	
	

	//강사 등록
	public void registTeacher(TeacherList teacherList)
	{
		displayTeacher(teacherList);
		Teacher t = null;
		
		while(true)
		{
			t = tMS.getTeacher();
			int index = teacherList.findTeacher(t.getTeacherCode());
			if(  index == -1)
			{
				break;
			}
			System.out.println("--ID 중복--");
		
		}
		
		
		teacherList.insertTeacher(t);
		
	}
	
	//강사 삭제
	public void deleteTeacher( TeacherList teacherList )
	{
		
		tMS.displayTeacherList(teacherList.getTeacherList());
		
		String teacherCode = tMS.getTeacherCode();
		
		int index = teacherList.findTeacher(teacherCode);
		if( index != NOT_FOUND )
		{
			teacherList.deleteTeacher(teacherCode);
		}
		
	}
	
}
