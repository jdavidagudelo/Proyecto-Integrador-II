package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.proyectointegrador.exception.DaoException;
import co.edu.udea.proyectointegrador.service.TbPryObjetivosespecificosService;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:spring_configuration.xml")
public class ObjetivosespecificosTest {
	@Autowired
	private TbPryObjetivosespecificosService service;
	@Test
	public void testObjetivo() throws DaoException
	{
		service.insert("juan", "Hacer algo",10l, 1);
	}
}
