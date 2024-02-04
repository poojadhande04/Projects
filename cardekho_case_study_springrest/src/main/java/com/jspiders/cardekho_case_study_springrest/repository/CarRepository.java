package com.jspiders.cardekho_case_study_springrest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspiders.cardekho_case_study_springrest.pojo.CarPOJO;

@Repository
public class CarRepository {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static Query query;
	
	private static void openConnection() {
		factory=Persistence.createEntityManagerFactory("common");
		manager=factory.createEntityManager();
		transaction=manager.getTransaction();
	}
	private static void closeConnection() {
		if(factory !=null) {
			factory.close();
		}
		if(manager !=null) {
			manager.close();
		}
		if(transaction!=null) {
			if(transaction.isActive()) {
				transaction.rollback();
			}
		}
	}
	public CarPOJO addCar(CarPOJO pojo) {
	     openConnection();
	     transaction.begin();
	     manager.persist(pojo);
	     transaction.commit();
	     closeConnection();
		return pojo;
	}
	public CarPOJO addCar(int car_id) {
	     openConnection();
	     transaction.begin();
	     CarPOJO car=manager.find(CarPOJO.class, car_id);
	     transaction.commit();
	     closeConnection();
		return car;
	}
	public List<CarPOJO> searchAllCars() {
		
		openConnection();
		transaction.begin();
		String jpql="from CarPOJO";
		query=manager.createQuery(jpql);
		List <CarPOJO> cars=query.getResultList();
		transaction.commit();
		closeConnection();
		return cars;
	}
	public CarPOJO removeCar(int car_id) {
		  openConnection();
		  transaction.begin();
		  CarPOJO car=manager.find(CarPOJO.class, car_id);
		  if(car!=null) {
			  manager.remove(car);
		  }
		  transaction.commit();
		  closeConnection();
		return car;
	}
	public CarPOJO updateCar(CarPOJO pojo) {
		openConnection();
		transaction.begin();
		CarPOJO car=manager.find(CarPOJO.class,pojo.getCar_id());
		car.setName(pojo.getName());
		 car.setModel(pojo.getModel());
		 car.setBrand(pojo.getBrand());
		 car.setFuel_type(pojo.getFuel_type());
		 car.setPrice(pojo.getPrice());
		transaction.commit();
		closeConnection();
		return car;
	}

}
