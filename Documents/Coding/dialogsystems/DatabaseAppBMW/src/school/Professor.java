package school;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*API for Professor*/
public class Professor {
	// name of the professor
	String profName;

	// class teaching and students in that class
	HashMap<String, Set<Integer>> class_students = new HashMap<String, Set<Integer>>();

	public Professor(String profName, String className, Integer studentNumber) {

		this.profName = profName;

		if (class_students.containsKey(className)) {
			class_students.get(className).add(studentNumber);
		} else {
			Set<Integer> students = new HashSet<Integer>();

			students.add(studentNumber);

			class_students.put(className, students);

		}

	}

	public String getName() {

		return this.profName;

	}

	public Professor(String name) {

		this.profName = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professor other = (Professor) obj;
		if (profName == null) {
			if (other.profName != null)
				return false;
		} else if (!profName.equalsIgnoreCase(other.profName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Professor [profName=" + profName + "]";
	}

}
