package com.example.demo.payload;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class userpayload { //this layer is duplicate layer of models layer for security i.e hackers may hack this duplicate layer but not main layer
	private int id;
	@Column(name="Username",nullable = false,length=40)//it doesnt accept null values i.e nullable=false and allows only 40 characters not more than that
	@NotEmpty
	private String name;
	@Email
	@NotEmpty
	private String email;
	@Pattern(regexp="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}")
	@Column(length=16)
	@Size(min = 6)
	@NotEmpty
	private String password; //mdoelmapper is connection between this duplicate layer and main layer i.e to send data  to main to duplicate or viceversa we added modelmapper dependency in pomxml
}
