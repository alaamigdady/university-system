import java.util.ArrayList;
import java.util.HashMap;

public class Schedule {
    private RegistrationUnit registrationUnit = RegistrationUnit.getInstance();
//    private HashMap<LectureTime, ArrayList<Instructor>> reservedInstructors = new HashMap<>();
//    private HashMap<LectureTime, ArrayList<Course>> reservedCourses = new HashMap<>();
//    private HashMap<LectureTime, ArrayList<Lecture>> sch = new HashMap<>();
  private Semester Semester;


    public Schedule(Semester Semester) {
        this.Semester = Semester;
    }



    public HashMap<LectureTime,ArrayList<Lecture>> createSchedule(Department Department,ArrayList<Course> courses){
         HashMap<LectureTime, ArrayList<Instructor>> reservedInstructors = new HashMap<>();
         HashMap<LectureTime, ArrayList<Course>> reservedCourses = new HashMap<>();
         HashMap<LectureTime, ArrayList<Lecture>> sch = new HashMap<>();
        for (int i = 8; i <= 13; i++) {
            LectureTime t1 = new LectureTime(i, 0);
            LectureTime t2 = new LectureTime(i, 1);
            reservedCourses.put(t1, new ArrayList<>());
            reservedInstructors.put(t1, new ArrayList<>());
            sch.put(t1, new ArrayList<>());
            reservedCourses.put(t2, new ArrayList<>());
            reservedInstructors.put(t2, new ArrayList<>());
            sch.put(t2, new ArrayList<>());
        }


        int hour = 0;
        int option = 0;
        ArrayList<Instructor> instructors = Department.getAllInstructors();
        Instructor instructor = null;
        ClassRoom classRoom = null;
        LectureTime t1 = null;
        for ( int j = 1; j <= 3; j++) {

            for (int i = 0; i <courses.size(); i++) {
                boolean found = false;
                while (!found) {
                    hour = (int) (Math.random() * 6) + 8;
                    option = (int) Math.floor((Math.random() * 2));
                    t1 = new LectureTime(hour, option);

                    int s = (int) Math.floor(Math.random() * instructors.size());
                    instructor = instructors.get(s);


                    int c = (int) Math.floor(Math.random() * 99);
                    classRoom = registrationUnit.getClassroom(String.format("%03d", c));

                    if (!reservedInstructors.get(t1).contains(instructor) && !reservedCourses.get(t1).contains(courses.get(i))  && !registrationUnit.checkClassroom(t1, classRoom,Semester))
                        found = true;
                }
                Lecture l = new Lecture(courses.get(i), classRoom, instructor, t1, j,Semester);
                reservedInstructors.get(t1).add(instructor);
                instructor.addLecture(l);
                reservedCourses.get(t1).add(courses.get(i));
                courses.get(i).addLecture(l);
                registrationUnit.reserveClassroom(t1, classRoom,Semester);
                classRoom.addLecture(l);
                sch.get(t1).add(l);

            }

        }
        return sch;
    }



//    private boolean checkInstructor(Instructor instructor,LectureTime t){
//
//        return reservedInstructors.get(t).contains(instructor);
//    }
//
//
//    private boolean checkCourse(Course course, LectureTime t){
//
//        return reservedCourses.get(t).contains(course) ;
//    }





}