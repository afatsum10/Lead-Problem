package com.LeadProblem.LeadProblem.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LeadProblem.LeadProblem.bean.LeadResponseBean;
import com.LeadProblem.LeadProblem.entity.Lead;
import com.LeadProblem.LeadProblem.service.LeadService;
import com.google.gson.Gson;

@RestController
@RequestMapping("/api")
public class LeadController {

	public static Gson gson = new Gson();
	
	@Autowired
	private LeadService leadService;

	@PostMapping("/createLeads")
	public ResponseEntity<?> createLead(@RequestBody String sLead) {
		
		Lead lead = gson.fromJson(sLead, Lead.class);
		
		LeadResponseBean leadResponseBean = new LeadResponseBean();
		
		Map<String, Object> response = new LinkedHashMap<>();
		
		try {

			if (!leadService.createLead(lead, leadResponseBean)) {

				System.out.println("Response State =" + leadResponseBean.getStatus());
			}
	

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		finally {

			System.out.println("Finally Response State =" + leadResponseBean.getStatus());
			
			if("success".equalsIgnoreCase(leadResponseBean.getStatus())) {
				 
				response.put("status", leadResponseBean.getStatus());
				response.put("data", leadResponseBean.getData());
				
			}
			if("error".equalsIgnoreCase(leadResponseBean.getStatus())) {
				 
				response.put("status", leadResponseBean.getStatus());
				response.put("errorResponse", leadResponseBean.getErrorResponse());
				
			}

		}
		
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@GetMapping("getLeads/{mobileNumber}")
	public ResponseEntity<?> getLeadByMobileNumber(@PathVariable String mobileNumber) {
		
		LeadResponseBean leadResponseBean = new LeadResponseBean();
		
		Map<String, Object> response = new LinkedHashMap<>();
		
		try {
			
			if (!leadService.getLeadsByMobileNumber(mobileNumber, leadResponseBean)) {

				System.out.println("Response State =" + leadResponseBean.getStatus());
			}
			

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		finally {

			System.out.println("Finally Response State =" + leadResponseBean.getStatus());
			
			if("success".equalsIgnoreCase(leadResponseBean.getStatus())) {
				 
				response.put("status", leadResponseBean.getStatus());
				response.put("data", leadResponseBean.getListOfLeads());
				
			}
			if("error".equalsIgnoreCase(leadResponseBean.getStatus())) {
				 
				response.put("status", leadResponseBean.getStatus());
				response.put("errorResponse", leadResponseBean.getErrorResponse());
				
			}

		}
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
