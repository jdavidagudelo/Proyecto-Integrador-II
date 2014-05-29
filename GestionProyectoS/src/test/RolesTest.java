package test;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.proyectointegrador.exception.DaoException;
import co.edu.udea.proyectointegrador.service.TbAdmRolesxpermisosService;
import co.edu.udea.proyectointegrador.service.TbPryObjetivosespecificosService;
import co.edu.udea.proyectointegrador.service.TbPryProyectosService;
import co.edu.udea.proyectointegrador.service.TbPryRolesxpermisosestadosproyectoService;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:spring_configuration.xml")
public class RolesTest {
	@Autowired
	private TbAdmRolesxpermisosService rolesService;
	@Autowired 
	TbPryProyectosService proyec;
	@Autowired
	TbPryObjetivosespecificosService service;
	@Autowired
	TbPryRolesxpermisosestadosproyectoService pr;
	@Test
	public void printTests() throws DaoException, URISyntaxException, IOException
	{
		
	}
	
}
