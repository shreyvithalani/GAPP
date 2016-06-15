package gapp.model.dao;

import gapp.model.Degrees;


public interface DegreesDao {
	
	Degrees SubmitDegrees(Degrees degrees);
	
	
	void removeDegree(Degrees degree);
	
	Degrees getDegree(Long id);
}
