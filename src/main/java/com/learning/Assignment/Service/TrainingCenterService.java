package com.learning.Assignment.Service;

import java.util.List;

import com.learning.Assignment.Model.TrainingCenter;

public interface TrainingCenterService {
	
	TrainingCenter CreateTrainingCenter(TrainingCenter trainingCenter) throws Exception;
	
	List<TrainingCenter> getCenters(String city,String state) throws Exception;
}
