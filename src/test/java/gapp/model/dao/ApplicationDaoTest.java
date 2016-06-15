package gapp.model.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import gapp.model.Department;
import gapp.model.Program;


@Test(groups = "ApplicationDaoTest")
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ApplicationDaoTest extends AbstractTransactionalTestNGSpringContextTests {
	
	@Autowired
	ApplicationDao applicationdao;
	
//	@Test
//    public void studentapplication()
//    {
//        assert applicationdao.studentapplication().size() == 1;
//    }
//	
//	@Test
//	public void departmentTest()	{
//		int count = 0;
//		Department dept =  applicationdao.getDepartmentByName("Accounting");
//		System.out.println("Department Programs: "+dept.getPrograms().size());
//		for(Program program : dept.getPrograms()) {
//			if(applicationdao.getApplicationByProgram(program.getId()).getTerm().equalsIgnoreCase("Fall 2016")){
//				count++;
//			}
//		}
//		assert count == 1;
//	}
}