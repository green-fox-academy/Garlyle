package GreenFox;

import java.util.ArrayList;

public class LagopusClass {
  String className;
  ArrayList<Student> students;
  ArrayList<Mentor> mentors;

  public LagopusClass(String className)
  {
    students = new ArrayList<>();
    mentors = new ArrayList<>();

    this.className = className;
  }

  public void addStudent(Student student)
  {
    students.add(student);
  }

  public void addMentor(Mentor mentor)
  {
    mentors.add(mentor);
  }

  public void info()
  {
    System.out.println("Lagopus " + className + " class has " + students.size() + " students and "
        + mentors.size() + " mentors.");
  }
}
