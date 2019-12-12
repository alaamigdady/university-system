import java.util.ArrayList;

public class Instructor {
    private final String instructorName;
    private final String instructorId;
    private Department Department;
    private ArrayList<Lecture> Lectures;
    private Grade grade= Grade.getInstance();


    public Instructor (String instructorName,String instructorId,Department Department){
        if(instructorName == null || !instructorName.matches("[a-zA-z]*+[0-9]*"))
            throw new IllegalArgumentException("Enter instructor name");
        if(!(Department instanceof Department))
            throw new IllegalArgumentException("Enter a Department");
        this.instructorId=instructorId;
        this.instructorName=instructorName;
        this.Department=Department;
        Lectures=new ArrayList<>();
    }

    public String getInstructorName() {
        return instructorName;
    }


    public String getInstructorId() {

        return instructorId;
    }

    public Department getDepartment() {
        return Department;
    }

    public void addLecture(Lecture lecture){
        Lectures.add(lecture);
    }
    public ArrayList<Lecture> getAllLectures(){
        return Lectures;
    }

    public void setGrade(Student Student , Course Course , char grade){
        this.grade.setGrade(Course,Student,this,grade);

    }

}
