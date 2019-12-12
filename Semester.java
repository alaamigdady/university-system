import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


public class Semester {
    private Date startDate;
    private Date endDate;
    private HashMap<Department,HashMap<LectureTime,ArrayList<Lecture>>> Schedules;
    private HashMap<Student,HashMap<LectureTime,Lecture>> studentsSchedules;

    private Schedule departmentSchedule;



    public Semester (Date startDate, Date endDate){
        if(startDate.equals(endDate) || startDate.after(endDate))
            throw new IllegalArgumentException("Enter correct Dates");
        this.startDate = startDate;
        this.endDate = endDate;
        Schedules = new HashMap<>();
        studentsSchedules= new HashMap<>();
        this.departmentSchedule= new Schedule(this);


    }


    public Schedule startDepartmentSchedule (){
        return this.departmentSchedule;
    }

    public void createSchedule(Department Department, ArrayList<Course> courses ){
        if(!(Department instanceof Department ))
            throw new IllegalArgumentException("Enter a Department");
        if(courses.size() < Department.getAllCourses().size()) {
            Schedule s = startDepartmentSchedule();
            HashMap<LectureTime,ArrayList<Lecture>> schedule = s.createSchedule(Department, courses);

            addSchedule(Department, schedule);
            Department.addCourses(courses,this);
        }else{
            throw new IllegalArgumentException("You are not allowed to register this number of courses");
        }
    }

    public void addSchedule(Department Department, HashMap<LectureTime,ArrayList<Lecture>> Schedule){
        if(!(Department instanceof Department ))
            throw new IllegalArgumentException("Enter a Department");
        Schedules.put(Department, Schedule);

    }

    public HashMap<LectureTime,ArrayList<Lecture>> getSchedule (Department Department){
        if(!(Department instanceof Department ))
            throw new IllegalArgumentException("Enter a Department");
        if(!Schedules.containsKey(Department))
            throw new IllegalArgumentException("The Schedule for this department hav not been created yet");
        return Schedules.get(Department);
    }

    public boolean assignToLecture(Student Student , Course Course , int section){
        if(!Student.getDepartment().getAllCourses().contains(Course))
            throw new IllegalArgumentException("This course is not in your study plan");

        if(!Student.getDepartment().checkCourse(Course,this))
            throw new IllegalArgumentException("This course is not available in this semester");

        if(Student.checkStatus(Course))
            throw new IllegalArgumentException("you already passed this course");

        if(!studentsSchedules.containsKey(Student)) {
            studentsSchedules.put(Student,new HashMap<>());
        }
       HashMap<LectureTime,ArrayList<Lecture>> schedule = getSchedule(Student.getDepartment());
        for(LectureTime time : schedule.keySet()){
            for (int i =0;i<schedule.get(time).size();i++){
                Lecture l = schedule.get(time).get(i);

                if(l.getCourse().getCourseCode().equals(Course.getCourseCode())&&l.getSection()==section&&!checkStudentAvialvility(Student,l.getLectureTime())) {

                    studentsSchedules.get(Student).put(l.getLectureTime(),l);
                    Student.registerCourse(Course);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkStudentAvialvility(Student Student , LectureTime LectureTime){
        return studentsSchedules.get(Student).containsKey(LectureTime);
    }

    public HashMap<LectureTime,Lecture> getStudentLectures (Student Student){
        return studentsSchedules.get(Student);
    }
}
