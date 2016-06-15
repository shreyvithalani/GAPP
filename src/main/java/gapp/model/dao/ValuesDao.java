package gapp.model.dao;

import gapp.model.Values;

public interface ValuesDao {
	
	public Values getValue(Long id);
	
	public Values saveValue(Values value);

}
