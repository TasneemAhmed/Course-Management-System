/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course.mangment.system;

import java.io.Serializable;
import java.util.ArrayList;

public class Department implements Serializable{
    
    public String id;
    public String name;


    public Department() 
     {
        this.name = "";
        this.id = "";
     }

    public boolean load(String id)
     {
        ArrayList<Department> departments =(ArrayList<Department>) FileManager.read("Department.bin"); 
        for(int i=0;i<departments.size();i++)
        {
            if(departments.get(i).id.equals(id))
            {
                this.id=id;
                this.name=departments.get(i).name;
                return true;
            }
        }
        return false;
     }
    
     public void add()
     {
         ArrayList<Department> department =(ArrayList<Department>) FileManager.read("Department.bin");
         department.add(this);
         FileManager.write(department ,"Department.bin");
     }

     public static ArrayList<Department> all()
     {
         return (ArrayList<Department>) FileManager.read("Department.bin"); 
     }
}
