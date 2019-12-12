import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws ParseException {
        // creating university
        University JUST = new University("Just");

        // adding faculties
        JUST.addFaculty("IT");
        JUST.addFaculty("ENG");

        Faculty IT = JUST.getFaculty("IT");
        Faculty ENG = JUST.getFaculty("ENG");


        // adding departments
        IT.addDepartment("CS");
        IT.addDepartment("CIS");

        ENG.addDepartment("Electrical");
        ENG.addDepartment("Civil");
        ENG.addDepartment("Mechanical");

        Department CS = IT.getDepartment("CS");
        Department CIS = IT.getDepartment("CIS");
        Department Electrical = ENG.getDepartment("Electrical");
        Department Civil = ENG.getDepartment("Civil");
        Department Mechanical = ENG.getDepartment("Mechanical");

        // enroll 1000 students randomly to departments
        String name = "student";

        for (int i = 0; i < 1000; i++) {
            Department d;
            double dep = Math.random();
            if (dep <= 0.2)
                d = CS;
            else if (dep <= 0.4)
                d = CIS;
            else if (dep <= 0.6)
                d = Electrical;
            else if (dep <= 0.8)
                d = Civil;
            else
                d = Mechanical;
            JUST.enrollStudent(name + i, d);
        }

        // number of enrolled students in each department
        System.out.println("********number of enrolled students in each department**********");
        System.out.println("Number of students in CS department is : " + CS.numberOfEnrolledStudents());
        System.out.println("Number of students in CIS department is : " + CIS.numberOfEnrolledStudents());
        System.out.println("Number of students in Electrical department is : " + Electrical.numberOfEnrolledStudents());
        System.out.println("Number of students in Mechanical department is : " + Mechanical.numberOfEnrolledStudents());
        System.out.println("Number of students in Civil department is : " + Civil.numberOfEnrolledStudents());
        System.out.println("******************************************************************");

        // adding 10 instructors for each department
        String instructorName = "instructor";
        for (int i = 0; i < 10; i++) {
            CIS.addInstructor("cis"+instructorName + i);
            CS.addInstructor("cs"+instructorName + i);
            Electrical.addInstructor("electrical"+instructorName + i);
            Civil.addInstructor("civil"+instructorName + i);
            Mechanical.addInstructor("mechanical"+instructorName + i);

        }

        System.out.println("********number of instructors in each department**********");
        System.out.println("Number of students in CS department is : " + CS.getAllInstructors().size());
        System.out.println("Number of students in CIS department is : " + CIS.getAllInstructors().size());
        System.out.println("Number of students in Electrical department is : " + Electrical.getAllInstructors().size());
        System.out.println("Number of students in Mechanical department is : " + Mechanical.getAllInstructors().size());
        System.out.println("Number of students in Civil department is : " + Civil.getAllInstructors().size());
        System.out.println("******************************************************************");


        // creating study plans for each department
        Syllabus cisSyllabus = CIS.createStudyPlan();
        Syllabus csSyllabus = CS.createStudyPlan();
        Syllabus electricalSyllabus = Electrical.createStudyPlan();
        Syllabus mechanicalSyllabus = Mechanical.createStudyPlan();
        Syllabus civilSyllabus = Civil.createStudyPlan();

        // adding 20 courses for each study plan
        String courseName = "course";
        for (int i = 0; i < 20; i++) {
            cisSyllabus.addCourse("cis"+courseName + i);
            csSyllabus.addCourse("cs"+courseName + i);
            electricalSyllabus.addCourse("electrical"+courseName + i);
            mechanicalSyllabus.addCourse("mechanical"+courseName + i);
            civilSyllabus.addCourse("civil"+courseName + i);

        }

        // adding 100 classrooms to the university
        for (int i = 0; i < 100; i++)
            JUST.addClassRoom();

        // creating semester : the first semester
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = dateFormat.parse("1/1/2019");
        Date date2 = dateFormat.parse("1/6/2019");

        Semester First =  JUST.startSemester(date1,date2);

        // creating schedules for random 8 courses for each department for the first semester
        ArrayList<Course> courses1 =new ArrayList<>();
        ArrayList<Course> All1;

        // for CS department
        All1 = CS.getAllCourses();
        while (courses1.size()!=8){
            int i = (int) Math.floor(Math.random()*20);
            courses1.add(All1.get(i));

        }
        First.createSchedule(CS,courses1);
        System.out.println("********************** FIRST Semester Lectures Schedule for all Departments********************************");

        System.out.println("******************************CS Department ***********************");
        HashMap<LectureTime, ArrayList<Lecture>> lectures1 = First.getSchedule(CS);
        for (LectureTime Key : lectures1.keySet()) {
            for (int i = 0; i < lectures1.get(Key).size(); i++) {
                System.out.println("time : "+ Key.getHour()+" " + Key.getOption()+" section : "+lectures1.get(Key).get(i).getSection() + " course name : " + lectures1.get(Key).get(i).getCourse().getCourseName() + " instructor : " + lectures1.get(Key).get(i).getInstructor().getInstructorName() + " classromm : " + lectures1.get(Key).get(i).getClassRoom().getClassroomId());
            }
        }

        // for CIS department
        ArrayList<Course> courses2 =new ArrayList<>();
        ArrayList<Course> All2=CIS.getAllCourses();
        while (courses2.size()!=8){
            int i = (int) Math.floor(Math.random()*20);
            courses2.add(All2.get(i));

        }
        First.createSchedule(CIS,courses2);
        System.out.println("******************************CIS Department ***********************");
        HashMap<LectureTime, ArrayList<Lecture>> lectures2 = First.getSchedule(CIS);
        for (LectureTime Key : lectures2.keySet()) {
            for (int i = 0; i < lectures2.get(Key).size(); i++) {
                System.out.println("time : "+ Key.getHour()+" " + Key.getOption()+" section : "+lectures2.get(Key).get(i).getSection() + " course name : " + lectures2.get(Key).get(i).getCourse().getCourseName() + " instructor : " + lectures2.get(Key).get(i).getInstructor().getInstructorName() + " classromm : " + lectures2.get(Key).get(i).getClassRoom().getClassroomId());
            }
        }
        // for electrical department
        ArrayList<Course> courses3 =new ArrayList<>();
        ArrayList<Course> All3=Electrical.getAllCourses();
        while (courses3.size()!=8){
            int i = (int) Math.floor(Math.random()*20);
            courses3.add(All3.get(i));

        }
        First.createSchedule(Electrical,courses3);
        System.out.println("******************************Electrical Department ***********************");
        HashMap<LectureTime, ArrayList<Lecture>> lectures3 = First.getSchedule(Electrical);
        for (LectureTime Key : lectures3.keySet()) {
            for (int i = 0; i < lectures3.get(Key).size(); i++) {
                System.out.println("time : "+ Key.getHour()+" " + Key.getOption()+" section : "+lectures3.get(Key).get(i).getSection() + " course name : " + lectures3.get(Key).get(i).getCourse().getCourseName() + " instructor : " + lectures3.get(Key).get(i).getInstructor().getInstructorName() + " classromm : " + lectures3.get(Key).get(i).getClassRoom().getClassroomId());
            }
        }

        // for Civil department
        ArrayList<Course> courses4 =new ArrayList<>();
        ArrayList<Course> All4=Civil.getAllCourses();
        while (courses4.size()!=8){
            int i = (int) Math.floor(Math.random()*20);
            courses4.add(All4.get(i));

        }
        First.createSchedule(Civil,courses4);

        System.out.println("******************************Civil Department ***********************");
        HashMap<LectureTime, ArrayList<Lecture>> lectures4 = First.getSchedule(Civil);
        for (LectureTime Key : lectures4.keySet()) {
            for (int i = 0; i < lectures4.get(Key).size(); i++) {
                System.out.println("time : "+ Key.getHour()+" " + Key.getOption()+" section : "+lectures4.get(Key).get(i).getSection() + " course name : " + lectures4.get(Key).get(i).getCourse().getCourseName() + " instructor : " + lectures4.get(Key).get(i).getInstructor().getInstructorName() + " classromm : " + lectures4.get(Key).get(i).getClassRoom().getClassroomId());
            }
        }

        // for Mechanical department
        ArrayList<Course> courses5 =new ArrayList<>();
        ArrayList<Course> All5=Mechanical.getAllCourses();
        while (courses5.size()!=8){
            int i = (int) Math.floor(Math.random()*20);
            courses5.add(All5.get(i));

        }
        First.createSchedule(Mechanical,courses5);
        System.out.println("******************************Mechanical Department ***********************");
        HashMap<LectureTime, ArrayList<Lecture>> lectures5 = First.getSchedule(Mechanical);
        for (LectureTime Key : lectures5.keySet()) {
            for (int i = 0; i < lectures5.get(Key).size(); i++) {
                System.out.println("time : "+ Key.getHour()+" " + Key.getOption()+" section : "+lectures5.get(Key).get(i).getSection() + " course name : " + lectures5.get(Key).get(i).getCourse().getCourseName() + " instructor : " + lectures5.get(Key).get(i).getInstructor().getInstructorName() + " classromm : " + lectures5.get(Key).get(i).getClassRoom().getClassroomId());
            }
        }
        /////////////////////////////////////////////////////////////////////
        // Assign random students to 5 random lectures and printing their schedule;
        // CS student
        Student CSStudent = CS.getEnrolledStudent().get(0);
        for(int i =0 ; i<5 ; i++){
            int section = (int) Math.floor(Math.random()*2)+1;
            int index = (int) Math.floor(Math.random()*8);
            Course c = courses1.get(index);
            First.assignToLecture(CSStudent,c,section);
        }
        HashMap<LectureTime,Lecture> Cslectures = First.getStudentLectures(CSStudent);
        System.out.println("******************************CS Student ***********************");
        for(LectureTime l : Cslectures.keySet()){
            System.out.println("Lecture time is : "+l.getHour()+","+l.getOption()+" course name :"+ Cslectures.get(l).getCourse().getCourseName()+ " section : "+Cslectures.get(l).getSection()+" class room : "+Cslectures.get(l).getClassRoom().getClassroomId());
        }

        // CIS student
        Student CISStudent = CIS.getEnrolledStudent().get(0);
        for(int i =0 ; i<5 ; i++){
            int section = (int) Math.floor(Math.random()*2)+1;
            int index = (int) Math.floor(Math.random()*8);
            Course c = courses2.get(index);
            First.assignToLecture(CISStudent,c,section);
        }
        HashMap<LectureTime,Lecture> Cislectures = First.getStudentLectures(CISStudent);
        System.out.println("******************************CIS Student ***********************");
        for(LectureTime l : Cislectures.keySet()){
            System.out.println("Lecture time is : "+l.getHour()+","+l.getOption()+" course name :"+ Cislectures.get(l).getCourse().getCourseName()+ " section : "+Cislectures.get(l).getSection()+" class room : "+Cislectures.get(l).getClassRoom().getClassroomId());
        }

        // Electrical student
        Student eStudent = Electrical.getEnrolledStudent().get(0);
        for(int i =0 ; i<5 ; i++){
            int section = (int) Math.floor(Math.random()*2)+1;
            int index = (int) Math.floor(Math.random()*8);
            Course c = courses3.get(index);
            First.assignToLecture(eStudent,c,section);
        }
        HashMap<LectureTime,Lecture> electures = First.getStudentLectures(eStudent);
        System.out.println("******************************Electrical Student ***********************");
        for(LectureTime l : electures.keySet()){
            System.out.println("Lecture time is : "+l.getHour()+","+l.getOption()+" course name :"+ electures.get(l).getCourse().getCourseName()+ " section : "+electures.get(l).getSection()+" class room : "+electures.get(l).getClassRoom().getClassroomId());
        }

        // Civil student
        Student cStudent = Civil.getEnrolledStudent().get(0);
        for(int i =0 ; i<5 ; i++){
            int section = (int) Math.floor(Math.random()*2)+1;
            int index = (int) Math.floor(Math.random()*8);
            Course c = courses4.get(index);
            First.assignToLecture(cStudent,c,section);
        }
        HashMap<LectureTime,Lecture> clectures = First.getStudentLectures(cStudent);
        System.out.println("******************************Civil Student ***********************");
        for(LectureTime l : clectures.keySet()){
            System.out.println("Lecture time is : "+l.getHour()+","+l.getOption()+" course name :"+ clectures.get(l).getCourse().getCourseName()+ " section : "+clectures.get(l).getSection()+" class room : "+clectures.get(l).getClassRoom().getClassroomId());
        }

        // Mechanical student
        Student mStudent = Mechanical.getEnrolledStudent().get(0);
        for(int i =0 ; i<5 ; i++){
            int section = (int) Math.floor(Math.random()*2)+1;
            int index = (int) Math.floor(Math.random()*8);
            Course c = courses5.get(index);
            First.assignToLecture(mStudent,c,section);
        }
        HashMap<LectureTime,Lecture> mlectures = First.getStudentLectures(mStudent);
        System.out.println("******************************Mechanical Student ***********************");
        for(LectureTime l : mlectures.keySet()){
            System.out.println("Lecture time is : "+l.getHour()+","+l.getOption()+" course name :"+ mlectures.get(l).getCourse().getCourseName()+ " section : "+mlectures.get(l).getSection()+" class room : "+mlectures.get(l).getClassRoom().getClassroomId());
        }

        ///////////////////////////////////////////////////////
        // Assign grades and printing transcript
        System.out.println("***************Transcript for CS student *******************");
        char[] grades={'A','B','C','D','F'};
        int i =0;
        Instructor I = CS.getAllInstructors().get(0);
        for(LectureTime l : Cslectures.keySet()){
            Course c = Cslectures.get(l).getCourse();
            I.setGrade(CSStudent,c,grades[i]);
            i++;
        }

        CSStudent.getTranscript();

        //////////////////////////////////////////////////
        // show information about random instructor
        System.out.println("*************Instructor Information***********");
        Instructor e = Electrical.getAllInstructors().get(7);
        System.out.println("Name : " +e.getInstructorName() +" ID: "+ e.getInstructorId());
        ArrayList<Lecture> lecs = e.getAllLectures();
        for(int j =0; j<lecs.size();j++)
            System.out.println("course name :"+ lecs.get(j).getCourse().getCourseName()+" section :"+ lecs.get(j).getSection());

    }
}



