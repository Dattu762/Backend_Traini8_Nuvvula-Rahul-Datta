package com.learning.Assignment.Model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	
	
	private String detailedAddress;
	
	private String city;
	
	private String state;
	
	@Pattern(regexp = "^[0-9]{6}$",message = "Enter Valid Pincode")
	private String pincode;
}
