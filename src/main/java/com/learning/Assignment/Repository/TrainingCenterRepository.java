package com.learning.Assignment.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.Assignment.Model.TrainingCenter;

@Repository
public interface TrainingCenterRepository extends JpaRepository<TrainingCenter,String> {
	
	TrainingCenter findByContactEmail(String ContactEmail);	//Finding the center based on the email.
	
	TrainingCenter findByContactPhone(String ContactPhone); // Finding the center based on Contact.
	
	List<TrainingCenter> findByAddress_City(String city); // Filtering all the centers based on city
	
	List<TrainingCenter> findByAddress_State(String state); // Filtering all the centers based on state
}
