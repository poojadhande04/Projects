package com.jspiders.cardekho_case_study_springrest.response;

import com.jspiders.cardekho_case_study_springrest.pojo.AdminPOJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminResponse {
	private String msg;
	  private AdminPOJO admin;

}
