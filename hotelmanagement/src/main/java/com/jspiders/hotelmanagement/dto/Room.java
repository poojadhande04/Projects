package com.jspiders.hotelmanagement.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Room {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int room_id;
	private int room_no;
	private String room_type;
	private int room_price;
	private int max_people;
	private String availability;
	
	//enumtype are two types ordinal and String we are using String )
	@Enumerated(EnumType.STRING)
	private Floor floor;
	
	@ManyToOne
	private Hotel hotel;

}
