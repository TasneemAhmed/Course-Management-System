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
 * @author dell
 */
public class Assistant extends Staff implements Istudy,Serializable{
    
     
    public void takeAttend(Student student , Course course,int session_number)
    {
        Attendance.attend(course, student, session_number);
    }
   
    public boolean load(String id)
    {
       ArrayList<Assistant> Assistants =(ArrayList<Assistant>) FileManager.read("Assistant.bin"); 
       for(int i=0;i<Assistants.size();i++)
       {
           if(Assistants.get(i).id.equals(id))
           {
               for (int j=0;j<Assistants.get(i).courses.size();j++)
               {
                   Course course=Assistants.get(i).courses.get(i);
                   course.load(course.id);
                   this.courses.add(course);
               }
               this.department.load(Assistants.get(i).department.id) ;
               this.name = Assistants.get(i).name;
               this.email = Assistants.get(i).email;
               this.id = Assistants.get(i).id;
               this.position = Assistants.get(i).position;
               return true;
           }
       }
       return false;
    }
    
     public void addCourse(Course course){
    
        ArrayList<Assistant> Assistants =(ArrayList<Assistant>) FileManager.read("Assistant.bin");
        for(int i=0;i<Assistants.size();i++)
         {
            if(Assistants.get(i).id.equals(this.id))
            {
                Assistants.get(i).courses.add(course);
            }
         }
         FileManager.write(Assistants, "Assistant.bin");
    }
    public void save()
    {
       ArrayList<Assistant> Assistants =(ArrayList<Assistant>) FileManager.read("Assistant.bin");   
       for(int i=0;i<Assistants.size();i++)
       {
           if(Assistants.get(i).id.equals(this.id))
           {
               Assistants.add(i, this);
           }
       }
       FileManager.write(Assistants, "Assistant.bin");
    }
   public void add()
   {
       ArrayList<Assistant> Assistants =(ArrayList<Assistant>) FileManager.read("Assistant.bin");
       Assistants.add(this);
       FileManager.write(Assistants, "Assistant.bin");
   }
   
   public static ArrayList<Assistant> all()
   {
       return (ArrayList<Assistant>) FileManager.read("Assistant.bin"); 
   }

    @Override
    public String study(String subject) {
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
        double  AssistantSalary=(double)(10/100)*course_no*sum;
        return AssistantSalary;
    }
    
    public static Assistant login(String username,String password)
   {
       ArrayList<Assistant> Assistants= Assistant.all();
       for(int i=0;i<Assistants.size();i++)
       {
           if( username.equals(Assistants.get(i).username) && password.equals(Assistants.get(i).password))
           {
               return Assistants.get(i);
           }
       }
       return null;
   }
  
  
}
