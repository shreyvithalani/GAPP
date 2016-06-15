package gapp.model.dao;

import java.util.List;

import gapp.model.Program;

public interface ProgramDao {
	
	Program submitProgram(Program program);
	
	Program getProgram(Long id);
	
	void removeProgram(Program program);
	
	List<Program> getProgram();

}
