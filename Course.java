/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course.mangment.system;


import java.io.Serializable;
import java.util.ArrayList;



/**
 *
 * @author PC
 */
public class Course implements Serializable{
    public String name;
    public String id;
    public String instractorName;
    public int roomNumber;
    public float price;
    public int startDay;
    public int endDay;
    public int days;
    public int numberOfBranchs;
    public Department department;

    public Course() {
        this.name = "";
        this.id = "";
        this.instractorName = "";
        this.roomNumber = 0;
        this.price = 0;
        this.startDay = 0;
        this.endDay = 0;
        this.days = 0;
        this.numberOfBranchs = 0;
        this.department = new Department();
    }
    
    
   
   public ArrayList<Student> get_students_regesterd()
   {
       ArrayList<Student_course> student_course =(ArrayList<Student_course>) FileManager.read("Student_course.bin");
       ArrayList<Student> students=new ArrayList<>();
       for(int i=0;i<student_course.size();i++)
       {
           if(student_course.get(i).course_id.equals(this.id))
           {
               Student temp =new Student();
               temp.load(student_course.get(i).student_id);
               temp.course_level=student_course.get(i).course_level;
               students.add(temp);
           }
       }
       return students;
   }
   
   public boolean load(String id)
   {
      ArrayList<Course> courses =(ArrayList<Course>) FileManager.read("Course.bin"); 
      for(int i=0;i<courses.size();i++)
      {
          if(courses.get(i).id.equals(id))
          {
              this.id=id;
              this.days=courses.get(i).days;
              this.endDay=courses.get(i).endDay;
              this.instractorName=courses.get(i).instractorName;
              this.name=courses.get(i).name;
              this.price=courses.get(i).price;
              this.roomNumber=courses.get(i).roomNumber;
              this.startDay=courses.get(i).startDay;
              this.department.load(courses.get(i).department.id);
              return true;
          }
      }
      return false;
   }
   
   
   
   public void save()
   {
       ArrayList<Course> courses =(ArrayList<Course>) FileManager.read("Course.bin"); 
      for(int i=0;i<courses.size();i++)
      {
          if(courses.get(i).id.equals(this.id))
          {
              courses.add(i, this);
          }
      }
      FileManager.write(courses, "Course.bin");
   }
   
   public void add()
   {
       ArrayList<Course> courses =(ArrayList<Course>) FileManager.read("Course.bin");
       courses.add(this);
       FileManager.write(courses, "Course.bin");
   }
   
   public static ArrayList<Course> all()
   {
       return (ArrayList<Course>) FileManager.read("Course.bin"); 
   }
   
   public void add_student(Student student,int level)
   {
        ArrayList<Student_course> student_course =(ArrayList<Student_course>) FileManager.read("Student_course.bin");
        Student_course temp=new Student_course();
        temp.course_id=this.id;
        temp.student_id=student.id;
        temp.course_level=level;
        student_course.add(temp);
        FileManager.write(student_course, "Student_course.bin");
   }
   
   public void remove_student(Student student)
   {
        ArrayList<Student_course> student_course =(ArrayList<Student_course>) FileManager.read("Student_course.bin");        
        for(int i=0;i<student_course.size();i++)
      {
          if(student_course.get(i).student_id.equals(student.id))
          {
              student_course.remove(i);
          }
      }
        FileManager.write(student_course, "Student_course.bin");
   }
   
   
}
        
        
    
        
    


