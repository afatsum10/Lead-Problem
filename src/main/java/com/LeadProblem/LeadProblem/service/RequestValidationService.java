package com.LeadProblem.LeadProblem.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.LeadProblem.LeadProblem.bean.LeadResponseBean;
import com.LeadProblem.LeadProblem.entity.Lead;

@Service
public class RequestValidationService {

	private static final String DATE_FORMAT = "dd/MM/yyyy";
	
	public boolean LeadRequestValidation(Lead lead, LeadResponseBean leadResponseBean) {
		
		boolean bProcessedSuccessfully = false;
		
		//Loggers to be added
		try {
			
			if(lead.getLeadId() == null || "".equals(lead.getLeadId())) {
				
				leadResponseBean.setStatus("error");
				leadResponseBean.getErrorResponse().setCode("EVER01");
				leadResponseBean.getErrorResponse().getMessages().add("Lead ID cannot be null or empty.");
				
				bProcessedSuccessfully = false;
				return bProcessedSuccessfully;
				
			}
			
			if(lead.getLeadId() <= 0) {
				
				leadResponseBean.setStatus("error");
				leadResponseBean.getErrorResponse().setCode("EVER02");
				leadResponseBean.getErrorResponse().getMessages().add("Lead ID cannot be negative.");
				
				bProcessedSuccessfully = false;
				return bProcessedSuccessfully;
				
			}
			
			if(lead.getFirstName() == null || "".equals(lead.getFirstName()) ) {
				
				leadResponseBean.setStatus("error");
				leadResponseBean.getErrorResponse().setCode("EVER03");
				leadResponseBean.getErrorResponse().getMessages().add("First name cannot be null or empty.");
				
				bProcessedSuccessfully = false;
				return bProcessedSuccessfully;
				
			}
			
			if(!lead.getFirstName().matches("^[A-Za-z]+$")) {
				
				leadResponseBean.setStatus("error");
				leadResponseBean.getErrorResponse().setCode("EVER04");
				leadResponseBean.getErrorResponse().getMessages().add("First name should contain only alphabets.");
				
				bProcessedSuccessfully = false;
				return bProcessedSuccessfully;
				
			}
			
			if(lead.getMiddleName() == null || "".equals(lead.getMiddleName()) ) {
				
				leadResponseBean.setStatus("error");
				leadResponseBean.getErrorResponse().setCode("EVER05");
				leadResponseBean.getErrorResponse().getMessages().add("Middle name cannot be null or empty.");
				
				bProcessedSuccessfully = false;
				return bProcessedSuccessfully;
				
			}
			
			if(!lead.getMiddleName().matches("^[A-Za-z]+$")) {
				
				leadResponseBean.setStatus("error");
				leadResponseBean.getErrorResponse().setCode("EVER06");
				leadResponseBean.getErrorResponse().getMessages().add("Middle name should contain only alphabets.");
				
				bProcessedSuccessfully = false;
				return bProcessedSuccessfully;
				
			}

			if(lead.getLastName() == null || "".equals(lead.getLastName()) ) {
				
				leadResponseBean.setStatus("error");
				leadResponseBean.getErrorResponse().setCode("EVER07");
				leadResponseBean.getErrorResponse().getMessages().add("Last name cannot be null or empty.");
				
				bProcessedSuccessfully = false;
				return bProcessedSuccessfully;
				
			}
			
			if(!lead.getLastName().matches("^[A-Za-z]+$")) {
				
				leadResponseBean.setStatus("error");
				leadResponseBean.getErrorResponse().setCode("EVER08");
				leadResponseBean.getErrorResponse().getMessages().add("Last name should contain only alphabets.");
				
				bProcessedSuccessfully = false;
				return bProcessedSuccessfully;
				
			}

			if(lead.getMobileNumber() == null || "".equals(lead.getMobileNumber()) ) {
				
				leadResponseBean.setStatus("error");
				leadResponseBean.getErrorResponse().setCode("EVER09");
				leadResponseBean.getErrorResponse().getMessages().add("mobileNumber cannot be null or empty.");
				
				bProcessedSuccessfully = false;
				return bProcessedSuccessfully;
				
			}
			
			if(!lead.getMobileNumber().matches("^[6-9]\\d{9}$")) {
				
				leadResponseBean.setStatus("error");
				leadResponseBean.getErrorResponse().setCode("EVER10");
				leadResponseBean.getErrorResponse().getMessages().add("Invalid mobileNumber format.");
				
				bProcessedSuccessfully = false;
				return bProcessedSuccessfully;
				
			}

			if(lead.getGender() == null || "".equals(lead.getGender()) ) {
				
				leadResponseBean.setStatus("error");
				leadResponseBean.getErrorResponse().setCode("EVER11");
				leadResponseBean.getErrorResponse().getMessages().add("gender cannot be null or empty.");
				
				bProcessedSuccessfully = false;
				return bProcessedSuccessfully;
				
			}
			
			if(!lead.getGender().matches("^(Male|Female|Others)$")) {
				
				leadResponseBean.setStatus("error");
				leadResponseBean.getErrorResponse().setCode("EVER12");
				leadResponseBean.getErrorResponse().getMessages().add("Invalid gender. Valid values: Male, Female, Others.");
				
				bProcessedSuccessfully = false;
				return bProcessedSuccessfully;
				
			}

			if(lead.getDOB() == null || "".equals(lead.getDOB())) {
				
				leadResponseBean.setStatus("error");
				leadResponseBean.getErrorResponse().setCode("EVER13");
				leadResponseBean.getErrorResponse().getMessages().add("Date cannot be null or empty.");
				
				bProcessedSuccessfully = false;
				return bProcessedSuccessfully;
				
			}
			
			if(!isValidDate(lead.getDOB())) {
				
				leadResponseBean.setStatus("error");
				leadResponseBean.getErrorResponse().setCode("EVER14");
				leadResponseBean.getErrorResponse().getMessages().add("Invalid DOB format. Use " + DATE_FORMAT + " format.");
				
				bProcessedSuccessfully = false;
				return bProcessedSuccessfully;
				
			}

		    
			if(lead.getEmail() == null || "".equals(lead.getEmail()) ) {
				
				leadResponseBean.setStatus("error");
				leadResponseBean.getErrorResponse().setCode("EVER15");
				leadResponseBean.getErrorResponse().getMessages().add("email cannot be null or empty.");
				
				bProcessedSuccessfully = false;
				return bProcessedSuccessfully;
				
			}
			
			if(!lead.getEmail().matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$")) {
				
				leadResponseBean.setStatus("error");
				leadResponseBean.getErrorResponse().setCode("EVER16");
				leadResponseBean.getErrorResponse().getMessages().add("Invalid email format.");
				
				bProcessedSuccessfully = false;
				return bProcessedSuccessfully;
				
			}
			
			bProcessedSuccessfully = true;
			
		}catch(Exception e) {
			
			leadResponseBean.setStatus("error");
			leadResponseBean.getErrorResponse().setCode("E0EX01");
			leadResponseBean.getErrorResponse().getMessages().add("Exception occured in Request Validation service");
			
			bProcessedSuccessfully = false;
			return bProcessedSuccessfully;
		}		
		
		return bProcessedSuccessfully;
		
	}

	 public static boolean isValidDate(String dateStr) {
	        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
	        dateFormat.setLenient(false);

	        try {
	            Date date = dateFormat.parse(dateStr);
	            // Ensure that the parsed date is equal to the input date (to catch cases like "31/02/2022")
	            return dateStr.equals(dateFormat.format(date));
	        } catch (ParseException e) {
	            return false;
	        }
	    }

	
}
