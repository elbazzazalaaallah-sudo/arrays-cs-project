package samplearrays;

import java.util.Arrays;
import java.util.Comparator;

public class ManageStudent {

    // 2) Find the Oldest Student
    public static Student findOldest(Student[] students) {
        Student oldest = students[0];
        for(Student student :students){
            if (student.getAge()>oldest.getAge()){
                oldest = student;
            }
        }
        return oldest;
    }

    // 3) Count Adult Students (age >= 18)
    public static int countAdults(Student[] students) {
        int adults = 0;
        for(Student student :students){
            if (student.getAge()>=18){
                adults++;
            }
        }
        return adults;
    }

    // 4) Average Grade (returns NaN if no students or grades)
    public static double averageGrade(Student[] students) {
        if (students == null || students.length==0){
            return Double.NaN;
        }else{
            int n = students.length;
            double sum = 0;
            for (Student student:students){
                sum += student.getGrade();
            }
            return (sum/n);
        }

    }

    // 5) Search by Name (case-sensitive; change to equalsIgnoreCase if desired)
    public static Student findStudentByName(Student[] students, String name) {
        for(Student student:students){
            if (student.getName().equals(name)){
                return student;
            }
        }return null;
    }

    // 6) Sort Students by Grade (descending)
    public static void sortByGradeDesc(Student[] students) {
        Arrays.sort(students, (a,b) -> b.getGrade()-a.getGrade());
    }

    // 7) Print High Achievers (grade >= 15)
    public static void printHighAchievers(Student[] students) {
        for(Student student:students){
            if (student.getGrade()>=15){
                System.out.println(student.getName());
            }
        }
    }

    // 8) Update Student Grade by id
    public static boolean updateGrade(Student[] students, int id, int newGrade) {
        for(Student student:students){
            if(student.getId() == id){
                student.setGrade(newGrade);
                return true;
            }
        }return false;
    }

    // 9) Find Duplicate Names
    public static boolean hasDuplicateNames(Student[] students) {
        boolean duplicatesFound = false;
        for(Student student : students){
            String studentName = student.getName();
            for (Student student1 : students){
                if (student1.getId() != student.getId() && student1.getName().equals(studentName)){
                    System.out.println("Duplicates Found");
                    duplicatesFound = true;
                    break;
                }
            }
        }
        return duplicatesFound;
    }

    // 10) Expandable Array: return a new array with one more slot and append student
    public static Student[] appendStudent(Student[] students, Student newStudent) {
        Student[] newStudents = new Student[students.length +1];
        for (int i=0;i<students.length;i++){
            newStudents[i] = students[i];
        }
        newStudents[newStudents.length-1] = newStudent;
        return newStudents;
    }

    // 1) Create an Array of Students + demos for all tasks
    public static void main(String[] args) {
        // Create & initialize array of 5 students
        Student[] arr = new Student[5];
        arr[0] = new Student(1,"Student1");
        arr[1] = new Student(2,"Student2",20);
        arr[2] = new Student(3, "Student2", 19);
        arr[3] = new Student(4, "Student4", 20, 12);
        arr[4] = new Student(5,"Student5", 19, 16);
        for (Student student:arr){
            student.toString();
        }

        // Print all
        System.out.println("== All Students ==");
        for (Student s : arr) System.out.println(s);
        System.out.println("Total created: " + Student.getNumStudent());

        // 2) Oldest
        Student oldest = findOldest(arr);
        oldest.toString();

        // 3) Count adults
        System.out.println("Number of adults : " + countAdults(arr));

        // 4) Average grade
        System.out.println("Average grade : " + averageGrade(arr));

        // 5) Find by name
        Student toFind = findStudentByName(arr, "Student1");
        if (toFind==null){
            System.out.println("Student not found");
        }else{
            System.out.println("Student found");
            toFind.toString();
        }

        // 6) Sort by grade desc
        // sort function
        sortByGradeDesc(arr);
        System.out.println("\n== Sorted by grade (desc) ==");
        for (Student s : arr) System.out.println(s);

        // 7) High achievers >= 15
        System.out.println("\nHigh achievers:");
        printHighAchievers(arr);

        // 8) Update grade by id
        // function
        boolean updated = updateGrade(arr, 4,13);
        System.out.println("\nUpdated id=4? " + updated);

        Student dina = findStudentByName(arr, "Dina");
        if (dina ==null){
            System.out.println("Student not found");
        }else{
            System.out.println("Student found");
            toFind.toString();
        }

        // 9) Duplicate names
        hasDuplicateNames(arr);

        // 10) Append new student
        Student s6 = new Student(6,"Student6");
        arr = appendStudent(arr, s6);

        Student[][] school = new Student[2][3];
        for(int i = 0; i<2;i++){
            for(int j=0; j<3; j++){
                school[i][j] = new Student((i+1)*(j+1), "Student"+(i+1)*(j+1), 19, (i+2)*(j+2));
            }
        }

        for(int i = 0; i<2;i++){
            System.out.println("Students' names of class " + (i+1));
            for(int j=0; j<3; j++){
                System.out.println(school[i][j].getName());
            }
        }

        updateGrade(school[0], 3, 15);
        updateGrade(school[1],6,18);
        for(int i = 0; i<2;i++){
            System.out.println("Top Student in class " + (i+1));
            printHighAchievers(school[i]);

        }


    }
}

