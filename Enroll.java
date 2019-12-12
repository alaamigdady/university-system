import java.util.ArrayList;
import java.util.HashMap;

public class Enroll {

  private HashMap<Department, ArrayList<Student>> EnrolledStudents = new HashMap<Department, ArrayList<Student>>();

    private Enroll(){}
    private static Enroll enroll = new Enroll();
    public static Enroll getInstance(){
        return enroll;
    }

    public void enrollStudent(Student Student, Department Department) {
        if(!(Student instanceof Student)|| !(Department instanceof Department))
            throw new IllegalArgumentException();
        ArrayList<Student> Students;
        if (!EnrolledStudents.containsKey(Department)) {
            Students = new ArrayList<>();
            Students.add(Student);
            EnrolledStudents.put(Department, Students);
        } else {
            Students = EnrolledStudents.get(Department);
            if (!Students.contains(Student))
                Students.add(Student);
            EnrolledStudents.put(Department, Students);
        }
        updateStudent(Department,Student);
    }

    public void removeStudent(Student Student, Department Department) {
        if (!EnrolledStudents.containsKey(Department))
            throw new IllegalArgumentException("No such department");
        ArrayList<Student> Students = EnrolledStudents.get(Department);
        Students.remove(Student);
        EnrolledStudents.put(Department, Students);
        updateStudent(null,Student);
    }


    public ArrayList<Student> getAllEnrolledStudents(Department Department){
        if (!EnrolledStudents.containsKey(Department))
            throw new IllegalArgumentException("No such department");
        return EnrolledStudents.get(Department);
    }

    public void updateStudent(Department Department, Student Student){
        Student.setDepartment(Department);
    }


}
