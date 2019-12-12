import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class University {

    private String universityName;
    private HashMap<String,Faculty> Faculties;
    private HashMap<Integer,Student> Students;
    private Integer studentId = 2019000;
    private Integer facultyId = 0;
    private Enroll enroll = Enroll.getInstance();
    private RegistrationUnit registrationUnit = RegistrationUnit.getInstance();



    public University(String universityName){
        if(universityName == null || !universityName.matches("[a-zA-z]*"))
            throw new IllegalArgumentException("Enter university name");
        this.universityName=universityName;
        Faculties = new HashMap<>();
        Students = new HashMap<>();
    }


    public void addFaculty(String facultyName){
        if(facultyName == null || !facultyName.matches("[a-zA-z]*"))
            throw new IllegalArgumentException("Enter faculty name");
        if(Faculties.containsKey(facultyName))
            throw new IllegalArgumentException("This faculty already exist");
        Faculty F = new Faculty(facultyName,(facultyId));
        Faculties.put(facultyName,F);
        facultyId++;
    }

    public Faculty getFaculty(String facultyName){
        if(facultyName == null)
            throw new IllegalArgumentException("Enter faculty name");
        if(!Faculties.containsKey(facultyName))
            throw new IllegalArgumentException("This faculty does not exist");
        return Faculties.get(facultyName);
    }


    public void enrollStudent(String studentName,Department Department){
        if(studentName == null || !studentName.matches("[a-zA-z]*+[0-9]*"))
            throw new IllegalArgumentException("Enter student name");
        if(!(Department instanceof Department))
            throw new IllegalArgumentException("Enter a Department");
        Student s = new Student(studentName,studentId);
        Students.put(studentId,s);
        enroll.enrollStudent(s,Department);
        studentId++;
   }

   public Student getStudent(Integer studentId){
        if(!(studentId instanceof Integer))
            throw new IllegalArgumentException("Enter student id");
        if(!Students.containsKey(studentId))
            throw new IllegalArgumentException("This student does not exist");
        return Students.get(studentId);
   }

    public HashMap<Integer, Student> getAllStudents() {

        return Students;
    }

    public void addClassRoom(){

        registrationUnit.addClassRoom();
    }

    public ClassRoom getClassroom(String classroomId){

        return registrationUnit.getClassroom(classroomId);
    }

    public Semester startSemester (Date startDate,Date endDate ){
        if(startDate.equals(endDate) || startDate.after(endDate))
            throw new IllegalArgumentException("Enter correct Dates");
        return  registrationUnit.startSemester(startDate,endDate);
    }




}
