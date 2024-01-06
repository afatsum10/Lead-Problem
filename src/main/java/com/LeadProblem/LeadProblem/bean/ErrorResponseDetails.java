package com.LeadProblem.LeadProblem.bean;

import java.util.ArrayList;
import java.util.List;

public class ErrorResponseDetails {

    private String code = null;
    private List<String> messages = new ArrayList<String>();


    public String getCode() {
        return code;
    }

    public List<String> getMessages() {
        return messages;
    }

	public void setCode(String code) {
		this.code = code;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
    
    
}