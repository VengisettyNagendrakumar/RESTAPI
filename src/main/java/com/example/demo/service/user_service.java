package com.example.demo.service;

import java.util.List;

import com.example.demo.payload.userpayload;

public interface user_service { //sending data to payload i.e duplicate data
	userpayload addusers(userpayload u); //return type is userspayload
	userpayload updateusers(userpayload up,int id); 
	void deleteusers(int id); //return type void
    List<userpayload>getallusers();
    userpayload getbyid(int id);  // these all are empty implementation methodsthese all methods are overrided after in main service layer this is duplicate service layer so thats why we create this as interface 
	//original class is usersservices_imply 

}
