package com.jspiders.cardekho_case_study.entity;


public class Car {
	
	    private int car_id;
		private String name;
		private String model;
		private String brand;
		private String fuel_type;
		private double price;
		
		
		public Car(int car_id2, String name2, String fuel_type2, String brand2, String model2, int price2) {
			// TODO Auto-generated constructor stub
			this.car_id=car_id2;
			this.name=name2;
			this.model=model2;
			this.brand=brand2;
			this.fuel_type=fuel_type2;
			this.price=price2;
		}
        public String toString() {
			return car_id+" "+name+" "+model+" "+brand+" "+fuel_type+" "+price;
		}
		public int getCar_id() {
			return car_id;
		}
		public void setCar_id(int car_id) {
			this.car_id = car_id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getModel() {
			return model;
		}
		public void setModel(String model) {
			this.model = model;
		}
		public String getBrand() {
			return brand;
		}
		public void setBrand(String brand) {
			this.brand = brand;
		}
		public String getFuel_type() {
			return fuel_type;
		}
		public void setFuel_type(String fuel_type) {
			this.fuel_type = fuel_type;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		
		

	}



