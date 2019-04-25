
package course.mangment.system;


import java.io.Serializable;
import java.util.ArrayList;



/**
 *
 * @author Nada Mostafa Taha
 */
public class Student extends person implements Serializable{
 
   String Branch;
   public int age;
   public int Course_level;
   public String faculty;
   public String university;
   public int level;
   public int course_level;
   
   
   
   public void regester_to_course(Course course,int level)
   {
       course.add_student(this, level);
   }
   public void save()
   {
       ArrayList<Student> students =(ArrayList<Student>) FileManager.read("Student.bin"); 
      for(int i=0;i<students.size();i++)
      {
          if(students.get(i).id.equals(this.id))
          {
              students.add(i, this);
          }
      }
      FileManager.write(students, "Student.bin");
   }
   
   public void add()
   {
       ArrayList<Student> students =(ArrayList<Student>) FileManager.read("Student.bin");
       students.add(this);
       FileManager.write(students, "Student.bin");
   }
   
   public static ArrayList<Student> all()
   {
       return (ArrayList<Student>) FileManager.read("Student.bin"); 
   }
   
   public ArrayList<Course> get_regesterd_courses()
   {
       ArrayList<Student_course> student_course =(ArrayList<Student_course>) FileManager.read("Student_course.bin");
       ArrayList<Course> courses=new ArrayList<>();
       for(int i=0;i<student_course.size();i++)
       {
           if(student_course.get(i).student_id.equals(this.id))
           {
               Course temp = new Course();
               temp.load(student_course.get(i).course_id);
               
               courses.add(temp);
           }
           
       }
       return courses;
   }

   public boolean load(String id)
   {
      ArrayList<Student> students =(ArrayList<Student>) FileManager.read("Student.bin"); 
      for(int i=0;i<students.size();i++)
      {
          if(students.get(i).id.equals(id))
          {
              this.id=id;
              this.Branch=students.get(i).Branch;
              this.Course_level=students.get(i).Course_level;
              this.age=students.get(i).age;
              this.faculty=students.get(i).faculty;
              this.university=students.get(i).university;
              this.level=students.get(i).level;
              this.address=students.get(i).address;
              this.email=students.get(i).email;
              this.id=students.get(i).id;
              this.name=students.get(i).name;
              this.password=students.get(i).password;
              this.phone=students.get(i).phone;
              this.username=students.get(i).username;
              return true;
          }
      }
      return false;
   }
   public static Student login(String username,String password)
   {
       ArrayList<Student> students= Student.all();
       for(int i=0;i<students.size();i++)
       {
           if( username.equals(students.get(i).username) && password.equals(students.get(i).password))
           {
               return students.get(i);
           }
       }
       return null;
   }
   

}