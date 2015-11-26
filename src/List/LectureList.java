package List;

import java.util.Vector;

import Beans.Lecture;

public class LectureList {

	private Vector<Lecture> lectureList;

	public LectureList() {
		super();
		// TODO Auto-generated constructor stub
		lectureList = new Vector<Lecture>();
	
	}
	
	public void insertLecture( Lecture lec )
	{
		
		lectureList.add(lec);
		
	}

	//현재 진행 과목중에 교사 이름이 있으면 true를 리턴
	public boolean checkTeacherFromLecture( String teacherName )
	{
		
		for( int i = 0 ; i < lectureList.size(); i++ )
		{
			Lecture lec = lectureList.get(i);
			if( lec.getTeacherName().equals(teacherName) == true )
			{
				return true;
			}
		}
		return false;
		
	}
	
	
	public int findLecture( String lectureCode )
	{
		for( int i = 0 ; i < lectureList.size(); i++ )
		{
			Lecture l = lectureList.elementAt(i);
			if(l.getLectureCode().equals(lectureCode) == true)
			{
				return i;
			}
			
		}
		return -1;
	}
 
	public void deleteLecture(String strCode)
	{
		int index = findLecture(strCode);
		lectureList.remove(index);
		
	}
	
	public void updateLecture( Lecture l )
	{
		int index = findLecture(l.getLectureCode());
		lectureList.set(index, l);
		
	}
	
	public Vector<Lecture> getLectureList() {
		return lectureList;
	}

	public void setLectureList(Vector<Lecture> lectureList) {
		this.lectureList = lectureList;
	}

	public Lecture getLecture( int lectureIndex )
	{		
		return lectureList.get(lectureIndex);		
	}
	
	public int getSize()
	{
		return lectureList.size();
	}
	
}
