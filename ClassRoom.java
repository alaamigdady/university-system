import java.util.ArrayList;

public class ClassRoom {
    private final String classroomId;
    private final int capacity;
    private ArrayList<Lecture> Lectures;


    public ClassRoom (String classroomId,int capacity){
        if(classroomId == null || !classroomId.matches("[0-9]{3}"))
            throw new IllegalArgumentException("Enter classroomId name");
        this.classroomId=classroomId;
        this.capacity=capacity;
        Lectures=new ArrayList<>();
    }

    public String getClassroomId(){
        return classroomId;
    }

    public int getCapacity(){
        return capacity;
    }

    public void addLecture(Lecture lecture){
        Lectures.add(lecture);
    }
    public ArrayList<Lecture> getAllLectures(){
        return Lectures;
    }


}
