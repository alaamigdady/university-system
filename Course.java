import java.util.ArrayList;

public class Course  {
    private String courseName;
    private Department Department;
    private String courseCode;
    private ArrayList<Lecture> Lectures;

    public Course(String courseName, Department Department, String courseCode){
        if(courseName == null ||!courseName.matches("[a-zA-z]*+[0-9]*"))
            throw new IllegalArgumentException("Enter course name");
        if(!(Department instanceof Department))
            throw new IllegalArgumentException("Enter a Department");
        this.courseName=courseName;
        this.Department=Department;
        this.courseCode= courseCode;
        Lectures=new ArrayList<>();
    }

    public Department getDepartment() {

        return Department;
    }



    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }
    public void addLecture(Lecture lecture){
        Lectures.add(lecture);
    }
    public ArrayList<Lecture> getAllLectures(){
        return Lectures;
    }


}
