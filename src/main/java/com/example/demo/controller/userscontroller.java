package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptionhandling.ApiResponse;
import com.example.demo.payload.userpayload;
import com.example.demo.service.imply.usersservices_imply;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class userscontroller {
	@Autowired
	usersservices_imply service; //connection to main service layer
	@PostMapping("insert")
	public ResponseEntity<userpayload>addusers(@Valid @RequestBody userpayload up){ //valid means if data is valid only it will take and response entity is to build and return HTTP responses in postman like 200 created like that
		userpayload user=this.service.addusers(up);
		return new ResponseEntity<>(user,HttpStatus.CREATED); //in postman we will get 200 created 201 created for changing ports and for creating we will give this in place of created if we give continue data will not send to database it will always continue request in postman  but not send data once give continue and check in postman by hitting send button
		
	}
	@PutMapping("update/{id}")
	public ResponseEntity<userpayload>updateusers(@Valid @PathVariable int id,@RequestBody userpayload up){
		userpayload user=this.service.updateusers(up,id);
		return ResponseEntity.ok(user);
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<ApiResponse> deleteusers(@Valid @PathVariable int id){
		this.service.deleteusers(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("id deleted successfully",true),HttpStatus.OK);
	}
	@GetMapping("getall")
	public ResponseEntity<List<userpayload>>getallusers(){
		return ResponseEntity.ok(this.service.getallusers());
	}
	@GetMapping("getbyid/{id}")
	public ResponseEntity<userpayload>getbyid(@Valid @PathVariable int id){
		return ResponseEntity.ok(this.service.getbyid(id)); 
	}
}
