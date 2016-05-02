package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import school.SubjectClass;
import school.Professor;
import school.Student;

public class LauncherApp {

	SubjectClass classes[] = new SubjectClass[4];

	/*
	 * Application Functionalities
	 */

	/* Q1 */
	public void q1_printSectionsTaught() {
		/* Question 1: Classes sections taught */
		System.out
				.println("Question 1: Class Sections Taught: \n =======================");
		Set<Professor> professors;
		Iterator<Professor> iterator;

		for (int i = 0; i < 4; i++) {
			professors = classes[i].getProfessors();

			/*
			 * TODO: check if professors are not empty
			 */
			iterator = professors.iterator();

			while (iterator.hasNext()) {

				System.out.println(classes[i].getClassName() + ", "
						+ iterator.next().getName());
			}
		}
		System.out.println("=======================");
		/* Question 1 DONE */
	}

	/* Q2 */
	public void q2_listClassesPerStudent() {
		/* Question 2 */
		System.out
				.println("Question 2: Class taken by each student: \n =======================");
		Set<Student> students;
		Iterator<Student> iterator_student;

		for (int i = 0; i < 4; i++) {
			students = classes[i].getStudents();

			/*
			 * TODO: Check if students are not empty
			 */
			iterator_student = students.iterator();

			while (iterator_student.hasNext()) {

				System.out.println(iterator_student.next().getStudentNumber()
						+ ": " + classes[i].getClassName());
			}
		}
		System.out.println("=======================");
		/* Question 2 DONE */
	}

	/* Q3 */
	public void q3_atleastTwoClasses_MoreThanTwoStudents() {
		/* Question 3 */
		System.out
				.println("Question 3: Professors with at leasts 2 classes with 2 or more of the same students \n =======================");

		System.out.println("=======================");
		/* Question 3 DONE */
	}

	/* Q4 */
	public void q4_totalStudentsPerClass() {

		/* Question 4 */

		for (int i = 0; i < 4; i++) {
			/*
			 * TODO: Check if classname is not null and students are not nulls
			 */

			System.out.println(classes[i].getClassName() + ":"
					+ classes[i].getStudents().size());

		}
		System.out.println("=======================");
		/* Question 4 DONE */
	}

	/* Q5 */
	public void q5_listStudentsMoreThan1() {

		/* Question 5 */
		System.out
				.println("Question 5:Students taking more than 1 class : \n =======================");

		Set<Student> students_morethanOneClass = new HashSet<Student>();

		for (int i = 0; i < 4; i++) {

			for (int j = i + 1; j < 4; j++) {

				students_morethanOneClass.addAll(classes[i]
						.getIntersectionOfStudents(classes[j].getStudents()));

			}
		}
		System.out.println(students_morethanOneClass.size() + " : "
				+ students_morethanOneClass.toString());

		System.out.println("=======================");
		/* Question 5 DONE */

	}

	/* Q6 */
	public void q6_profTeachingMoreThan1() {

		/* Question 6 */
		System.out
				.println("Question 6: Class Sections Taught: \n =======================");

		Set<Professor> prof_morethanOneClass = new HashSet<Professor>();

		for (int i = 0; i < 4; i++) {

			for (int j = i + 1; j < 4; j++) {

				/*
				 * TODO: check if classes[i,j] doesn't have empty professors
				 */

				prof_morethanOneClass.addAll(classes[i]
						.getIntersectionOfProfs(classes[j].getProfessors()));

			}
		}
		System.out.println(prof_morethanOneClass.size() + " : "
				+ prof_morethanOneClass.toString());

		System.out.println("=======================");
		/* Question 6 DONE */
	}

	public void readCSVData(String filePath) {

		for (int i = 0; i < 4; i++) {

			classes[i] = new SubjectClass();
		}

		/*
		 * TODO: Check if FileDoesn't exist
		 */

		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {

			br = new BufferedReader(new FileReader(filePath));
			while ((line = br.readLine()) != null) {

				String[] classData = line.split(cvsSplitBy);

				/* empty classes, no student, professor added */

				/*
				 * 
				 * check if 3rd location is Integer
				 */

				/*
				 * TODO: check if dataSplitted[0,1,2] are not null or empty
				 */
				switch (classData[0].toLowerCase()) {
				case "chemistry":
					classes[0].addRecord("Chemistry", classData[1].trim(),
							Integer.parseInt(classData[2].trim()));
					break;
				case "history":

					classes[1].addRecord("History", classData[1],
							Integer.parseInt(classData[2]));
					break;
				case "mathematics":
					classes[2].addRecord("Mathematics", classData[1],
							Integer.parseInt(classData[2]));
					break;
				case "physics":
					classes[3].addRecord("Physics", classData[1],
							Integer.parseInt(classData[2]));
					break;
				default:
					System.out.println("Subject not matched");
					break;
				}

			}

		} catch (FileNotFoundException e) {
			System.err.println("FileNotFound: " + e);
		} catch (IOException e) {
			System.err.println("IOException: " + e);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					System.err
							.println("IOException, Couldnot close file: " + e);
				}
			}
		}

	}

	public static void main(String[] args) {

		LauncherApp app = new LauncherApp();

		app.readCSVData("");
		app.q1_printSectionsTaught();
		app.q2_listClassesPerStudent();
		app.q3_atleastTwoClasses_MoreThanTwoStudents();
		app.q4_totalStudentsPerClass();
		app.q5_listStudentsMoreThan1();
		app.q6_profTeachingMoreThan1();

	}
}
