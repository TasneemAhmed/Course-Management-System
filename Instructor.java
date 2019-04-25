/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course.mangment.system;

import java.io.Serializable;
import java.util.ArrayList;

public class Instructor extends Staff implements  Iteach,Serializable{
    
    public Instructor()
    {
        
    }
     
    public boolean load(String id)
   {
      ArrayList<Instructor> Instructors =(ArrayList<Instructor>) FileManager.read("Instructor.bin"); 
      for(int i=0;i<Instructors.size();i++)
      {
            for (int j=0;j<Instructors.get(i).courses.size();j++)
            {
                Course course=Instructors.get(i).courses.get(i);
                course.load(course.id);
                this.courses.add(course);
            }
            this.department.load(Instructors.get(i).department.id);
            this.name = Instructors.get(i).name;
            this.email = Instructors.get(i).email;
            this.id = Instructors.get(i).id;
            this.position = Instructors.get(i).position;
            return true;
      }
      return false;
   }
    
    public void addCourse(Course course){
    
        ArrayList<Instructor> instructors =(ArrayList<Instructor>) FileManager.read("Instructor.bin");
        for(int i=0;i<instructors.size();i++)
         {
            if(instructors.get(i).id.equals(this.id))
            {
                instructors.get(i).courses.add(course);
            }
         }
         FileManager.write(instructors, "Instructor.bin");
    }
    
    public void save()
    {
       ArrayList<Instructor> Instructors =(ArrayList<Instructor>) FileManager.read("Instructor.bin");   
       for(int i=0;i<Instructors.size();i++)
       {
           if(Instructors.get(i).id.equals(this.id))
           {
               Instructors.add(i, this);
           }
       }
       FileManager.write(Instructors, "Instructor.bin");
    }
   public void add()
   {
       ArrayList<Instructor> Instructors =(ArrayList<Instructor>) FileManager.read("Instructor.bin");
       Instructors.add(this);
       FileManager.write(Instructors, "Instructor.bin");
   }
   
   public static ArrayList<Instructor> all()
   {
       return (ArrayList<Instructor>) FileManager.read("Instructor.bin"); 
   }

    @Override
    public String teach(String subject) {
       return super.subject;
    }

    @Override
    public double calculate_salary() {
        int course_no=this.courses.size();
        float sum=0;
        
          for (int i=0;i<this.courses.size();i++)
          {
              sum += this.courses.get(i).price;
          
          }
        double  InstructorSalary=(double)(40/100)*course_no*sum;
        return InstructorSalary;
    }
    public static Instructor login(String username,String password)
   {
       ArrayList<Instructor> Instructors= Instructor.all();
       for(int i=0;i<Instructors.size();i++)
       {
           if( username.equals(Instructors.get(i).username) && password.equals(Instructors.get(i).password))
           {
               return Instructors.get(i);
           }
       }
       return null;
   }
   
}
