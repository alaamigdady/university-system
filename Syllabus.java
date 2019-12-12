import java.util.ArrayList;
import java.util.HashMap;

public class Syllabus {
    private HashMap<String,Course> Courses=new HashMap<>();
    private Department Department;
    private int courseId=0;

    public Syllabus(Department Department){
        if(!(Department instanceof Department))
            throw new IllegalArgumentException("Enter a Department");
       this.Department = Department ;

    }



    public void addCourse(String courseName ){
        if(courseName == null || !courseName.matches("[a-zA-z]*+[0-9]*"))
            throw new IllegalArgumentException("Enter course name");
        String code = String.format("%03d",(courseId));

        Course c = new Course(courseName,this.Department,this.Department.getDepartmentId()+code);
        Courses.put(this.Department.getDepartmentId()+String.valueOf(courseId),c);
        courseId++;
    }

    public void removeCourse(String courseCode){
        if(courseCode == null)
            throw new IllegalArgumentException("Enter course code");
        if(!Courses.containsKey(courseCode))
            throw new IllegalArgumentException("This course does not exist");

        Courses.remove(courseCode);
    }

    public ArrayList<Course> getAllCourses(){
        ArrayList<Course> courses = new ArrayList<Course>(Courses.values());
        return courses;
    }

    public Department getDepartment() {

        return Department;
    }

}
