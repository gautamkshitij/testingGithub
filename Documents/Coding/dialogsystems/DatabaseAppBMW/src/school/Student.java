package school;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
 * 
 * API for Student 
 * */
public class Student {

	// Student number provided from the database
	Integer studentNumber;

	HashMap<String, Set<String>> class_prof = new HashMap<String, Set<String>>();

	// Class name and taught by professor

	// constructor, initializing student details and information
	public Student(Integer studentNumber, String className, String profName) {

		this.studentNumber = studentNumber;

		if (class_prof.containsKey(className)) {
			class_prof.get(className).add(profName);
		} else {
			Set<String> professors = new HashSet<String>();
			professors.add(profName);
			class_prof.put(className, professors);

		}

	}

	public Integer getStudentNumber() {

		return this.studentNumber;
	}

	public Student(Integer studentNumber) {

		this.studentNumber = studentNumber;

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (studentNumber == null) {
			if (other.studentNumber != null)
				return false;
		} else if (!studentNumber.equals(other.studentNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [studentNumber=" + studentNumber + "]";
	}

}
