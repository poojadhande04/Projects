package com.jspiders.cardekho_case_study.Operation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import com.jspiders.cardekho_case_study.entity.Car;

public class CarOperation {
	List<Car> c=new ArrayList<Car>();
	
	Scanner s1=new Scanner(System.in);
	Scanner s2=new Scanner(System.in);
	public void addData() {
		System.out.println("How many cars you want to add");
		   int num=s1.nextInt();
		System.out.println("Enter car id:");
	       int car_id=s1.nextInt();
	    System.out.println("Enter car name");
	        String name=s2.nextLine();
	    System.out.println("Enter car fuel_type");
	        String fuel_type=s2.nextLine();
	    System.out.println("Enter car price");
	        int price=s1.nextInt();
	    System.out.println("Enter car model");
	        String model=s2.nextLine();
	    System.out.println("Enter car brand");
	        String brand=s2.nextLine();
	     c.add(new Car(car_id, name, fuel_type, brand, model, price));
	    
	}
	public void display() {
		System.out.println("===========================================");
		Iterator<Car> i=c.iterator();
		while(i.hasNext()) {
			Car c2= i.next();
			System.out.println(c2);
		}
		System.out.println("===========================================");
		 System.out.println("Data added Successfully!!!!");
		
	}
	public void updateData() {
		 boolean found=false;
			System.out.println("Enter Car id to Update: ");
			int car_id=s1.nextInt();
			System.out.println("===========================================");
			Iterator<Car> li= c.iterator();
			while(li.hasNext()) {
				Car c2= (Car) li.next();
				if(c2.getCar_id()==car_id) {
                       System.out.println("Enter new name:");
                          car_id=s1.nextInt();
                      System.out.println("Enter car name");
              	        String name=s2.nextLine();
              	      System.out.println("Enter car fuel_type");
              	        String fuel_type=s2.nextLine();
              	      System.out.println("Enter car price");
              	        int price=s1.nextInt();
              	      System.out.println("Enter car model");
              	        String model=s2.nextLine();
                     System.out.println("Enter new brand");
                       String brand=s2.nextLine();
//                       ((Object) li).set(new Car(car_id, name, fuel_type, brand, model, price));
					found=true;
				}
				System.out.println("===========================================");
			}
			
			if(!found) {
				System.out.println("Record not found");
			}
			else {
				System.out.println("Record is deleted successfully");
			}
			System.out.println("===========================================");
		
	    }

	public void searchingData() {
    	boolean found=false;
		System.out.println("Enter Car id to search: ");
		int car_id=s1.nextInt();
		System.out.println("===========================================");
		Iterator i=c.iterator();
		while(i.hasNext()) {
			Car c2= (Car) i.next();
			if(c2.getCar_id()==car_id) {
				System.out.println(c2);
				found=true;
			}
			System.out.println("===========================================");
		}
		
		if(!found) {
			System.out.println("Record not found");
		}
		System.out.println("===========================================");
   		
	}
   public void deleteData() {
	  boolean found=false;
		System.out.println("Enter Car id to Delete: ");
		int car_id=s1.nextInt();
		System.out.println("===========================================");
		Iterator i=c.iterator();
		while(i.hasNext()) {
			Car c2= (Car) i.next();
			if(c2.getCar_id()==car_id) {
				i.remove();
				found=true;
			}
			System.out.println("===========================================");
		}
		
		if(!found) {
			System.out.println("Record not found");
		}
		else {
			System.out.println("Record is deleted successfully");
		}
		System.out.println("===========================================");
	
    }

}
