package com.jspiders.cardekho_case_study_springmvc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspiders.cardekho_case_study_springmvc.pojo.CarPOJO;


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
		if(transaction !=null) {
			if(transaction.isActive()) {
				transaction.rollback();
			}
		}
	}

	
	public CarPOJO addcardetails(String name, String model, String brand,String fuel_type, double price) {
		 openConnection();
		 transaction.begin();
		 CarPOJO pojo=new CarPOJO();
		 pojo.setName(name);
		 pojo.setModel(model);
		 pojo.setBrand(brand);
		 pojo.setFuel_type(fuel_type);
		 pojo.setPrice(price);
		 manager.persist(pojo);
		 transaction.commit();
		 closeConnection();
		return pojo;
	}
	public CarPOJO searchCarDetails(int id) {
		openConnection();
		transaction.begin();
		CarPOJO pojo=manager.find(CarPOJO.class, id);
		transaction.commit();
		closeConnection();
		return pojo;
	}
	public List<CarPOJO> findAllCars() {
		openConnection();
		transaction.begin();
		String jpql="from CarPOJO";
		query=manager.createQuery(jpql); 
		
		@SuppressWarnings("unchecked")
		List<CarPOJO> cars=query.getResultList();
		transaction.commit();
		return cars;
	}
	
	public CarPOJO updateCar(int car_id, String name, String model, String brand, String fuel_type, double price) {
		openConnection();
		transaction.begin();
		CarPOJO pojo=manager.find(CarPOJO.class, car_id);
		pojo.setName(name);
		pojo.setModel(model);
		pojo.setBrand(brand);
		pojo.setFuel_type(fuel_type);
		pojo.setPrice(price);
		manager.persist(pojo);
		transaction.commit();
		closeConnection();
		return pojo;
	}
	public CarPOJO removeCar(int car_id) {
		openConnection();
		transaction.begin();
		CarPOJO pojo=manager.find(CarPOJO.class, car_id);
		if(pojo !=null) {
			manager.remove(pojo);
		}
		transaction.commit();
		closeConnection();
		return pojo;
	}
	public List<CarPOJO> searchByName(String searchVal) {
		openConnection();
		transaction.begin();
		String jpql="from CarPOJO where name='"+searchVal+"'";
		query=manager.createQuery(jpql);
		List<CarPOJO> cars=query.getResultList();
		
		transaction.commit();
		closeConnection();
		return cars;
	}
	public List<CarPOJO> searchByBrand(String searchVal) {
		openConnection();
		transaction.begin();
		String jpql="from CarPOJO where brand='"+searchVal+"'";
		query=manager.createQuery(jpql);
		List<CarPOJO> cars=query.getResultList();
		transaction.commit();
		closeConnection();
		return cars;
	}
	public List<CarPOJO> searchByModel(String searchVal) {
		openConnection();
		transaction.begin();
		String jpql="from CarPOJO where model='"+searchVal+"'";
		query=manager.createQuery(jpql);
		List<CarPOJO> cars=query.getResultList();
		transaction.commit();
		closeConnection();
		return cars;
	}
	public List<CarPOJO> searchByFuelType(String searchVal) {
		openConnection();
		transaction.begin();
		String jpql="from CarPOJO where fuel_type='"+searchVal+"'";
		query=manager.createQuery(jpql);
		List<CarPOJO> cars=query.getResultList();
		transaction.commit();
		closeConnection();
		return cars;
	}

}
