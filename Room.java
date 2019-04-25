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
public class Room implements Serializable{
    
    public int numberroom;
    public int chairnumber;
    public String place;
    public boolean projector;
    public boolean aircond; 

    public Room() {
        this.numberroom = 0;
        this.chairnumber = 0;
        this.place = "";
        this.projector = false;
        this.aircond = false;
    }
    
    
    public boolean area_valid(Course course)
    {
        return course.get_students_regesterd().size()==this.chairnumber; 
    }
    public void add()
    {
        ArrayList<Room> room =(ArrayList<Room>) FileManager.read("Room.bin");
        room.add(this);
        FileManager.write(room, "Room.bin");
    }
   
   public static ArrayList<Room> all()
   {
       return (ArrayList<Room>) FileManager.read("Room.bin"); 
   }
   
   public boolean load(int numberroom)
   {
      ArrayList<Room> rooms =(ArrayList<Room>) FileManager.read("Room.bin"); 
      for(int i=0;i<rooms.size();i++)
      {
          if(rooms.get(i).numberroom==numberroom)
          {
              this.numberroom=numberroom;
              this.chairnumber=rooms.get(i).chairnumber;
              this.place=rooms.get(i).place;
              this.projector=rooms.get(i).projector;
              this.aircond=rooms.get(i).aircond;
              return true;
          }
      }
      return false;
   }
   
   public void save()
   {
       ArrayList<Room> rooms =(ArrayList<Room>) FileManager.read("Room.bin"); 
      for(int i=0;i<rooms.size();i++)
      {
          if(rooms.get(i).numberroom==this.numberroom)
          {
              rooms.add(i, this);
          }
      }
      FileManager.write(rooms, "rooms.bin");
   }
   
}



    
    
    
    
    
    
    







