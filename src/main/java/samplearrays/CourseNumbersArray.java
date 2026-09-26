package samplearrays;

public class CourseNumbersArray {
    public static void main(String[] args) {
        int[] registeredCourses = {1010, 1020, 2080, 2140, 2150, 2160};

        int[] updatedCourses = new int[registeredCourses.length + 1];
        for (int i=0; i<registeredCourses.length;i++){
            updatedCourses[i] = registeredCourses[i];
        }
        updatedCourses[updatedCourses.length -1] = 2170;

        for (int course : updatedCourses){
            System.out.println(course);
        }

        int courseToFind1 = 2080;
        int courseToFind2 = 2000;
        boolean courseExists = false;
        for(int course : updatedCourses){
            if(course == courseToFind1){
                courseExists = true;
                break;
            }
        }
        if (courseExists){
            System.out.println("updateCourses contains course "+courseToFind1);
        }else{
            System.out.println("updateCourses does not contain course "+courseToFind1);
        }


    }
}
