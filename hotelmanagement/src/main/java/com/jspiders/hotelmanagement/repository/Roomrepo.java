package com.jspiders.hotelmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jspiders.hotelmanagement.dto.Room;

public interface Roomrepo extends JpaRepository<Room , Integer>{

   @Query("select r from Room r where r.room_id=?l")
   public Room getRoombyid(int rid);
   
   @Query("select r from Room r where r.room_no=?l")
   public Room getRoombyno(int room_no);
   
   @Query("select r from Room r where r.room_type=?l")
   public List<Room> getRoombytype(String room_type);
  
   
   @Query("select r from Room r where r.room_availability=?l")
   public List<Room> getRoombyavailability(String availability);
	
	

}
