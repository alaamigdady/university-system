import java.util.ArrayList;
import java.util.HashMap;

public class Student {
    private final String StudentName;
    private final Integer StudentId;
    private Department Department;
    private RegistrationUnit registrationUnit= RegistrationUnit.getInstance();
    private HashMap<Course,Boolean> registeredCourses;
//    private Transcript Transcript = new Transcript(this);




    public Student(String studentName,Integer studentId){
        if(studentName == null || !studentName.matches("[a-zA-z]*+[0-9]*"))
            throw new IllegalArgumentException("Enter student name");
        this.StudentName=studentName;
        this.StudentId=studentId;
        registeredCourses=new HashMap<>();
    }

    public String getStudentName() {

        return StudentName;
    }

    public Integer getStudentId() {

        return StudentId;
    }

    public Department getDepartment() {
        return Department;
    }

    public void setDepartment(Department department) {
        Department = department;
    }


    public boolean checkCourse(Course Course){
        return registeredCourses.containsKey(Course);
    }

    public void registerCourse(Course course){

        registeredCourses.put(course,false);
    }

    public int numOfregisteredCourses(){
        return registeredCourses.size();
    }

    public boolean checkStatus  (Course Course){
        if(!registeredCourses.containsKey(Course))
            return false;
        return registeredCourses.get(Course);
    }

    public void setStatus(Course Course){
        registeredCourses.put(Course,true);
    }
    public void getTranscript(){
         Transcript Transcript = new Transcript(this);

        Transcript.getTranscript();
    }

}
