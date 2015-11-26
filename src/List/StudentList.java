package List;

import java.util.Vector;

import Beans.Student;

public class StudentList {

	private Vector<Student> studentList;

	public StudentList() {
		super();
		// TODO Auto-generated constructor stub
		studentList = new Vector<Student>();	
	}
	
	// insert Student to List
	public boolean insertStudent(Student s){
		
		boolean retVal = false;		
		try
		{
			studentList.add(s);
			retVal = true;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return retVal;
		
	}
	
	
	
	public Vector<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(Vector<Student> studentList) {
		this.studentList = studentList;
	}

	//delete Student From List
	public boolean deleteStudent( String stringCode )
	{
		boolean retValue = false;
		
		try
		{
			int index = findStudent(stringCode);
			if( index != -1 )
			{
				studentList.remove(index);
				retValue = true;
			}else
			{
					
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return retValue;
	}
	
	//Find Index
	public int findStudent( String code )
	{
		int retValu = -1;
		
		for( int i = 0 ; i < studentList.size(); i++ )
		{
			if( studentList.get(i).getStudentCode().equals(code) )
			{
				retValu = i;
			}
		}
		
		return retValu;
	}
	
	public int findStudentByName(String name)
	{
		int retVal = -1;
		for( int i = 0 ; i < studentList.size() ; i++ )
		{
			if( studentList.get(i).getStudentName().equals(name) == true )
			{
				retVal = i;
			}
		}
		return retVal;
	}
	
	public Student getStudent(int index)
	{
		return studentList.get(index);
	}
	
	//update Student From List
	public boolean updateStudent( Student s )
	{
		boolean retValue = false;
		
		try
		{
			int index = studentList.indexOf(s);
			if( index == -1 )
			{
				return false;
			}
			studentList.setElementAt(s, index);
			retValue = true;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return retValue;
	}
	
	public int getSize()
	{
		return studentList.size();
	}
	
	
}
