package com.jspiders.cardekho_case_study_springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.jspiders.cardekho_case_study_springmvc.pojo.AdminPOJO;
import com.jspiders.cardekho_case_study_springmvc.pojo.CarPOJO;
import com.jspiders.cardekho_case_study_springmvc.service.CarService;

@Controller
public class CarController {
	@Autowired
	private CarService service;
     
	@GetMapping("/home")
	public String carhome(@SessionAttribute(name="login",required=false)AdminPOJO admin,ModelMap map) {
		
		if(admin !=null) {
			return "Home";
		}
		map.addAttribute("msg", "Session inactive.Login to proceed..!");
		return "Login";
		
	}
	//frontend page
	@GetMapping("/add")
	public String addcar(@SessionAttribute(name="login",required=false)AdminPOJO admin,ModelMap map) {
		if(admin!=null) {
			List<CarPOJO> cars=service.findAllCars();
			if(!cars.isEmpty()) {
				map.addAttribute("cars",cars);
				return "AddCar";
				
			}
			map.addAttribute("msg", "No data is present");
			return "AddCar";
		}
		map.addAttribute("msg", "Session inactive.Login to proceed..!");
		return "Login";
		
	}
	//inserting data
	@PostMapping("/add")
	public String addcardetails(@SessionAttribute(name="login",required=false)AdminPOJO admin,@RequestParam String name,
			                    @RequestParam String model,
			                    @RequestParam String brand,
			                    @RequestParam String fuel_type,
			                    @RequestParam double price,
			                    ModelMap map) {
		if(admin !=null) {
			CarPOJO pojo=service.addcardetails(name,model,brand,fuel_type,price);
		    //Sucesss
			if(pojo !=null) {
				map.addAttribute("msg", "Data Inserted Successfully...!!!");
				List<CarPOJO> cars=service.findAllCars();
					map.addAttribute("cars",cars);
				
				return "AddCar";
			}
		    //failure
			List<CarPOJO> cars=service.findAllCars();
			map.addAttribute("cars",cars);
		
			map.addAttribute("msg","Data not inserted..!!!");
			return "AddCar";
			}
		map.addAttribute("msg", "Session inactive.Login to proceed..!");
		return "Login";
	}
	
	@GetMapping("/search")
	public String searchCar(@SessionAttribute(name="login",required=false)AdminPOJO admin,ModelMap map) {
		if(admin !=null) {
			return "SearchCar";
		}
		map.addAttribute("msg", "Session inactive.Login to proceed..!");
		return "Login";
	} 
	
	@PostMapping("/search")
	public String searchCarDetails(@SessionAttribute(name="login",required=false)AdminPOJO admin,@RequestParam String searchParam, @RequestParam("searchVal") String searchVal,ModelMap map) {
		if(admin !=null) {
			//SearchById
			if("id".equals(searchParam)) {
			int id=Integer.parseInt(searchVal);
			CarPOJO pojo=service.searchCarDetails(id);
			//Success
		    if(pojo!=null) { 
		    	map.addAttribute("car", pojo);
		    	map.addAttribute("msg", "Car data found Successfully...!!!");
		    	return "SearchCar";
		    }
		  //failure
		    map.addAttribute("msg","Car data not found..!!!");
		    return "SearchCar";
		
			} 
			 //Search By NAME
			else if("name".equals(searchParam)) {
				List<CarPOJO> cars=service.searchByName(searchVal);
				  //success
				  if(cars.isEmpty()==false) {
					  map.addAttribute("msg", "car Details found Successfully..");
					  map.addAttribute("cars", cars);
					  return "SearchCar";
				  }
				  //Failure
				  map.addAttribute("msg", "Car details not found..!!");
				  return "SearchCar";
			}
			//Search By Brand
			else if("brand".equals(searchParam)) {
				List<CarPOJO> cars=service.searchByBrand(searchVal);
				//Success
				if(cars.isEmpty()==false){
					map.addAttribute("msg", "Car details found successfully");
					map.addAttribute("cars", cars);
					return "SearchCar";
				}
				//Failure
				map.addAttribute("msg","Car details not found");
				return "SearchCar";
			}
			
			//Search By Model
			else if("model".equals(searchParam)) {
				List<CarPOJO> cars=service.searchByModel(searchVal);
				//Success
				if(cars.isEmpty()==false) {
					map.addAttribute("msg", "Data found successfully");
					map.addAttribute("cars", cars);
					return "SearchCar";
				}
				//Failure
				map.addAttribute("msg", "Data not found..");
				return "SearchCar";
			}
		  //Search By Fuel_type
			else if("fuel_type".equals(searchParam)) {
				List<CarPOJO> cars=service.searchByFuelType(searchVal);
				//Success
				if(cars.isEmpty()==false) {
					map.addAttribute("msg", "Data found successfully");
					map.addAttribute("cars", cars);
					return "SearchCar";
				}
				//Failure
				map.addAttribute("msg", "Data not found..");
				return "SearchCar";
			}
		}
		
		map.addAttribute("msg", "Session inactive.Login to proceed..!");
		return "Login";
		
	   }
	 @GetMapping("/update")
	  public String updatePage(@SessionAttribute(name="login",required=false)AdminPOJO admin,ModelMap map) {
		 if(admin !=null) {
			 List<CarPOJO> cars=service.findAllCars();
			 map.addAttribute("cars",cars);
			 return "UpdateCar";
		 }
		 map.addAttribute("msg", "Session inactive.Login to proceed..!");
			return "Login";
	 }
	 @PostMapping("/update")
	 public String updateForm(@SessionAttribute(name="login",required=false)AdminPOJO admin,@RequestParam int car_id,ModelMap map) {
		if(admin !=null) {
			CarPOJO pojo= service.searchCarDetails(car_id);
			//Success
		    if(pojo!=null) {
		    	map.addAttribute("car", pojo);
		    	return "UpdateCar";
		    }
		  //failure
		    map.addAttribute("msg","Car data not found..!!!");
		    return "UpdateCar";
			
		}
		map.addAttribute("msg", "Session inactive.Login to proceed..!");
		return "Login";
 }
	   
	 @PostMapping("/updateCar")
	 public String updateCar(@SessionAttribute(name="login",required=false)AdminPOJO admin,@RequestParam int car_id,
			                 @RequestParam String name,
			                 @RequestParam String model,
			                 @RequestParam String brand,
			                 @RequestParam String fuel_type,
			                 @RequestParam double price,ModelMap map) {
		 
		if(admin !=null) {
			CarPOJO pojo= service.updateCar(car_id,name,model,brand,fuel_type,price);
			//Success
			  if(pojo !=null) {
				  map.addAttribute("msg","Data updated Successfully..!!");
				  List<CarPOJO> cars=service.findAllCars();
					map.addAttribute("cars",cars);
					return "UpdateCar";
			  }
			  //Failure
			  map.addAttribute("msg","Data not updated..!!");
			  List<CarPOJO> cars=service.findAllCars();
				map.addAttribute("cars",cars);
			     return "UpdateCar";
			 
		}
		map.addAttribute("msg", "Session inactive.Login to proceed..!");
		return "Login";
 }
	 
	 
	 @GetMapping("/remove")
	 public String remove(@SessionAttribute(name="login",required=false)AdminPOJO admin,ModelMap map) {
		 if(admin !=null) {
			 List<CarPOJO> cars=service.findAllCars();
			 if(!cars.isEmpty()) {
				map.addAttribute("cars", cars);
				return "RemoveCar";
			 }
			 return "RemoveCar";
		 }
		 map.addAttribute("msg", "Session inactive.Login to proceed..!");
			return "Login";
	 }
	 
	 @PostMapping("/remove")
	 public String removeCar(@SessionAttribute(name="login",required=false)AdminPOJO admin,@RequestParam int car_id,ModelMap map) {
		  if(admin !=null) {
			  CarPOJO pojo=service.removeCar(car_id);
			   List<CarPOJO> cars=service.findAllCars();
			   //Success
			   if(pojo !=null) {
				  
				   map.addAttribute("msg","Data removed Successfully...!!!");
				   map.addAttribute("cars",cars);
				   return "RemoveCar";
				   
			   }
			   //Failure
			   map.addAttribute("msg", "Data not removed..!!");
			 return "RemoveCar";
		  }
		  map.addAttribute("msg", "Session inactive.Login to proceed..!");
			return "Login";
	 }
	 
}
