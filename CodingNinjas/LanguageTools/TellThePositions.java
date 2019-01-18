import java.util.*;

class Main {
  static class School {
    class Student implements Comparable<Student> {
      public String name;
      public int total;

      Student(String name, int total) {
        this.name = name;
        this.total = total;
      }

      public int compareTo(Student person) {
        return person.total - this.total;
      }
    }

    List<Student> students = new ArrayList<>();

    public void addStudents(Scanner in, int n) {
      while (n-- > 0) {
        String name = in.next();
        int ds = in.nextInt();
        int algo = in.nextInt();
        int os = in.nextInt();
        Student s = new Student(name, ds + algo + os);
        students.add(s);
      }
    }

    public void sortStudents() {
      Collections.sort(this.students);
    }

    public void printStudents() {
      for (int counter = 0; counter < this.students.size(); counter++) {
        System.out.println((counter + 1) + " " + students.get(counter).name);
      }
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    School school = new School();
    school.addStudents(in, n);
    school.sortStudents();
    school.printStudents();
    in.close();
  }
}
