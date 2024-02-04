package com.jspiders.cardekho_case_study_springmvc.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class CarPOJO {
	   @Id
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private int car_id;
		private String name;
		private String model;
		private String brand;
		private String fuel_type;
		private double price;
		
}
