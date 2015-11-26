package List;

import java.util.Vector;

import Beans.Teacher;

public class TeacherList {

	private Vector<Teacher> teacherList;

	public TeacherList() {
		super();
		// TODO Auto-generated constructor stub
		teacherList = new Vector<Teacher>();
	}
	
	public void insertTeacher( Teacher t )
	{	
		teacherList.add(t);		
	}
	
	
	public void updateTeacher( Teacher t )
	{
		int index = -1;
		
		index = findTeacher(t.getTeacherCode());
		teacherList.set(index, t);
		
	}
	
	public void deleteTeacher( String teacherCode )
	{
		int index = findTeacher(teacherCode);
		teacherList.remove(index);
		
	}
	public int findTeacherByName( String name )
	{
		int retVal = -1;
		
		for( int i = 0 ; i < teacherList.size(); i++ )
		{
			if( teacherList.get(i).getName().equals(name)){
				return i;
			}
		}
		
		return retVal;
	}
	
	public int findTeacher( String teacherID )
	{
		int retVal = -1;
		
		for( int i = 0 ; i < teacherList.size(); i++ )
		{
			if( teacherList.get(i).getTeacherCode().equals(teacherID)){
				return i;
			}
		}
		
		return retVal;
	}
	
	
	public Teacher getTeacher(int index)
	{
		return teacherList.get(index);
	}
	public Teacher getTeacher( String code )	
	{
		int index = findTeacher(code);
		if( index == -1 )
		{
			return null;
		}else
		{
			return teacherList.get(index);
		}
		
		
	}

	public Vector<Teacher> getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(Vector<Teacher> teacherList) {
		this.teacherList = teacherList;
	}
	
	public int getSize()
	{
		return teacherList.size();
	}
	
	
	
}
