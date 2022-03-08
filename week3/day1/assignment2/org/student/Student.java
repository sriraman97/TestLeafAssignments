package week3.day1.assignment2.org.student;

import week3.day1.assignment2.org.department.Department;

public class Student extends Department {

	public void studentName() {
		System.out.println("Student name: Sriraman" );
	}
	
	public void studentDept() {
		System.out.println("Student's department: EIE");
	}
	
	public void studentId() {
		System.out.println("Student's id: 101010");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student student1 = new Student();
		
		student1.collegeCode();
		student1.collegeName();
		student1.collegeRank();
		
		student1.departmentName();
		
		student1.studentName();
		student1.studentId();
		student1.studentDept();
	}

}
