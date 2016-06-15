package gapp.model.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;



@Test(groups = "DepartmentDaoTest")
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class DepartmentDaoTest extends AbstractTransactionalTestNGSpringContextTests {
	
//	@Autowired
//	DepartmentDao departmentdao;
//	
//	@Test
//    public void getDepartments()
//    {
//        assert departmentdao.getDepartments().size() == 2;
//    }
//	

}
