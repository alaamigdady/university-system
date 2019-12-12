import java.util.ArrayList;
import java.util.HashMap;

public class Department {
    private final String departmentName;
    private Faculty Faculty;
    private final String departmentId;
    private Syllabus Syllabus = new Syllabus(this);
    private HashMap<String,Instructor> Instructors;
    private Enroll enroll = Enroll.getInstance();
    private RegistrationUnit registrationUnit= RegistrationUnit.getInstance();
    private HashMap<Semester,ArrayList<Course>> registeredCourses;
    private int instructorId=0;


    public Department(String departmentName,Faculty Faculty,String departmentId ){
        if(departmentName == null|| !departmentName.matches("[a-zA-z]*"))
            throw new IllegalArgumentException("Enter department name");
        if(!(Faculty instanceof Faculty))
            throw new IllegalArgumentException("Enter a faculty");

        this.departmentName=departmentName;
        this.Faculty=Faculty;
        this.departmentId=departmentId;
        Instructors=new HashMap<>();
        registeredCourses=new HashMap<>();
    }

    public String getDepartmentName() {

        return departmentName;
    }

    public String getDepartmentId(){
        return departmentId;
    }

    public Faculty getAttachedFaculty() {

        return this.Faculty;
    }

    public void removeStudent(Student Student){

        if(!(Student instanceof Student))
            throw new IllegalArgumentException("Enter a Student");

        enroll.removeStudent(Student,this);
    }


    public ArrayList<Student> getEnrolledStudent(){
        return enroll.getAllEnrolledStudents(this);
    }

    public int numberOfEnrolledStudents(){
        return enroll.getAllEnrolledStudents(this).size();
    }

    public boolean isEnrolled(Student Student){
        if(!(Student instanceof Student))
            throw new IllegalArgumentException("Enter a Student");
        return enroll.getAllEnrolledStudents(this).contains(Student);
    }


    public void addInstructor(String instructorName){
        if(instructorName == null || !instructorName.matches("[a-zA-z]*+[0-9]*"))
            throw new IllegalArgumentException("Enter instructor name");
        String d = String.format("%02d",(instructorId));

        Instructor I = new Instructor(instructorName,departmentId+d,this);
        Instructors.put(departmentId+String.valueOf(instructorId),I);
        instructorId++;
    }

    public Instructor getInstructor(String instructorId){
        if(instructorId == null)
            throw new IllegalArgumentException("Enter instructor Id");
        if(!Instructors.containsKey(instructorId))
            throw new IllegalArgumentException("This instructor does not exist");
        return Instructors.get(departmentName);
    }

    public ArrayList<Instructor> getAllInstructors(){
        ArrayList<Instructor> instructors = new ArrayList<Instructor>(Instructors.values());
        return instructors;
    }

    public Syllabus createStudyPlan(){
        return  this.Syllabus;
    }

    public ArrayList<Course> getAllCourses(){
        return this.Syllabus.getAllCourses();
    }


    public boolean checkCourse(Course Course ,Semester Semester){
        return registeredCourses.get(Semester).contains(Course);
    }

    public void addCourses (ArrayList<Course> courses , Semester Semester){
        registeredCourses.put(Semester,courses);
    }

    public int numOfregisteredCourses(Semester Semester){

        return registeredCourses.get(Semester).size();
    }

}
