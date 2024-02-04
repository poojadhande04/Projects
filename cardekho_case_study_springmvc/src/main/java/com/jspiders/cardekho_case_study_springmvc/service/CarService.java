package com.jspiders.cardekho_case_study_springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.cardekho_case_study_springmvc.pojo.CarPOJO;
import com.jspiders.cardekho_case_study_springmvc.repository.CarRepository;

@Service
public class CarService {
	@Autowired
	private CarRepository repository;

	public CarPOJO addcardetails( String name, String model, String brand,String fuel_type, double price) {
	    CarPOJO pojo=repository.addcardetails(name,model,brand,fuel_type,price);
		return pojo;
	}

	public CarPOJO searchCarDetails(int id) {
		CarPOJO pojo=repository.searchCarDetails(id);
		return pojo;
	}

	public List<CarPOJO> findAllCars() {
	     List<CarPOJO> cars=repository.findAllCars();
		return cars;
	}

	public CarPOJO updateCar(int car_id,String name, String model, String brand, String fuel_type, double price) {
		 CarPOJO pojo=repository.updateCar(car_id,name,model,brand,fuel_type,price);
		return pojo;
	}

	public CarPOJO removeCar(int car_id) {
		CarPOJO pojo=repository.removeCar(car_id);
		return pojo;
	}

	public List<CarPOJO> searchByName(String searchVal) {
		List<CarPOJO> cars=repository.searchByName(searchVal);
		return cars;
	}

	public List<CarPOJO> searchByBrand(String searchVal) {
	    List<CarPOJO> cars=repository.searchByBrand(searchVal);
		return cars;
	}

	public List<CarPOJO> searchByModel(String searchVal) {
		List<CarPOJO> cars=repository.searchByModel(searchVal);
		return cars;
	}

	public List<CarPOJO> searchByFuelType(String searchVal) {
		List<CarPOJO> cars=repository.searchByFuelType(searchVal);
		return cars;
	}

	
	

}
