import java.util.ArrayList;
import java.util.HashMap;

public class Grade {
    private HashMap<Character,Integer> grades=new HashMap<>();
    private HashMap<Student, HashMap<Course,Character>>studentsGrades=new HashMap<>();

    private Grade(){
        grades.put('A',4);
        grades.put('B',3);
        grades.put('C',2);
        grades.put('D',1);
        grades.put('F',0);
    }
    private static Grade grade = new Grade(){};
    public static Grade getInstance(){
        return grade;
    }


    public void setGrade(Course Course , Student Student, Instructor Instructor, char grade){
        if(!(Course instanceof  Course))
            throw new IllegalArgumentException("Enter a course");
        if(!(Student instanceof Student))
            throw new IllegalArgumentException("Enter a Student");
        if(!Student.checkCourse(Course))
            throw new IllegalArgumentException("The student did not register this course yet");
        if(!Student.getDepartment().getDepartmentId().equals(Instructor.getDepartment().getDepartmentId()))
            throw new IllegalArgumentException("you are not allowed to set grade to this student");
        if(!grades.containsKey(grade))
            throw new IllegalArgumentException("The grade you entered is not acceptable");
        if(!studentsGrades.containsKey(Student)) {
            HashMap<Course, Character>g = new HashMap<>();
            studentsGrades.put(Student,g);
        }
        studentsGrades.get(Student).put(Course,grade);

        if(grades.get(grade)>=2) {
            Student.setStatus(Course);
        }
    }

    public char getGrade (Student Student, Course Course){
        return studentsGrades.get(Student).get(Course);
    }

    public char getAverage(Student Student){
        HashMap<Course,Character> grades = studentsGrades.get(Student);
        int sum =0;
        for(Course c : grades.keySet()){
            sum+=this.grades.get(grades.get(c));
        }
        int avg = (int) sum/studentsGrades.get(Student).size();
        if (this.grades.get('A')==avg)
            return 'A';
        else if ((this.grades.get('B')==avg))
            return 'B';
        else if ((this.grades.get('C')==avg))
            return  'C';
        else if (this.grades.get('D')==avg)
            return 'D';
        return 'F';
    }

    public boolean isEvaluated(Course Course , Student Student){
        return studentsGrades.get(Student).containsKey(Course);
    }
}
