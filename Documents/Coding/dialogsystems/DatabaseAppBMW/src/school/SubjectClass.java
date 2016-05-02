package school;

import java.util.HashSet;
import java.util.Set;

/*
 * 
 * API for class methods
 * */
public class SubjectClass {

	String className;

	Set<Student> students = new HashSet<Student>();
	Set<Professor> professors = new HashSet<Professor>();

	public void addRecord(String className, String profName,
			Integer studentNumber) {

		this.className = className;

		students.add(new Student(studentNumber, className, profName));

		professors.add(new Professor(profName, className, studentNumber));

	}

	public Set<Professor> getProfessors() {

		return professors;

	}

	public Set<Student> getStudents() {

		return students;

	}

	public String getClassName() {

		return className;
	}

	public Set<Student> getIntersectionOfStudents(Set<Student> students_new) {
		Set<Student> intersection = new HashSet<Student>(students_new);
		intersection.retainAll(students);

		return intersection;

	}

	public Set<Professor> getIntersectionOfProfs(Set<Professor> professor_new) {
		Set<Professor> intersection = new HashSet<Professor>(professor_new);

		intersection.retainAll(professors);

		return intersection;

	}

	public static void main(String[] args) {

		Set<Professor> testProf = new HashSet<Professor>();

		Set<Professor> testProf1 = new HashSet<Professor>();

		testProf.add(new Professor("ABC"));
		testProf.add(new Professor("B"));
		testProf.add(new Professor("C"));
		testProf.add(new Professor("D"));
		testProf.add(new Professor("E"));
		testProf.add(new Professor("F"));
		testProf.add(new Professor("Gss"));

		testProf1.add(new Professor("E"));
		testProf1.add(new Professor("F"));
		testProf1.add(new Professor("G"));

		SubjectClass c = new SubjectClass();
		c.professors = testProf;
		System.out.println(c.getIntersectionOfProfs(testProf1));

	}

}
