package com.jspiders.cardekho_case_study_springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.cardekho_case_study_springrest.pojo.CarPOJO;
import com.jspiders.cardekho_case_study_springrest.repository.CarRepository;

@Service
public class CarService {
	@Autowired
	private CarRepository repository;

	

	public CarPOJO addCar(CarPOJO pojo) {
		 CarPOJO car=repository.addCar(pojo);
		return car;
	}



	public CarPOJO searchCar(int car_id) {
		CarPOJO car=repository.addCar(car_id);
		return car;
	}



	public List<CarPOJO> searchAllCars() {
		  List<CarPOJO> cars=repository.searchAllCars();
		return cars;
	}

   public CarPOJO removeCar(int car_id) {
		CarPOJO car=repository.removeCar(car_id);
		return car;
	}



public CarPOJO updateCar(CarPOJO pojo) {
	  CarPOJO car=repository.updateCar(pojo);
	return car;
}

}
