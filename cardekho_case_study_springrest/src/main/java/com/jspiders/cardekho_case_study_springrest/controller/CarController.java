package com.jspiders.cardekho_case_study_springrest.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.cardekho_case_study_springrest.pojo.CarPOJO;
import com.jspiders.cardekho_case_study_springrest.response.CarResponse;
import com.jspiders.cardekho_case_study_springrest.service.CarService;



@RestController
public class CarController {
	@Autowired
	private CarService service;
	
	@PostMapping(path="/add",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CarResponse> addCar(@RequestBody CarPOJO pojo) {
		CarPOJO car=service.addCar(pojo);
		//Success
		if(car !=null) {
			return new ResponseEntity<CarResponse>(new CarResponse("Data added succressfully",car,null),HttpStatus.ACCEPTED);
		}
		//failure
		return new ResponseEntity<CarResponse>(new CarResponse("Data added succressfully",null,null),HttpStatus.NOT_ACCEPTABLE);
	}
   
	@GetMapping(path="/search/{car_id}",
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CarResponse> searchCar(@PathVariable int car_id){
		CarPOJO car=service.searchCar(car_id);
		//Success
		if(car!=null) {
			return new ResponseEntity<CarResponse>(new CarResponse("Data found successfully...!",car,null),HttpStatus.FOUND);
		}
		return new ResponseEntity<CarResponse>(new CarResponse("Data not found...!!",null,null),HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(path="/searchAll",
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CarResponse> searchAllCars(){
		List<CarPOJO> cars=service.searchAllCars();
		//Success
		if(cars.isEmpty()==false) {
			return new ResponseEntity<CarResponse>(new CarResponse("Data found successfully",null,cars),HttpStatus.FOUND);
		}
		return new ResponseEntity<CarResponse>(new CarResponse("Data not found...!!!",null,null),HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping(path="/remove/{car_id}",
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CarResponse> removeCar(@PathVariable int car_id){
		CarPOJO car=service.removeCar(car_id);
		//Success
		if(car!=null) {
			return new ResponseEntity<CarResponse>(new CarResponse("Data Removed Successfully",car,null),HttpStatus.OK);
 		}
		return new ResponseEntity<CarResponse>(new CarResponse("Data not removed",null,null),HttpStatus.BAD_REQUEST);
		
	}
	@PutMapping(path="/update")
	public ResponseEntity<CarResponse> updateCar(@RequestBody CarPOJO pojo){
		 CarPOJO car=service.updateCar(pojo);
		 //Success
		if(car !=null) {
			return new ResponseEntity<CarResponse>(new CarResponse("Data updated Successfully...!!!",car,null),HttpStatus.ACCEPTED) ;
		}
		//Failure
		return new ResponseEntity<CarResponse>(new CarResponse("Data not updated..!!!",null,null),HttpStatus.NOT_ACCEPTABLE);
	}
	
}
