package Beans;

public class HighschoolStudent extends Student {

	protected String affiliation; // �迭 ex) ����, �̰�, ���

	
	
	
	public HighschoolStudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HighschoolStudent(int div, String studentCode,
			String studentName, String sex, String parentPhone, String birthDay, String aff) {
		
		// TODO Auto-generated constructor stub
		super();
		this.divStudent = div;
		this.studentCode = studentCode;
		this.studentName = studentName;
		this.sex = sex;
		this.parentPhone = parentPhone;
		this.birthDay = birthDay;
		this.affiliation = aff;
		this.lesson="";
	
	}

	public String getAffiliation() {
		return affiliation;
	}

	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}
	
}
