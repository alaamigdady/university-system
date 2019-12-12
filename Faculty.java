import java.util.ArrayList;
import java.util.HashMap;

public class Faculty {
    private final String facultyName;
    private HashMap<String,Department> Departments;
    private final String facultyId;
    private int departmentId =0;


    public Faculty(String facultyName, Integer facultyId){
        if(facultyName == null|| !facultyName.matches("[a-zA-z]*"))
            throw new IllegalArgumentException();
        this.facultyName=facultyName;
        this.facultyId= String.format("%02d",facultyId);
        Departments = new HashMap<>();
    }

    public String getFacultyName(){
        return this.facultyName;
    }

    public String getFacultyId(){
        return facultyId;
    }

    public void addDepartment(String departmentName) {
        if (departmentName == null || !departmentName.matches("[a-zA-z]*"))
            throw new IllegalArgumentException("Enter department name");
        if (Departments.containsKey(departmentName))
            throw new IllegalArgumentException("This department already exist");
        String d = String.format("%02d",(departmentId));
        Department D = new Department(departmentName,this,facultyId+d);
        Departments.put(departmentName,D);
        departmentId++;
    }

    public Department getDepartment(String departmentName){
        if(departmentName == null)
            throw new IllegalArgumentException("Enter department name");
        if(!Departments.containsKey(departmentName))
            throw new IllegalArgumentException("This department does not exist");
        return Departments.get(departmentName);
    }

    public HashMap<String, Department> getAllDepartments(){

        return Departments;
    }




}
