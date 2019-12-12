public class Lecture implements Comparable<Lecture> {
    private ClassRoom ClassRoom;
    private Course Course;
    private Instructor Instructor;
    private LectureTime LectureTime;
    private int Section;
    private int capacity;
    private int enrolled=0;
    private Semester Semester;
    public Lecture(Course Course,ClassRoom ClassRoom,Instructor Instructor,LectureTime LectureTime,int Section,Semester Semester){
        this.Course=Course;
        this.ClassRoom=ClassRoom;
        this.Instructor=Instructor;
        this.LectureTime=LectureTime;
        this.Section=Section;
        this.capacity=ClassRoom.getCapacity();
        this.Semester=Semester;
    }
    public Course getCourse(){
        return this.Course;
    }
    public Instructor getInstructor(){
        return this.Instructor;
    }

    public ClassRoom getClassRoom(){
        return this.ClassRoom;
    }
    public LectureTime getLectureTime(){
        return this.LectureTime;
    }

    public int getSection(){
        return this.Section;
    }

    public void addStudent(){
        enrolled++;
    }

    public boolean isFull(){
        return (enrolled<= capacity);
    }

    @Override
    public int compareTo(Lecture lecture){
        if(this.Course.getCourseCode().equals(lecture.Course.getCourseCode())&& this.LectureTime.equals(lecture.LectureTime) && this.Instructor.getInstructorId().equals(lecture.Instructor.getInstructorId())&& this.ClassRoom.getClassroomId().equals(lecture.ClassRoom.getClassroomId()))
            return 0;
        else
            return -1;
    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        Lecture lecture = (Lecture) o;
        return (this.Course.getCourseCode().equals(lecture.Course.getCourseCode())&& this.LectureTime.equals(lecture.LectureTime) && this.Instructor.getInstructorId().equals(lecture.Instructor.getInstructorId())&& this.ClassRoom.getClassroomId().equals(lecture.ClassRoom.getClassroomId())&&this.Semester.equals(lecture.Semester));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result= prime*result+(Course.getCourseCode() != null ? Course.getCourseCode().hashCode() : 0);
        result= prime*result+(LectureTime != null ? LectureTime.hashCode() : 0);
        result= prime*result+(Instructor.getInstructorId() != null ? Instructor.getInstructorId().hashCode() : 0);
        result= prime*result+(ClassRoom.getClassroomId() != null ? ClassRoom.getClassroomId().hashCode() : 0);
        result= prime*result+(Semester != null ? Semester.hashCode() : 0);




        return result;
    }


}
