package Control;

import java.util.Scanner;

import Beans.HighschoolStudent;
import Beans.Lecture;
import Beans.Student;
import Beans.Teacher;
import Boundary.ioHandler;
import List.AttendInfoList;
import List.LectureList;
import List.StudentList;
import List.TeacherList;

public class AcademyManagementSystem {

	public static final int DIRECTER = 1;
	public static final int TEACHER = 2;

	public static final int LECTURE_MANAGEMENT = 1;
	public static final int STUDENT_MANAGEMENT = 2;
	public static final int ATTEND_MANAGEMENT = 3;
	public static final int TEACHER_MANAGEMENT = 4;

	public static final int SHOW_STUDENT = 1;
	public static final int REGIST_STUDENT = 2;
	public static final int DELETE_STUDENT = 3;
	public static final int UPDATE_STUDENT = 4;
	public static final int REQUEST_STUDENT_LECTURE = 5;

	public static final int SHOW_LECTURE = 1;
	public static final int REGIST_LECTURE = 2;
	public static final int APPROVE_LECTURE = 3;
	public static final int UPDATE_LECTURE = 4;
	public static final int DELETE_LECTURE = 5;

	public static final int SHOW_ATTNED = 1;
	public static final int REGIST_ATTEND = 2;

	public static final int SHOW_TEACHER = 1;
	public static final int REGIST_TEACHER = 2;
	public static final int DELETE_TEACHER = 3;

	public static final int REQUEST_STUDENT_LECTURE_BY_TEACHER = 2;

	public AcademyManagementSystem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void processProgram() {

		// Define List Class
		StudentList studentList = new StudentList();
		LectureList lectureList = new LectureList();
		TeacherList teacherList = new TeacherList();
		AttendInfoList attendList = new AttendInfoList();

		// Init Data
		Student s = new Student(1, "S100001", "Hong", "��", "010-123-1234",
				"1990-12-12");
		Student s1 = new HighschoolStudent(2, "S100002", "Lim", "��",
				"010-213-1234", "1991-5-13", "���");
		Student s2 = new Student(1, "S100003", "Bae", "��", "111-323-1234",
				"1993-2-1");
		Student s3 = new HighschoolStudent(2, "S100004", "Go", "��",
				"222-133-1234", "1992-10-12", "���");
		Student s4 = new HighschoolStudent(2, "S100005", "Hand", "��",
				"312-683-1234", "1999-10-12", "�ι�");

		studentList.insertStudent(s1);
		studentList.insertStudent(s2);
		studentList.insertStudent(s3);
		studentList.insertStudent(s4);
		studentList.insertStudent(s);

		Lecture l = new Lecture("����", "L00001", 30, "�������� ����Ŵ", true);
		Lecture l2 = new Lecture("����", "L0002", 25, "���� ������ ��Ŵ");
		Lecture l3 = new Lecture("����", "L0003", 25, "���� Ǯ�� ����", true);
		Lecture l4 = new Lecture("����", "L0004", 25, "���� ����");

		Teacher t = new Teacher("T0001", "Rock", "����", "010-123-1234",
				"I'll back");
		t.setNowProcessLecture(l.getLectureName());
		Teacher t2 = new Teacher("T0002", "Do", "����", "0101-123-1234",
				"How are you");
		t2.setNowProcessLecture(l3.getLectureName());
		Teacher t3 = new Teacher("T0002", "Wow", "����", "0101-123-1234", "you");

		teacherList.insertTeacher(t);
		teacherList.insertTeacher(t2);
		teacherList.insertTeacher(t3);

		l.setTeacherName(t.getName());
		l3.setTeacherName(t2.getName());

		lectureList.insertLecture(l);
		lectureList.insertLecture(l2);
		lectureList.insertLecture(l3);
		lectureList.insertLecture(l4);

		// Define Control Class
		StudentControl studentConrol = new StudentControl();
		LectureControl lectureControl = new LectureControl();
		TeacherControl teacherControl = new TeacherControl();
		AttendControl attendControl = new AttendControl();

		// Start Program
		int choice = ChoiceDivUserShow();

		switch (choice) {

		// �������� ������ ���
		case DIRECTER:

			while (true) {
				// SHOW
				int select = mainDirectorShow();

				switch (select) {
				case LECTURE_MANAGEMENT:

					int lectureSelect = LectureManagementShow();
					switch (lectureSelect) {
					case SHOW_LECTURE:
						lectureControl.displayLecture(lectureList, true);
						break;
					case REGIST_LECTURE:
						lectureControl.insertLecture(lectureList, teacherList);
						break;
					case APPROVE_LECTURE:
						lectureControl.approveLecture(lectureList);

						break;
					case UPDATE_LECTURE:
						lectureControl.updateLecture(lectureList);

						break;

					case DELETE_LECTURE:
						lectureControl.deleteLecture(lectureList);
						break;
					default:
						break;
					}

					break;

				case STUDENT_MANAGEMENT:

					int studentSelect = StudentManagementShow();
					switch (studentSelect) {
					case SHOW_STUDENT:
						studentConrol.displayStudent(studentList);
						break;
					case REGIST_STUDENT:
						studentConrol.registStudent(studentList);
						break;
					case DELETE_STUDENT:
						studentConrol.deleteStudent(studentList);
						break;

					case REQUEST_STUDENT_LECTURE:
						studentConrol.requestLectureToStudent(studentList,
								lectureControl, lectureList);
						break;
					default:
						break;
					}
					break;

				case ATTEND_MANAGEMENT:
					int attendSelect = AttendManagerShow();
					switch (attendSelect) {
					case SHOW_ATTNED:
						attendControl.displayAttend(attendList, lectureControl,
								lectureList);
						break;
					case REGIST_ATTEND:
						attendControl.registAttendData(attendList,
								lectureControl, lectureList, studentConrol,
								studentList);
						break;
					default:
						break;
					}

					break;

				case TEACHER_MANAGEMENT:
					int teacherSelect = TeacherManagerShow();
					switch (teacherSelect) {
					case SHOW_TEACHER:
						teacherControl.displayTeacher(teacherList);
						break;
					case REGIST_TEACHER:
						teacherControl.registTeacher(teacherList);
						break;
					case DELETE_TEACHER:
						teacherControl.deleteTeacher(teacherList);
						break;
					default:
						break;
					}

					break;

				default:
					break;
				}

			}
			// ����� ������ ���
		case TEACHER:
			while (true) {
				int tSelect = mainTeacherShow();
				switch (tSelect) {
				case LECTURE_MANAGEMENT:
					int lTeacherSelect = LectureManagementByTeacherShow();
					switch (lTeacherSelect) {
					case SHOW_LECTURE:
						lectureControl.displayLecture(lectureList, true);
						break;
					case REGIST_LECTURE:
						lectureControl.insertLecture(lectureList, teacherList);
						break;
					default:
						break;
					}

					break;
				case STUDENT_MANAGEMENT:
					int lsTeacherSelect = StudentManagementByTeacherShow();
					switch (lsTeacherSelect) {
					case SHOW_STUDENT:
						studentConrol.displayStudent(studentList);
						break;
					case REQUEST_STUDENT_LECTURE_BY_TEACHER:
						studentConrol.requestLectureToStudent(studentList,
								lectureControl, lectureList);
						break;
					default:
						break;
					}

					break;
				case ATTEND_MANAGEMENT:
					int lATeacherSelect = AttendManagerByShow();
					switch (lATeacherSelect) {
					case SHOW_ATTNED:
						attendControl.displayAttend(attendList, lectureControl,
								lectureList);
						break;

					case REGIST_ATTEND:
						attendControl.registAttendData(attendList,
								lectureControl, lectureList, studentConrol,
								studentList);
						break;

					default:
						break;
					}

					break;

				default:
					break;
				}

			}

		default:
			break;
		}

	}

	public static int ChoiceDivUserShow() {
		ioHandler ioh = new ioHandler();
		int strDiv;
		System.out.println("-----�п� ���� ���α׷�-----");
		System.out.println("-----------------ver1.1");
		System.out.println("����� ����( 1.���� 2.���� )");
		System.out.println("-----------------------");

		while (true) {
			Scanner scan = new Scanner(System.in);
			strDiv = scan.nextInt();

			if (1 <= strDiv && strDiv <= 2) {
				break;
			} else {
				ioh.putString("Wrong Number\r\n");
			}

		}

		return strDiv;

	}

	public static int mainDirectorShow() {

		ioHandler ioh = new ioHandler();

		ioh.putString("\r\n----- �п� ���� �ý���(����) -----\r\n");
		ioh.putString("1.���°���\r\n");
		ioh.putString("2.�л�����\r\n");
		ioh.putString("3.������\r\n");
		ioh.putString("4.�������\r\n");

		return ioh.getInteger();

	}

	public static int LectureManagementShow() {
		ioHandler ioh = new ioHandler();
		ioh.putString("1.������ȸ\r\n");
		ioh.putString("2.���µ��\r\n");
		ioh.putString("3.���½���\r\n");
		ioh.putString("4.���¼���\r\n");
		ioh.putString("5.���»���\r\n");

		return ioh.getInteger();
	}

	public static int TeacherManagerShow() {
		ioHandler ioh = new ioHandler();
		ioh.putString("1. ���� ��ȸ\r\n");
		ioh.putString("2. ���� ���\r\n");
		ioh.putString("3. ���� ����\r\n");

		return ioh.getInteger();
	}

	public static int AttendManagerShow() {
		ioHandler ioh = new ioHandler();
		ioh.putString("1. �⼮ ��ȸ\r\n");
		ioh.putString("2. �⼮ �ڷ� ����\r\n");

		return ioh.getInteger();
	}

	public static int StudentManagementShow() {
		ioHandler ioh = new ioHandler();
		ioh.putString("1. ��ü �п��� ����\r\n");
		ioh.putString("2. �п��� ���\r\n");
		ioh.putString("3. �п��� ����\r\n");
		ioh.putString("4. �п��� ���� ����\r\n");
		ioh.putString("5. �п��� ���� ��û\r\n");

		return ioh.getInteger();
	}

	public static int AttendManagerByShow() {
		ioHandler ioh = new ioHandler();
		ioh.putString("1. �⼮ ��ȸ\r\n");
		ioh.putString("2. �⼮ �ڷ� ����\r\n");

		return ioh.getInteger();
	}

	public static int StudentManagementByTeacherShow() {
		ioHandler ioh = new ioHandler();
		ioh.putString("1. ��ü �п��� ����\r\n");
		ioh.putString("2. �п��� ���� ��û\r\n");

		return ioh.getInteger();
	}

	public static int LectureManagementByTeacherShow() {
		ioHandler ioh = new ioHandler();
		ioh.putString("1.������ȸ\r\n");
		ioh.putString("2.���µ��\r\n");

		return ioh.getInteger();
	}

	public static int mainTeacherShow() {
		ioHandler ioh = new ioHandler();

		ioh.putString("\r\n----- �п� ���� �ý���(����) -----\r\n");
		ioh.putString("1.���°���\r\n");
		ioh.putString("2.�л�����\r\n");
		ioh.putString("3.������\r\n");

		return ioh.getInteger();
	}

}
