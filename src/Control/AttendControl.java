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
		
		//���� �ڵ� ���� 
		//���ε� ���� ��� ��ȸ
		lTemp.displayLecture(lList, true);
		String lectureCodeString = aMV.getLectureCode();
		
		//��¥ �Է�
		//Calendar cal = aMV.getDate();
		Calendar cal = Calendar.getInstance();
		
		
		//get�⼮����
		Vector<AttendInfo> dateAttendList = attendList.getAttendInfo(lectureCodeString, cal);
		aMV.showAttend(dateAttendList);
		
	}
	
	
	//�⼮������ �߰��ϱ� ���ؼ� ���������� �л������� �ʿ��ϴ�.
	public void registAttendData(AttendInfoList aList, LectureControl lTemp, LectureList lList, StudentControl sControl, StudentList sList)
	{
		//�����ڵ� ����
		lTemp.displayLecture(lList, true);
		String lectureCodeString = aMV.getLectureCode();
		int lecIndex = lList.findLecture(lectureCodeString);
		if( lecIndex == -1 )
		{
			System.out.println("�ش� ���� ����....");
			return;
		}
		
		//��¥ �Է�
		Calendar cal = Calendar.getInstance();
		
		//�л� �̸� �Է�
		String sName = aMV.getStringCode();
		int tempIndex = sList.findStudentByName(sName);
		if( tempIndex == -1 )
		{
			System.out.println("----�л� �̸��� �������� ����..----");
			return;
		}
		
		//���¿� �л��� �ִ��� �Ǻ�
		Lecture lec = lList.getLecture(lecIndex);
		boolean sCheck = lec.checkStudent(sName);
		if( sCheck == false )
		{
			System.out.println("�ش� ���¿� �ش� �л��� ����....");
			return;
		}
		
		//�ѹ� �⼮ �ߴ��� �Ǻ�
		int index = aList.findAttendInfo(sName, lectureCodeString, cal);
		if( index == -1 )
		{
			AttendInfo tempAtt = new AttendInfo(lectureCodeString, sName, true, cal);
			aList.insertAttendInfo(tempAtt);
		}else
		{
			System.out.println("----�⼮���� ��ϵǾ� ����----");
		}
		
	}
	
	
}
