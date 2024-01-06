package com.LeadProblem.LeadProblem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LeadProblem.LeadProblem.bean.ErrorResponseDetails;
import com.LeadProblem.LeadProblem.bean.LeadResponseBean;
import com.LeadProblem.LeadProblem.entity.Lead;
import com.LeadProblem.LeadProblem.repository.LeadRepository;

@Service
public class LeadService {

    @Autowired
    private LeadRepository leadRepository;
    
    @Autowired
    private RequestValidationService validationService;

	public boolean createLead(Lead lead, LeadResponseBean leadResponseBean) {

		boolean bProcessedSuccessfully = false;
		ErrorResponseDetails errorResponse = new ErrorResponseDetails();

		try {

			if (!validationService.LeadRequestValidation(lead, leadResponseBean)) {

				bProcessedSuccessfully = false;
				return bProcessedSuccessfully;

			}

			if (leadRepository.existsByLeadId(lead.getLeadId())) {

				leadResponseBean.setStatus("error");
				errorResponse.setCode("E10010");
				errorResponse.getMessages()
						.add("Lead Already Exists in the database with the lead id");

				bProcessedSuccessfully = false;
				return bProcessedSuccessfully;
			}

			if (leadRepository.existsByEmail(lead.getEmail())) {

				leadResponseBean.setStatus("error");
				errorResponse.setCode("E10010");
				errorResponse.getMessages()
						.add("Lead Already Exists in the database with the email");

				bProcessedSuccessfully = false;
				return bProcessedSuccessfully;

			}

			leadRepository.save(lead);

			bProcessedSuccessfully = true;

		} catch (Exception ex) {

			leadResponseBean.setStatus("error");
			errorResponse.setCode("E10010");
			errorResponse.getMessages().add(ex.getMessage());

			bProcessedSuccessfully = false;
			return bProcessedSuccessfully;

		} finally {

			if (bProcessedSuccessfully) {

				leadResponseBean.setStatus("success");
				leadResponseBean.setData("Created Leads Successfully");

			}else {
				leadResponseBean.setErrorResponse(errorResponse);
				
			}

		}
		return bProcessedSuccessfully;

	}
    
	public boolean getLeadsByMobileNumber(String mobileNumber, LeadResponseBean leadResponseBean) {

		boolean bProcessedSuccessfully = false;
		List<Lead> listOfLeads = null;

		ErrorResponseDetails errorResponse = new ErrorResponseDetails();

		try {

			if (mobileNumber == null || "".equals(mobileNumber)) {

				leadResponseBean.setStatus("error");
				errorResponse.setCode("EVER09");
				errorResponse.getMessages().add("mobileNumber cannot be null or empty.");

				bProcessedSuccessfully = false;
				return bProcessedSuccessfully;
			}

			if (!mobileNumber.matches("^[6-9]\\d{9}$")) {

				leadResponseBean.setStatus("error");
				errorResponse.setCode("EVER10");
				errorResponse.getMessages().add("Invalid mobileNumber format.");

				bProcessedSuccessfully = false;
				return bProcessedSuccessfully;

			}

			listOfLeads = leadRepository.findByMobileNumber(mobileNumber);

			if (listOfLeads.isEmpty()) {

				leadResponseBean.setStatus("error");
				errorResponse.setCode("E10011");
				errorResponse.getMessages().add("No Lead found with the Mobile Number ");

				bProcessedSuccessfully = false;

			} else {

				leadResponseBean.setListOfLeads(listOfLeads);
				bProcessedSuccessfully = true;

			}

		} catch (Exception ex) {

			leadResponseBean.setStatus("error");
			errorResponse.setCode("E0EX01");
			errorResponse.getMessages().add(ex.getMessage());

			bProcessedSuccessfully = false;
			return bProcessedSuccessfully;

		} finally {

			if (bProcessedSuccessfully) {

				leadResponseBean.setStatus("success");
			} else {
				leadResponseBean.setErrorResponse(errorResponse);

			}

		}

		return bProcessedSuccessfully;
	}

}

