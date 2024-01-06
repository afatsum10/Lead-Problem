package com.LeadProblem.LeadProblem.bean;

import java.util.List;

import com.LeadProblem.LeadProblem.entity.Lead;

public class LeadResponseBean {
	
	private String status = null;
    private String data = null;
    List<Lead> listOfLeads = null;
    private ErrorResponseDetails errorResponse = null;
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

	public ErrorResponseDetails getErrorResponse() {
		return errorResponse;
	}

	public void setErrorResponse(ErrorResponseDetails errorResponse) {
		this.errorResponse = errorResponse;
	}

	public List<Lead> getListOfLeads() {
		return listOfLeads;
	}

	public void setListOfLeads(List<Lead> listOfLeads) {
		this.listOfLeads = listOfLeads;
	}
    
    
    
    
}
