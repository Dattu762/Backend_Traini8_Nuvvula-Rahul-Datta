package com.learning.Assignment.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainingCenter {
	
	@Id
	@Pattern(regexp = "^[a-zA-Z0-9]{12}$", message = "Center code should be exactly 12 characters")
	private String centerCode;
	
	@Size(max = 40,message = "Center name must be less than 40 characters")
	private String centerName;
	
	@Valid
	@Embedded
	private Address address;
	
	private int studentCapacity;
	private List<String> coursesOffered=new ArrayList<>();
	private LocalDateTime createdOn;
	
	@Email(message = "Enter valid Email")
	private String contactEmail;
	
	@Pattern(regexp = "^\\+?[0-9]{10,13}$", message = "Enter valid Contact Number")
	private String contactPhone;
}
