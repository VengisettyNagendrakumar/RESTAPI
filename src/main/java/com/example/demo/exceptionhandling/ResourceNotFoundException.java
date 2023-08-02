package com.example.demo.exceptionhandling;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResourceNotFoundException extends RuntimeException{
	String ResourceName;
	String FieldName;
	int FieldValue;
	public ResourceNotFoundException(String ResourceName,String FieldName,int FieldValue) {
		super(String.format("%s Not Found with %s:%s",ResourceName,FieldName,FieldValue));
		this.ResourceName=ResourceName;
		this.FieldName=FieldName;
		this.FieldValue=FieldValue;
	}

}
