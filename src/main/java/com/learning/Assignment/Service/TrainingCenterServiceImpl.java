package com.learning.Assignment.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.Assignment.Model.TrainingCenter;
import com.learning.Assignment.Repository.TrainingCenterRepository;

@Service
public class TrainingCenterServiceImpl implements TrainingCenterService {
	
	@Autowired
	TrainingCenterRepository centerRepo;
	
	@Override
	public TrainingCenter CreateTrainingCenter(TrainingCenter trainingCenter) throws Exception {
		TrainingCenter training_center=new TrainingCenter();
		
		//validating whether the training center with email already exists.
		if(centerRepo.findByContactEmail(trainingCenter.getContactEmail())!=null) throw new Exception("Center with Email already exists");
		
		//validating whether the training center with ContactPhone already exists.
		if(centerRepo.findByContactPhone(trainingCenter.getContactPhone())!=null) throw new Exception("Center with ContactPhone already exists");
		
		training_center.setCenterCode(trainingCenter.getCenterCode());
		training_center.setCenterName(trainingCenter.getCenterName());
		training_center.setAddress(trainingCenter.getAddress());
		training_center.setStudentCapacity(trainingCenter.getStudentCapacity());
		training_center.setCoursesOffered(trainingCenter.getCoursesOffered());
		
		//setting the CreatedOn timestamp
		training_center.setCreatedOn(LocalDateTime.now()); 
		
		training_center.setContactEmail(trainingCenter.getContactEmail());
		training_center.setContactPhone(trainingCenter.getContactPhone());
		
		return centerRepo.save(training_center); //Saving the center in database and returning it.
	}

	@Override
	public List<TrainingCenter> getCenters(String city, String state) {
		
		if(city!=null) return centerRepo.findByAddress_City(city); // Fetching the centers based on city.
		
		if(state!=null) return centerRepo.findByAddress_State(state); //Fetching the centers based on state.
		
		return centerRepo.findAll();  // Returning all the centers.	 	
	}

}
