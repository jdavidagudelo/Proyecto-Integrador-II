package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.proyectointegrador.exception.DaoException;
import co.edu.udea.proyectointegrador.service.TbPryProyectosService;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:spring_configuration.xml")
public class TiposProyectoTest {
	@Autowired
	private TbPryProyectosService tbPryProyectosService;
	@Test
	public void testTiposProyecto() throws DaoException
	{
		tbPryProyectosService.findproyectosByEstado(1, 3);
	}
}
