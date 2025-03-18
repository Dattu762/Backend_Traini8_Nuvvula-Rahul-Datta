package com.learning.Assignment.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learning.Assignment.Model.TrainingCenter;
import com.learning.Assignment.Service.TrainingCenterService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/TrainingCenter")
public class TrainingCenterController {
	
	@Autowired
	TrainingCenterService centerService;
	
	@PostMapping("/createCenter")
	public ResponseEntity<?> createTrainingCenter(
			@Valid @RequestBody TrainingCenter trainingCenter) throws Exception{
		
		TrainingCenter newTrainingCenter=centerService.CreateTrainingCenter(trainingCenter);
		
		return new ResponseEntity<>(newTrainingCenter,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/allCenters")
	public ResponseEntity<List<TrainingCenter>> getTrainingCenters(
			@RequestParam(required=false) String city, //adding filter to find centers based on city
			@RequestParam(required=false) String state //adding filter to find centers based on state
			) throws Exception{
		
		List<TrainingCenter> centers=centerService.getCenters(city,state);
		
		return new ResponseEntity<>(centers,HttpStatus.ACCEPTED);
	}
	
	
	
	
}
