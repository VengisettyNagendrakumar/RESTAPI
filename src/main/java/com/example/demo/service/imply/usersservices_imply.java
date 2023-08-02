package com.example.demo.service.imply;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptionhandling.ResourceNotFoundException;
import com.example.demo.model.users;
import com.example.demo.payload.userpayload;
import com.example.demo.repository.usersrepo;
import com.example.demo.service.user_service;
@Service
public class usersservices_imply implements user_service {
    @Autowired
    usersrepo repo; //connnection between this and repository layer usersrepo class
	
	@Autowired //autowired for modelmapper
	ModelMapper modelmapper; //using modelmapper and model mapper is connection between original and duplicate layer
	@Override
	public userpayload addusers(userpayload u) {
		users us=this.dto_users(u);//sending data from duplicate to original i.e model class
		users saveusers=this.repo.save(us); //sending data  to repository to send data to database
		return this.users_dto(saveusers);//retreving data and sending data from duplicate to original here dto means duplicate
	}

	@Override
	public userpayload updateusers(userpayload up, int id) {
		users u=this.repo.findById(id).orElseThrow(()->new ResourceNotFoundException("users", "id", id));
		u.setName(up.getName());
		u.setEmail(up.getEmail());
		u.setPassword(up.getPassword());
		users u1=this.repo.save(u);
		userpayload upd=this.users_dto(u1);
		return upd;
	}

	@Override
	public void deleteusers(int id) {
		users u=this.repo.findById(id).orElseThrow(()->new ResourceNotFoundException("users","id",id));
		this.repo.delete(u);
	}

	@Override
	public List<userpayload> getallusers() {
		List<users> l=(List<users>) this.repo.findAll();//typecasting and fetching all data
		List<userpayload>up=l.stream().map(us->this.users_dto(us)).collect(Collectors.toList());
		return up;
		
		
	}

	@Override
	public userpayload getbyid(int id) {
		users u=this.repo.findById(id).orElseThrow(()->new ResourceNotFoundException("users","id",id));
		return this.users_dto(u);
	}
	
public users dto_users(userpayload up) {  //sending data from duplicate to original i.e model class
	users u=this.modelmapper.map(up, users.class); //control goes to payload and data will be mapped to original class i.e users
	return u;
}
public userpayload users_dto(users up) { //sending data from original to duplicate i.e userspayload
	userpayload us=this.modelmapper.map(up, userpayload.class);
	return us;
}

}

