package Control;

import java.util.Calendar;
import java.util.Vector;

import Beans.AttendInfo;
import Beans.Lecture;
import Boundary.AttendManagementView;
import Boundary.ioHandler;
import List.AttendInfoList;
import List.LectureList;
import List.StudentList;

public class AttendControl {

	private AttendManagementView aMV;
	
	
	
	public AttendControl() {
		super();
		// TODO Auto-generated constructor stub
		aMV = new AttendManagementView();
	}



	public void displayAttend(AttendInfoList attendList, LectureControl lTemp, LectureList lList)
	{
		
		//강좌 코드 선택 
		//승인된 강좌 목록 조회
		lTemp.displayLecture(lList, true);
		String lectureCodeString = aMV.getLectureCode();
		
		//날짜 입력
		//Calendar cal = aMV.getDate();
		Calendar cal = Calendar.getInstance();
		
		
		//get출석정보
		Vector<AttendInfo> dateAttendList = attendList.getAttendInfo(lectureCodeString, cal);
		aMV.showAttend(dateAttendList);
		
	}
	
	
	//출석정보를 추가하기 위해선 강좌정보와 학생정보가 필요하다.
	public void registAttendData(AttendInfoList aList, LectureControl lTemp, LectureList lList, StudentControl sControl, StudentList sList)
	{
		//강좌코드 선택
		lTemp.displayLecture(lList, true);
		String lectureCodeString = aMV.getLectureCode();
		int lecIndex = lList.findLecture(lectureCodeString);
		if( lecIndex == -1 )
		{
			System.out.println("해당 강좌 없음....");
			return;
		}
		
		//날짜 입력
		Calendar cal = Calendar.getInstance();
		
		//학생 이름 입력
		String sName = aMV.getStringCode();
		int tempIndex = sList.findStudentByName(sName);
		if( tempIndex == -1 )
		{
			System.out.println("----학생 이름이 존재하지 않음..----");
			return;
		}
		
		//강좌에 학생이 있는지 판별
		Lecture lec = lList.getLecture(lecIndex);
		boolean sCheck = lec.checkStudent(sName);
		if( sCheck == false )
		{
			System.out.println("해당 강좌에 해당 학생이 없음....");
			return;
		}
		
		//한번 출석 했는지 판별
		int index = aList.findAttendInfo(sName, lectureCodeString, cal);
		if( index == -1 )
		{
			AttendInfo tempAtt = new AttendInfo(lectureCodeString, sName, true, cal);
			aList.insertAttendInfo(tempAtt);
		}else
		{
			System.out.println("----출석정보 등록되어 있음----");
		}
		
	}
	
	
}
