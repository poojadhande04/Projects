package com.jspiders.cardekho_case_study.main;

import java.util.Scanner;

import com.jspiders.cardekho_case_study.Operation.CarOperation;
import com.jspiders.cardekho_case_study.entity.Car;
	
public class CarDekhoMenu {
	      public static void main(String args[]) {
	    	  Scanner s=new Scanner(System.in);
			CarOperation c1=new CarOperation();
			int ch;
			
			do {
				System.out.println("******************Menu*********************");
				System.out.println("1.Add Car Details");
			    System.out.println("2.Search Car Details");
				System.out.println("3.Delete Car Details");
				System.out.println("4.Update Car Details");
				System.out.println("5.Exit");
				System.out.println("Enter the choice:");
				ch=s.nextInt();
				
				switch(ch) {
				case 1:
				 c1.addData(); 
				 c1.display();
					break; 
				case 2:
					c1.searchingData();
					break;
				case 3:
					c1.deleteData();
					break;
				case 4:
					c1.updateData();
				case 5:
					System.out.println("Thank you !!!!!!!!!!!!");
					break;
				default:
					break;
				}
				
					
				
			} while (ch!=5);
		}

	}



