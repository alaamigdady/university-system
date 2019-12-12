import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


public class RegistrationUnit {
    private static HashMap<String,ClassRoom> Classrooms=new HashMap<>();
    private static  HashMap<Semester,HashMap<LectureTime, ArrayList<ClassRoom>>> reservedClassrooms = new HashMap<>();
    private static Integer classroomId=0;


    private RegistrationUnit(){
    }
    private static RegistrationUnit registrationUnit = new RegistrationUnit(){};
    public static RegistrationUnit getInstance(){
        return registrationUnit;
    }



    public void addClassRoom(){
        String d = String.format("%03d",classroomId);
        double c = Math.random();
        ClassRoom r;
        r= new ClassRoom(d,20);
        Classrooms.put(r.getClassroomId(),r);
        classroomId++;

    }

    public ClassRoom getClassroom(String classroomId){
        if(classroomId == null || !classroomId.matches("[0-9]{3}"))
            throw new IllegalArgumentException("Enter classroomId name");
        return Classrooms.get(classroomId);
    }

    public void reserveClassroom(LectureTime lectureTime, ClassRoom classRoom, Semester semester){
        reservedClassrooms.get(semester).get(lectureTime).add(classRoom);
    }

    public boolean checkClassroom(LectureTime lectureTime, ClassRoom classRoom,Semester semester){
        return reservedClassrooms.get(semester).get(lectureTime).contains(classRoom);
    }



    public Semester startSemester(Date startDate , Date endDate){
        if(startDate.equals(endDate) || startDate.after(endDate))
            throw new IllegalArgumentException("Enter correct Dates");
        Semester s = new Semester(startDate,endDate);
        HashMap<LectureTime, ArrayList<ClassRoom>> rooms = new HashMap<>();
              for(int i = 8;i<=13;i++){
            LectureTime t1 = new LectureTime(i, 0);
            LectureTime t2 = new LectureTime(i, 1);
            rooms.put(t1,new ArrayList<>());
            rooms.put(t2,new ArrayList<>());
        }
       reservedClassrooms.put(s,rooms);

        return s;
    }




//    public HashMap<LectureTime,ArrayList<Lecture>> getSchedule (Department Department,Semester Semester){
//        if(!(Department instanceof Department ))
//            throw new IllegalArgumentException("Enter a Department");
//        if(!(Semester instanceof Semester))
//            throw new IllegalArgumentException("Enter a Semester");
//
//        return Semester.getSchedule(Department);
//    }


//       public boolean joinLecture(Student Student , Course Course , int section , Semester Semester){
//        if(!Student.getDepartment().getAllCourses().contains(Course))
//            throw new IllegalArgumentException("This course is not in your study plan");
//
//        if(!Student.getDepartment().checkCourse(Course,Semester))
//            throw new IllegalArgumentException("This course is not available in this semester");
//
//        if(Student.checkStatus(Course))
//            throw new IllegalArgumentException("you already passed this course");
//       // System.out.println("heere register");
//       return Semester.assignToLecture(Student,Course,section);
//       }

}

