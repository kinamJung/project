package Boundary;

import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import Beans.AttendInfo;
import Interface.AttendManagement;
import List.AttendInfoList;

public class AttendManagementView implements AttendManagement {

	@Override
	public void showAttend(Vector<AttendInfo> aList) {
		// TODO Auto-generated method stub
		
		ioHandler ioh = new ioHandler();
		ioh.putString("----------Attend Situdation ----------\r\n");
		ioh.putString("   Name\n");
		for( int i = 0 ; i < aList.size();i++ )
		{
			ioh.putString((i+1)+". ");
			AttendInfo aTemp = aList.get(i);
			ioh.putAttend(aTemp);
		}
		
		
		
	}
	public String getStringCode()
	{
		ioHandler ioh = new ioHandler();
		ioh.putString("----Insert Student Name----\r\n");
		return ioh.getString();
	}
	
	public String getLectureCode()
	{
		ioHandler ioh = new ioHandler();
		ioh.putString("----Insert Lecture Code----\r\n");
		return ioh.getString();
	}
	
	public Calendar getDate()
	{
		ioHandler ioh = new ioHandler();
		
		ioh.putString("----Insert Date----\r\n");
		ioh.putString("Year(ex.2015): ");
		int year = ioh.getInteger();
		
		ioh.putString("Month(ex.05): ");
		int month = ioh.getInteger();
		
		ioh.putString("Day(ex.20): ");
		int day = ioh.getInteger();
		
		Calendar cal = Calendar.getInstance();
		cal.set(year, month, day);
		return cal;
	}
	
	
}
