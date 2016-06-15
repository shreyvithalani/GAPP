package gapp.model.dao;

import gapp.model.Additional;

public interface AdditionalDao {
	
	Additional submitAdditional(Additional additional);
	
	Additional getAdditional(Long id);
	
	void removeAdditional(Additional additional);

}
