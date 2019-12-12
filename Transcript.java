import java.util.ArrayList;
import java.util.HashMap;

public class Transcript {
    private Student Student;
    private Grade grade= Grade.getInstance();
    private ArrayList<Course> courses=new ArrayList<>();

    public Transcript (Student Student){
        this.Student = Student;
        this.courses=Student.getDepartment().getAllCourses();
    }

    public void getTranscript(){
        System.out.println("****************************************************");
        System.out.println("Student Name : " + Student.getStudentName()+" StudentID :" + Student.getStudentId() +" Departmnet :  " +Student.getDepartment().getDepartmentName() );
        for(Course c : courses){
            String Status;
            if(!grade.isEvaluated(c,Student))
                System.out.println("Course Name : "+c.getCourseName()+" The Grade : Not Set yet");
            else {
                if (Student.checkStatus(c))
                    Status = "passed";
                else
                    Status = "failed";
                System.out.println("Course Name : " + c.getCourseName() + " The Grade :" + grade.getGrade(Student, c) + " Status :" + Status);
            }
        }
        System.out.println("The average is : " + grade.getAverage(Student));
        System.out.println("****************************************************");

    }
}

