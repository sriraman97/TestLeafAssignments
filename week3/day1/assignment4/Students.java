package week3.day1.assignment4;

public class Students {
	
	public void getStudentInfo() {
		System.out.println("Student name: Sriram");
	}

	public void getStudentInfo(int id) {
		System.out.println("Student id: " + id);
	}
	public void getStudentInfo(String name) {
		System.out.println("Student name: " + name);
	}
	
	public void getStudentInfo(int id, String name) {
		System.out.println("Student id: " + id + "\nStudent name: " + name);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Students student1 = new Students();
		
		student1.getStudentInfo();
		student1.getStudentInfo(1);
		student1.getStudentInfo("Sriram");
		student1.getStudentInfo(1, "Sriram");
	}

}
