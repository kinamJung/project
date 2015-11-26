package List;

import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import java.util.stream.Stream;

import Beans.AttendInfo;

public class AttendInfoList {

	private Vector<AttendInfo> attendList;

	public AttendInfoList() {
		super();
		// TODO Auto-generated constructor stub
		attendList = new Vector<AttendInfo>();
	}
	
	public void insertAttendInfo( AttendInfo ainfo )
	{
		attendList.add(ainfo);
	}
	
	// 해당 날짜와 해당 과목에 맞는 출석정보목록 리턴
	public Vector<AttendInfo> getAttendInfo( String lectureCode, Calendar date )
	{
		Vector<AttendInfo> dateAttend = new Vector<AttendInfo>();
		//해당 과목과 date에 맞는 출석정보 가져옴.
		for(int i = 0 ; i < attendList.size(); i++ )
		{
			AttendInfo aTemp = attendList.get(i);
			
			if( aTemp.getLectureCode().equals(lectureCode) == true )
			{
				Calendar c = aTemp.getDate();
				if( (c.get(Calendar.YEAR) == date.get(Calendar.YEAR)) 
						&& c.get(Calendar.MONTH) == date.get(Calendar.MONTH)
						&& c.get(Calendar.DATE) == date.get(Calendar.DATE)
						)
				{
					dateAttend.add(aTemp);
				}
			}
		}
		
		return dateAttend;
		
	}
	
	public int findAttendInfo(String sName, String lectureCode, Calendar cal)
	{
		int index = -1;
		for(int i = 0 ; i < attendList.size(); i++ )
		{
			AttendInfo aTemp = attendList.get(i);
			
			if( aTemp.getLectureCode().equals(lectureCode) == true )
			{
				if( (aTemp.getDate().equals(cal) == true) && (aTemp.getStringCode().equals(sName) == true) )
				{
					index = i;
				}
			}
		}
		
		
		return index;
	}
	
}
