package com.jspiders.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspiders.hotelmanagement.dto.Hotel;

public interface Hotelrepo extends JpaRepository<Hotel,Integer>{

}
